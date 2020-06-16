package com.perficient.helm.test.util;

import java.util.Random;

public class StringValueProviderHelper {

    protected static final String generateStringOfLength(long stringLength) {

        if (0 > stringLength) {
            return null;
        }

        if (0 == stringLength) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        long characterCount = 1;
        long characterInterval = 1;
        if (stringLength < Character.MAX_VALUE) {
            characterInterval = (int) Character.MAX_VALUE / stringLength - 1;
        }
        while (characterCount < stringLength) {
            sb.append((char) ((characterCount * characterInterval) % Character.MAX_VALUE));
            characterCount++;
        }

        return sb.toString();
    }

    private static final Boolean isLetterOrDigit(int c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }

        // check if ch is a digit
        if (c >= '0' && c <= '9') {
            return true;
        }
        
        // check if ch is a whitespace
        if ((c == ' ') || (c == '\n') || (c == '\t')) {
            return true;
        }

        return false;
    }
}
