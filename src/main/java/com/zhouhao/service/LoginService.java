package com.zhouhao.service;

public interface LoginService {
    String getPassword(String username);

    void register(String username, String password, String email);
}
