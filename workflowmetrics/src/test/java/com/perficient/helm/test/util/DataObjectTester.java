package com.perficient.helm.test.util;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public class DataObjectTester {

    private static final ValueProviders providers = new ValueProviders();

    public void testPassedClasses(String[] classes) {

        testPassedClasses(new ArrayList<String>(Arrays.asList(classes)));

    }

    /**
     * For each class name passed in the array list, this method executes the
     * constructors and setters/getters/is*, hashcode, equals, and toString methods
     * for the class for a variety of test data inputs, and ensures that the methods
     * behave appropriately. It is intended to cut down on the manual unit test
     * development that a developer needs to do to meet code coverage standards.
     * 
     * @param classes
     *                    The names (Strings) of the classes to be tested.
     */
    public void testPassedClasses(ArrayList<String> classes) {

        // Loop through the classes, and test each one
        for (String className : classes) {

            // Get a the class for each class name passed
            Class<?> classToBeTested = getClassForName(className);

            // Get Constructors for the class, so that we can validate the constructor, and
            // instantiate the class
            Constructor<?>[] constructors = getConstructors(classToBeTested);

            // Get the parameters for each constructor, and put them in a map, keyed by the
            // constructor
            HashMap<Constructor<?>, HashMap<Integer, DataObjectTesterParameterList>> constructorsAndParameters = getConstructorAndParameterHashMap(
                    constructors);

            Object[] objects = instantiateObjectsFromConstructorAndParameterMap(constructorsAndParameters);

            for (Object o : objects) {
                System.out.println(o);
                assertEquals(className.toUpperCase(), o.getClass().getCanonicalName().toUpperCase());
            }
        }
    }

    /**
     * Returns a {@link java.lang.Class} object associated with the passed name.
     * 
     * @param name
     *                 Fully qualified name of the desired class
     * @return the desired class
     */
    private Class<?> getClassForName(String name) {

        Class<?> clazz = null;
        try {
            clazz = Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clazz;
    }

    /**
     * Returns an array of @{link java.reflect.Constructor}s for the given class
     * 
     * @param clazz
     *                  Class for which we're identifying the constructors
     * @return an array of constructors for the passed class
     */
    private Constructor<?>[] getConstructors(final Class clazz) {

        Constructor<?>[] constructors = null;

        if (null != clazz) {
            constructors = clazz.getConstructors();
        }

        if (null == constructors) {
            throw new RuntimeException("No constructors available for class " + clazz.getCanonicalName());
        }

        return constructors;
    }

    /**
     * Uses the passed constructor to instantiate a list of objects with the
     * parameters in the parameter map for that constructor.
     * 
     * If for any reason the constructor throws an exception, this method will
     * simply fail an assertion that the constructor works, and show the parameters
     * for which the constructor failed.
     * 
     * 
     * @param constructorsAndParameters
     *                                      A {@link java.util.HashMap} of
     *                                      constructors and values, where the
     *                                      constructor is the key for the map, and
     *                                      each value is a list of parameters, and
     *                                      possible values for that parameter.
     * @return An array of instantiated objects; instantiated with all combinations
     *             of the values for the parameters in the parameter map.
     */
    private Object[] instantiateObjectsFromConstructorAndParameterMap(
            HashMap<Constructor<?>, HashMap<Integer, DataObjectTesterParameterList>> constructorsAndParameters) {

        ArrayList<Object> objects = new ArrayList<Object>();
        for (Constructor<?> c : constructorsAndParameters.keySet()) {

            for (Object o : instantiateObjectsFromParameterLists(c, constructorsAndParameters.get(c))) {
                objects.add(o);
            }
        }

        return objects.toArray();

    }

    private ArrayList<Object> instantiateObjectsFromParameterLists(Constructor<?> c,
            HashMap<Integer, DataObjectTesterParameterList> parameterPositionsAndTestValues) {

        // Set up the list of objects to return
        ArrayList<Object> objects = new ArrayList<Object>();

        // If we have a constructor with no parameters (i.e. the default constructor),
        // execute it,and return the object
        System.out.println("Parameter Count:  " + c.getParameterCount());
        if (0 == c.getParameterCount()) {
            try {
                objects.add(c.newInstance());
                return objects;
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        // Get the number of parameter positions for the constructor, and create a
        // parameter array for that number of positions
        final int lastParameterPosition = c.getParameterCount() - 1;
        Object[] parameters = new Object[c.getParameterCount()];

        int[] testValueArrayPositions = new int[c.getParameterCount()];
        int lowestParameterAdjusted = lastParameterPosition;
        int currentParameterIndex = lastParameterPosition;

        Arrays.fill(testValueArrayPositions, 0);

        while (lowestParameterAdjusted >= 0) {

            // Get the parameters for the current parameterIndexes
            fillParameterArray(parameters, testValueArrayPositions, parameterPositionsAndTestValues);

            testValueArrayPositions[currentParameterIndex]++;

            // Use the constructor to instantiate an object, given the set of parameters
            try {
                objects.add(c.newInstance(parameters));
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            if (isLastTestValueForParameter(currentParameterIndex, testValueArrayPositions[currentParameterIndex],
                    parameterPositionsAndTestValues.get(currentParameterIndex))) {

                // We're on the last parameter, and we've run out of test values; just return
                // the object array
                if (0 == currentParameterIndex) {
                    return objects;
                }

                // Decrement the current parameter index
                currentParameterIndex--;

                // If the "new" currentParameterIndex != the lowestParameterAdjusted, then try
                // to increment the testValueArrayPositions[currentParameterIndex] value. If we
                // can't, then decrement the currentParameterIndex until it's either 0 or we can
                // increment the testValueArrayPosition[currentParameterIndex] value.
                if (currentParameterIndex >= lowestParameterAdjusted) {

                    while (testValueArrayPositions[currentParameterIndex] >= parameterPositionsAndTestValues
                            .get(currentParameterIndex).getValue().length - 1) {
                        if (0 == currentParameterIndex) {
                            return objects;
                        } else {

                            currentParameterIndex--;
                            if (currentParameterIndex < lowestParameterAdjusted) {
                                lowestParameterAdjusted = currentParameterIndex;
                            }
                        }
                    }
                    // Since we got here, we know that we can increment the testValueArrayPositions
                    // value. We know that we WANT to do that, because we've already run the test
                    // for the initial value in other passes, so we don't need to repeat that test.
                    testValueArrayPositions[currentParameterIndex]++;
                }

                // So what if our decrement of the currentParameterIndex lands us below the
                // lowestParameterAdjusted?
                if (currentParameterIndex < lowestParameterAdjusted) {
                    // Well, we've already moved to the second item in the
                    // test data array for the current position, so we can set the
                    // lowestParameterAdjusted value to be the currentParameterIndex.
                    lowestParameterAdjusted = currentParameterIndex;

                    // Since we got here, we know that we can increment the testValueArrayPositions
                    // value. We know that we WANT to do that, because we've already run the test
                    // for the initial value in other passes, so we don't need to repeat that test.
                    testValueArrayPositions[currentParameterIndex]++;
                }

                // We also know that we can reset the values to the right of the
                // currentParameterIndex
                resetTestValueArrayPositions(currentParameterIndex, testValueArrayPositions);

                // Since we've done all of that, we now need to start back at the last
                // parameter, and do our increments.
                currentParameterIndex = lastParameterPosition;
            }
        }
        return null;
    }

    private void fillParameterArray(Object[] parameters, int[] testValueArrayPositions,
            HashMap<Integer, DataObjectTesterParameterList> parameterPositionsAndTestValues) {
        for (int parameterPosition = 0; parameterPosition < parameters.length; parameterPosition++) {
            parameters[parameterPosition] = parameterPositionsAndTestValues.get(parameterPosition)
                    .getValue()[testValueArrayPositions[parameterPosition]];
        }
    }

    /**
     * Check to see if there are any remaining test parameters in the list of test
     * parameters for the parameter position passed
     * 
     * @param currentParameterIndex
     * @param testValueArrayPosition
     * @param dataObjectTesterParameterList
     * @return
     */
    private Boolean isLastTestValueForParameter(int currentParameterIndex, int testValueArrayPosition,
            DataObjectTesterParameterList dataObjectTesterParameterList) {
        if (null == dataObjectTesterParameterList) {
            return true;
        } else {
            return (testValueArrayPosition >= dataObjectTesterParameterList.getValue().length);

        }
    }

    /**
     * Sets all of the test array positions for parameters whose position is greater
     * than the current column to zero (resetting the test values)
     * 
     * @param currentParameterPosition
     *                                     Parameters with positions less than or
     *                                     equal to this value will be un-altered
     * @param parameterIndexes
     *                                     The array of test parameter value
     *                                     positions that will have values reset
     */
    private void resetTestValueArrayPositions(final int currentParameterPosition, int[] parameterIndexes) {
        for (int workingParameterPosition = parameterIndexes.length
                - 1; workingParameterPosition > currentParameterPosition; workingParameterPosition--) {
            parameterIndexes[workingParameterPosition] = 0;
        }

    }

    /**
     * Sets the parameter array for a constructor or method.
     * 
     * Assumes that the parameters are kept in the hashMap, indexed by the parameter
     * index, and that there are 1 to n values in each parameter index. The
     * parameterIndexes array identifies which value from the parameter list we
     * should choose, by position.
     * 
     * @param parameters
     *                             The array of Objects to be updated with method
     *                             test values
     * @param parameterIndexes
     *                             An array of integers representing the position
     *                             within each parameter list of the parameter that
     *                             we want to select
     * @param hashMap
     *                             The hashmap of parameter positions, and list of
     *                             potential parameter values
     */
    private void getParametersForEachPosition(Object[] parameters, final int[] parameterIndexes,
            final HashMap<Integer, DataObjectTesterParameterList> hashMap) {
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = hashMap.get(Integer.valueOf(parameterIndexes[i]));
        }
    }

    /**
     * Based on the current parameter position,
     * 
     * @param currentParameterPosition
     * @param currentParameterIndexes
     * @return
     */
    private int[] reinitializeParameterIndexes(final int currentParameterPosition,
            final int[] currentParameterIndexes) {
        // TODO: This isn't even close!!

        return null;
    }

    private HashMap<Constructor<?>, HashMap<Integer, DataObjectTesterParameterList>> getConstructorAndParameterHashMap(
            final Constructor<?>[] constructors) {

        HashMap<Constructor<?>, HashMap<Integer, DataObjectTesterParameterList>> parameterMap = new HashMap<Constructor<?>, HashMap<Integer, DataObjectTesterParameterList>>();
        if (null != constructors && constructors.length > 0) {
            Parameter[] parameters = null;
            for (Constructor<?> c : constructors) {
                parameters = c.getParameters();
                parameterMap.put(c, getParameterTestValues(parameters));
            }
        }
        return parameterMap;
    }

    /**
     * Interrogates each parameter for its type, and attempts to retrieve a provider
     * for a list of test instances of that type to pass as parameters in the test
     * of the containing object.
     * 
     * This method uses the
     * {@link com.perficient.helm.test.util.ValueProviders} class to get a
     * provider for the list of parameter instances for the given type. If there is
     * not a provider for the object type, the method will add a null object to the
     * parameter list, and will attempt to invoke the default (empty) constructor on
     * the object, and add the resultant object to the list of parameters. If the
     * object cannot be constructed with an empty constructor, at the moment, we
     * through an {@link java.lang.IllegalArgumentException}
     * 
     * @param parameters
     *                       Array of {@link java.lang.reflect.Parameter}s for which
     *                       we want to get test values
     * @return a {@link java.util.Hashmap} of lists of parameters, keyed by the
     *             position in which the parameter must be passed.
     */
    private HashMap<Integer, DataObjectTesterParameterList> getParameterTestValues(final Parameter[] parameters) {
        int parameterCount = 0;
        Integer parameterPosition;
        HashMap<Integer, DataObjectTesterParameterList> parameterMap = new HashMap<Integer, DataObjectTesterParameterList>();

        for (Parameter p : parameters) {
            parameterPosition = Integer.valueOf(parameterCount);
            parameterCount++;

            Supplier<List<Object>> provider = providers.getProvider(p.getType());
            if (null == provider) {
                throw new IllegalArgumentException(
                        "No test value provider can be found for class " + p.getType().getCanonicalName());
            }

            DataObjectTesterParameterList dotp = new DataObjectTesterParameterList(p.getType(), provider.get());

            parameterMap.put(parameterPosition, dotp);
        }

        return parameterMap;
    }

    private ArrayList<Method> getMethods(String className) {

        ArrayList<Method> methods = new ArrayList<Method>();

        try {
            methods = new ArrayList<Method>(Arrays.asList(Class.forName(className).getMethods()));
        } catch (ClassNotFoundException e) {
            // Want to log that the class didn't exist, but we can continue with an empty
            // method array.
            // throw new RuntimeException(e);
        }

        return methods;
    }
}
