package com.dtcc.workflowmetrics.test.util;

public class PrimitiveValueLists {

    public static final byte[] bytes = new byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE / 4, Byte.MAX_VALUE / 2,
            (byte) ((Byte.MAX_VALUE / 4) * 3), Byte.MAX_VALUE };
    public static final char[] chars = new char[] { Character.MIN_VALUE, (char) (Character.MAX_VALUE / 4),
            (char) Character.MAX_VALUE / 2, 'a', 'b', 'c', '0', '1', '2', (char) ((Character.MAX_VALUE / 4) * 3),
            Character.MAX_VALUE };
    public static final short[] shorts = new short[] { Short.MIN_VALUE, -5, 0, 5, Short.MAX_VALUE };
    public static final int[] integers = new int[] { Integer.MIN_VALUE, -5, 0, 5, Integer.MAX_VALUE };
    public static final long[] longs = new long[] { Long.MIN_VALUE, -5l, 0l, 5l, Long.MAX_VALUE };
    public static final float[] floats = new float[] { Float.MIN_VALUE, (float) (Math.PI * -1), (1 / 7) * -1, -1, 0, 1,
            (1 / 7), (float) Math.PI, Float.MAX_VALUE };
    public static final double[] doubles = new double[] { Double.MIN_VALUE, (double) (Math.PI * -1), (1 / 7) * -1, -1,
            0, 1, (1 / 7), (double) Math.PI, Double.MAX_VALUE };
    public static final String[] strings = new String[] { StringValueProviderHelper.generateStringOfLength(-1),
            StringValueProviderHelper.generateStringOfLength(0), StringValueProviderHelper.generateStringOfLength(10)
            //StringValueProviderHelper.generateStringOfLength(15)
            // StringValueProviderHelper.generateStringOfLength(1073741824 / 2) 
            };

}
