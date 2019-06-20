package io.jagoketik.sikuning.model;

import java.io.Serializable;

public class User implements Serializable {
    private String users_id;
    private String users_token;
    private String users_name;
    private String users_alamat;
    private String users_email;
    private String users_password;
    private String users_hp;
    private int users_isdriver;
    private String users_last_login = null;
    private String users_created_at;

    public User(String users_id, String users_token, String users_name, String users_alamat, String users_email, String users_password, String users_hp, int users_isdriver, String users_last_login, String users_created_at) {
        this.users_id = users_id;
        this.users_token = users_token;
        this.users_name = users_name;
        this.users_alamat = users_alamat;
        this.users_email = users_email;
        this.users_password = users_password;
        this.users_hp = users_hp;
        this.users_isdriver = users_isdriver;
        this.users_last_login = users_last_login;
        this.users_created_at = users_created_at;
    }

    public String getUsers_id() {
        return users_id;
    }

    public String getUsers_token() {
        return users_token;
    }

    public String getUsers_name() {
        return users_name;
    }

    public String getUsers_alamat() {
        return users_alamat;
    }

    public String getUsers_email() {
        return users_email;
    }

    public String getUsers_password() {
        return users_password;
    }

    public String getUsers_hp() {
        return users_hp;
    }

    public int getUsers_isdriver() {
        return users_isdriver;
    }

    public String getUsers_last_login() {
        return users_last_login;
    }

    public String getUsers_created_at() {
        return users_created_at;
    }
}
