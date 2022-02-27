package com.xiaoze.service;

public interface AccountService {
    boolean login(String username,String password);
    int register(String username,String password,String repeatPw);
}
