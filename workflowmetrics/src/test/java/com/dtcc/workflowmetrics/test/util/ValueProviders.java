package com.dtcc.workflowmetrics.test.util;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * This class provides a set of value generators for Java primitives and some
 * "standard" classes (i.e. String, ...) to be used in both constructors for
 * objects, and in setters.
 * 
 * @author dan.michaelis
 *
 */
public class ValueProviders {

    private static HashMap<Class<?>, Supplier<?>> defaultValueProviders = new HashMap<Class<?>, Supplier<?>>();
    private HashMap<Class<?>, Supplier<?>> customValueProviders = new HashMap<Class<?>, Supplier<?>>();

    public ValueProviders() {
        if (defaultValueProviders.isEmpty()) {
            defaultValueProviders.put(byte.class, () -> {
                return PrimitiveValueLists.bytes;
            });
            defaultValueProviders.put(char.class, () -> {
                return PrimitiveValueLists.chars;
            });
            defaultValueProviders.put(short.class, () -> {
                return PrimitiveValueLists.shorts;
            });
            defaultValueProviders.put(int.class, () -> {
                return PrimitiveValueLists.integers;
            });
            defaultValueProviders.put(long.class, () -> {
                return PrimitiveValueLists.longs;
            });
            defaultValueProviders.put(float.class, () -> {
                return PrimitiveValueLists.floats;
            });
            defaultValueProviders.put(double.class, () -> {
                return PrimitiveValueLists.doubles;
            });
            defaultValueProviders.put(String.class, () -> {
                return PrimitiveValueLists.strings;
            });
        }
    }

    public void addCustomProvider(Class<?> clazz, Supplier<?> supplier) {
        customValueProviders.put(clazz, supplier);
    }

    public void setCustomProviders(HashMap<Class<?>, Supplier<?>> providers) {
        this.customValueProviders = providers;
    }

    public Supplier<?> getProvider(Class c) {
        Supplier<?> provider = customValueProviders.get(c);
        if (null == provider) {
            provider = defaultValueProviders.get(c);
        }
        return provider;
    }

}
