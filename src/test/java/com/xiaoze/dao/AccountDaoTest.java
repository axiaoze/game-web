package com.xiaoze.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoze.mapper.AccountMapper;
import com.xiaoze.pojo.Account;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountDaoTest {
    @Autowired
    private AccountMapper mapper;

    @Test
    void textRepeat(){
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username","b");
        Account account = mapper.selectOne(wrapper);
        System.out.println(account);
    }

    @Test
    void testQuery(){
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("username","zhangsan");
        wrapper.eq("password","123456");
        Account account = mapper.selectOne(wrapper);
        System.out.println(account);
    }

    @Test
    void testInsert(){
        Account account = new Account();
        account.setUsername("wangwu");
        account.setPassword("345678");
        int result = mapper.insert(account);
        System.out.println(result);
        System.out.println(account.getId());
    }

}
