package com.intetm.db.entity;

public enum Authority {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_ANONYMOUS;
    public static final String TABLE = "authorities";
    public static final String COLUMN_USERID = "userid";
    public static final String COLUMN_AUTHORITY = "authority";
}
