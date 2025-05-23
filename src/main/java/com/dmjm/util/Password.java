package com.dmjm.util;

import java.security.MessageDigest;

public class Password {

    public static String sha512(String cadena) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(cadena.getBytes());
            byte[] mb = md.digest();
            for (byte element : mb) {
                sb.append(Integer.toString((element & 0xFF) + 256, 16).substring(1));
            }
        } catch (java.security.NoSuchAlgorithmException e) {
            e.getMessage();
        }

        return sb.toString();
    }
}
