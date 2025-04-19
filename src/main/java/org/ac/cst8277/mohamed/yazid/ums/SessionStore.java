package org.ac.cst8277.mohamed.yazid.ums;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionStore {
    private static final Map<String, String> tokenStore = new HashMap<>();

    public static String generateToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenStore.put(token, username);
        return token;
    }

    public static boolean isValidToken(String token) {
        return tokenStore.containsKey(token);
    }

    public static String getUsernameByToken(String token) {
        return tokenStore.get(token);
    }
}
