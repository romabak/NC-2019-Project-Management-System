package com.netcracker.edu.security;

public class SecurityJwtConstants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "123sign";
    public static final String TOKEN_PREFIX = "token=";
    public static final String HEADER_STRING = "Cookie";
    public static final String AUTHORITIES_KEY = "scopes";

}
