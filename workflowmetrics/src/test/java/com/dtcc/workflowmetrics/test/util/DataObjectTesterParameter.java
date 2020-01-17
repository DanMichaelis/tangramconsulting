package com.dtcc.workflowmetrics.test.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import java.util.Set;

import org.assertj.core.util.Arrays;

import antlr.collections.List;

public class DataObjectTesterParameter {
    private Class objectClass;
    private Object value;
    
    public DataObjectTesterParameter(Class clazz, Object value) {
        this.objectClass = clazz;
        this.value = value;
    }
    
    public Class getObjectClass() {
        return this.objectClass;
    }
    
    public Object getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((objectClass == null) ? 0 : objectClass.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DataObjectTesterParameter other = (DataObjectTesterParameter) obj;
        if (objectClass == null) {
            if (other.objectClass != null) {
                return false;
            }
        } else if (!objectClass.getCanonicalName().equals(other.objectClass.getCanonicalName())) {
            return false;
        }
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DataObjectTesterParameter [objectClass=");
        builder.append(objectClass);
        builder.append(", value=");
        builder.append(valueToString(value));
        builder.append("]");
        return builder.toString();
    }

    private String valueToString(Object o) {
        
        System.out.println("Object class:  " + o.getClass().getCanonicalName());
       
        StringBuilder sb = new StringBuilder();
        
        if (o instanceof Iterable) {
            Iterator<Object> i = ((Iterable<Object>) o).iterator();
            return iterableToString(i);
        }
        
        if (o instanceof Map) {
            Map map = (Map) o;
            sb.append("[");
            Set keySet = map.keySet();
            Iterator i = keySet.iterator();
            Object obj;
            if (i.hasNext()) {
                obj = i.next();
                sb.append("{" + obj.toString() + ", " + map.get(obj).toString());
            }
            while (i.hasNext()) {
                obj = i.next();
                sb.append("}, {" + obj.toString() + ", " + map.get(obj).toString());
            }
            if (!keySet.isEmpty()) {
                sb.append("}");
            }
            sb.append("]");
            return sb.toString();
        }
        
        if (null != o && o.getClass().isArray()) {
            System.out.println("Got Here!");
           ArrayList l = new ArrayList(Arrays.asList(o));
           Iterator<Object> i = l.iterator();
           return iterableToString(i);
        }
        
        return sb.toString();
    }
    
    private String iterableToString(Iterator i) {
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");        
        
        if (i.hasNext()) {
            sb.append(i.next().toString());
        }
        while (i.hasNext()) {
            sb.append(", " + i.next().toString());
        }
        sb.append("]");
        
        return sb.toString();   
    }
}
