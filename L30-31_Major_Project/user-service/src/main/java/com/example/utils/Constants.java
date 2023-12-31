package com.example.utils;

public class Constants {

    // Kafka related constants
    public static final String USER_CREATED_TOPIC = "user_created";

    // Redis related constants
    public static final String USER_REDIS_KEY_PREFIX = "usr::";
    public static final Long USER_REDIS_KEY_EXPIRY = 86400l;

    // Constants related to spring security authority
    public static final String USER_AUTHORITY = "usr";
    public static final String SERVICE_AUTHORITY = "svc";
    public static final String AUTHORITIES_DELIMITER = ":";

}
