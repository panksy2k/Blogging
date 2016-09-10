package com.pankaj.platform.entity;

import com.google.common.base.Objects;

public class User {


    private String id;


    private String password;

    private User() {
    }

    public User(final String id, final String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("password", password)
                .toString();
    }
}
