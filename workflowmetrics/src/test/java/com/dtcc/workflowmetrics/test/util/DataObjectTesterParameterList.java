package com.dtcc.workflowmetrics.test.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class DataObjectTesterParameterList {
    private Class objectClass;
    private Object[] values;;

    public DataObjectTesterParameterList(Class clazz, List<Object> values) {
        this.objectClass = clazz;

        if (null != values && ! values.isEmpty()) {
            this.values = new Object[values.size()];
            values.toArray(this.values);
        }
    }

    public Class getObjectClass() {
        return this.objectClass;
    }

    public Object[] getValue() {
        return this.values;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((objectClass == null) ? 0 : objectClass.hashCode());
        result = prime * result + java.util.Arrays.deepHashCode(values);
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
        DataObjectTesterParameterList other = (DataObjectTesterParameterList) obj;
        if (objectClass == null) {
            if (other.objectClass != null) {
                return false;
            }
        } else if (!objectClass.equals(other.objectClass)) {
            return false;
        }
        if (!java.util.Arrays.deepEquals(values, other.values)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DataObjectTesterParameter [objectClass=");
        builder.append(objectClass);
        builder.append(", values=");
        builder.append(Arrays.deepToString(values));
        // builder.append(valueToString(values));
        builder.append("]");
        return builder.toString();
    }

    private String valueToString(Object o) {

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
            ArrayList l = new ArrayList(Arrays.asList(o));
            Iterator<Object> i = l.iterator();
            if (null != i) {
                return iterableToString(i);
            }
        }

        if (null != o) {
            sb.append(o.toString());
        }

        return sb.toString();
    }

    private String iterableToString(Iterator i) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Object o;

        if (i.hasNext()) {
            o = i.next();
            if (null != o) {
                sb.append(o.toString());
            } else {
                sb.append("null");
            }
        }
        while (i.hasNext()) {
            sb.append(", " + i.next().toString());
        }
        sb.append("]");

        return sb.toString();
    }
}
