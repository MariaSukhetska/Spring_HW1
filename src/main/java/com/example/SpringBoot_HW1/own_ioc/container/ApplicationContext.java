package com.example.SpringBoot_HW1.own_ioc.container;

import com.example.SpringBoot_HW1.own_ioc.annotation.Component;
import com.example.SpringBoot_HW1.own_ioc.exception.BeanNotFoundException;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private final Map<Class<?>, Object> beans = new HashMap<>();

    public ApplicationContext(String packageName) {
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().acceptPackages(packageName).scan()) {
            for (ClassInfo classInfo : scanResult.getClassesWithAnnotation(Component.class.getName())) {
                Class<?> clazz = Class.forName(classInfo.getName());
                Constructor<?> constructor = clazz.getConstructors()[0];
                if (constructor.getParameterCount() == 0) {
                    Object instance = constructor.newInstance();
                    beans.put(clazz, instance);
                }
            }

            for (ClassInfo classInfo : scanResult.getClassesWithAnnotation(Component.class.getName())) {
                Class<?> clazz = Class.forName(classInfo.getName());
                if (!beans.containsKey(clazz)) {
                    Constructor<?> constructor = clazz.getConstructors()[0];
                    Object[] params = new Object[constructor.getParameterCount()];
                    for (int i = 0; i < constructor.getParameterCount(); i++) {
                        params[i] = getBean(constructor.getParameterTypes()[i]);
                    }
                    Object instance = constructor.newInstance(params);
                    beans.put(clazz, instance);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize ApplicationContext", e);
        }
    }

    public <T> T getBean(Class<T> clazz) {
        T bean = clazz.cast(beans.get(clazz));
        if (bean == null) {
            throw new BeanNotFoundException("Bean not found for class: " + clazz.getName());
        }
        return bean;
    }
}
