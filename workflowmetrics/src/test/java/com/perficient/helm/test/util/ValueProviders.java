package com.perficient.helm.test.util;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

import org.assertj.core.util.Arrays;

/**
 * This class provides a set of value generators for Java primitives and some
 * "standard" classes (i.e. String, ...) to be used in both constructors for
 * objects, and in setters.
 * 
 * @author dan.michaelis
 *
 */
public class ValueProviders {

    private static HashMap<Class<?>, Supplier<List<Object>>> defaultValueProviders = new HashMap<Class<?>, Supplier<List<Object>>>();
    private HashMap<Class<?>, Supplier<List<Object>>> customValueProviders = new HashMap<Class<?>, Supplier<List<Object>>>();

    public ValueProviders() {
        if (defaultValueProviders.isEmpty()) {
            defaultValueProviders.put(byte.class, () -> {
                return Arrays.asList(PrimitiveValueLists.bytes);
            });
            defaultValueProviders.put(char.class, () -> {
                return Arrays.asList(PrimitiveValueLists.chars);
            });
            defaultValueProviders.put(short.class, () -> {
                return Arrays.asList(PrimitiveValueLists.shorts);
            });
            defaultValueProviders.put(int.class, () -> {
                return Arrays.asList(PrimitiveValueLists.integers);
            });
            defaultValueProviders.put(long.class, () -> {
                return Arrays.asList(PrimitiveValueLists.longs);
            });
            defaultValueProviders.put(float.class, () -> {
                return Arrays.asList(PrimitiveValueLists.floats);
            });
            defaultValueProviders.put(double.class, () -> {
                return Arrays.asList(PrimitiveValueLists.doubles);
            });
            defaultValueProviders.put(String.class, () -> {
                return Arrays.asList(PrimitiveValueLists.strings);
            });
        }
    }

    public void addCustomProvider(Class<?> clazz, Supplier<List<Object>> supplier) {
        customValueProviders.put(clazz, supplier);
    }

    public void setCustomProviders(HashMap<Class<?>, Supplier<List<Object>>> providers) {
        this.customValueProviders = providers;
    }

    public Supplier<List<Object>> getProvider(Class c) {
        Supplier<List<Object>> provider = customValueProviders.get(c);
        if (null == provider) {
            provider = defaultValueProviders.get(c);
        }
        
        if (null == provider) {
            throw new RuntimeException("Class " + c.getCanonicalName() + " does not have a supported provider, and can't be supplied by the object test framework");
        }
        return provider;
    }

}
