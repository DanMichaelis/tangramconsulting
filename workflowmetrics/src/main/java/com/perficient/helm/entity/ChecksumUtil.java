package com.perficient.helm.entity;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import com.perficient.helm.exception.MetricsLogicException;

public class ChecksumUtil {
    
    private ChecksumUtil() {
        
    }
    
    public static final String getChecksum(String s) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(s.getBytes("UTF-8"));
            sb.append(bytesToHex(hash));
        } catch(Exception e) {
            throw new MetricsLogicException(e);
        }
        return sb.toString();
    }
    
    /**
     * Use javax.xml.bind.DatatypeConverter class in JDK to convert byte array
     * to a hexadecimal string. Note that this generates hexadecimal in lower case.
     * @param hash
     * @return 
     */
    private static final String bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash).toLowerCase();
    }
}
