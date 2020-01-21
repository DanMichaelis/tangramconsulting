package com.dtcc.workflowmetrics.test.util;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DataObjectTester {
    
    private static final ValueProviders providers = new ValueProviders();

    public void testPassedClasses(String[] classes) {
        
        testPassedClasses(new ArrayList<String>(Arrays.asList(classes)));

    }

    public void testPassedClasses(ArrayList<String> classes) {

        // Loop through the classes, and test each one
        for (String className : classes) {

            // Get a Class instance for each class passed
            try {
                Class classToBeTested = Class.forName(className);

                // Get Constructors for the class, so that we can validate the constructor, and
                // instantiate the class
                Constructor[] constructors = classToBeTested.getConstructors();

                // For each constructor, instantiate the class
                for (Constructor c : constructors) {

                    // Get the arguments for the constructor
                    Parameter[] parameters = c.getParameters();
                    
                    // For the list of parameters, construct a list of hashmaps of DataObjectTesterParameters to be used to test the constructor
                    HashMap<Integer, DataObjectTesterParameter> parameterMap = buildParameterHashmap(parameters);
                    
                    System.out.println("Parameter Map:  " + parameterMap.toString());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private HashMap<Integer, DataObjectTesterParameter> buildParameterHashmap(Parameter[] parameters) {
        int parameterCount = 0;
        Integer parameterPosition;
        HashMap<Integer, DataObjectTesterParameter> parameterMap = new HashMap<Integer, DataObjectTesterParameter>();
        
        
        for (Parameter p : parameters) {
            parameterPosition = Integer.valueOf(parameterCount);
            parameterCount++;
            
            DataObjectTesterParameter dotp = new DataObjectTesterParameter(p.getType(), providers.getProvider(p.getType()).get());
            
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
