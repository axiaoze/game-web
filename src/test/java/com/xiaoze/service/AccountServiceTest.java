package com.xiaoze.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    @Autowired
    private AccountService service;

    @Test
    public void login(){
        String username = "zhangsan";
        String password = "123456";
        boolean result = service.login(username, password);
        System.out.println(result?1:0);
    }

    @Test
    public void register(){
        String username = "xiss";
        String password = "34567";
        int result = service.register(username, password,null);
        System.out.println(result);
    }
}
