package com.xiaoze.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoze.mapper.AccountMapper;
import com.xiaoze.pojo.Account;
import com.xiaoze.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper mapper;

    @Override
    public boolean login(String username, String password) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        wrapper.eq("password",password);
        Account account = mapper.selectOne(wrapper);
        return account != null;
    }

    @Override
    public int register(String username, String password, String repeatPw) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        username = username.strip();
        wrapper.eq("username",username);
        Account user = mapper.selectOne(wrapper);
        if (user != null || username.length() > 8 || username.length() == 0)
            return 10;
        if (password.length() < 6 || password.length() > 20)
            return 100;
        if (!password.equals(repeatPw))
            return 1000;
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return mapper.insert(account);
    }
}
