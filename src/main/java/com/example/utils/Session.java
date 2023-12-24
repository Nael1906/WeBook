package com.example.utils;

public class Session {
    private static String _userId;

    public static void setUserId(String userId) {
        _userId = userId;
    }

    public static String getUserId() {
        return _userId;
    }
}
