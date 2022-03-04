package com.xiaoze.service;

import com.xiaoze.pojo.Introduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntroduceServiceTest {
    @Autowired
    private IntroduceService service;

    @Test
    public void testAdd(){
        Introduce introduce = new Introduce();
        introduce.setName("35y64给s");
        introduce.setType("激热小游戏");
        introduce.setDescription("好好玩呀快来玩呀");
        System.out.println(service.add(introduce));
    }

    @Test
    public void testRemove1(){
        System.out.println(service.remove(33));
    }

    @Test
    public void testRemove2(){
        int[] ref = {36,37};
        System.out.println(service.remove(ref));
    }

    @Test
    public void testModify(){
        Introduce introduce = new Introduce();
        introduce.setId(43);
        introduce.setAddress("sa;fnv;apuin");
        System.out.println(service.modify(introduce));
    }

    @Test
    public void query1(){
        List<Introduce> introduces = service.query();
        for (Introduce introduce : introduces) {
            System.out.println(introduce);
        }
    }

    @Test
    public void query2(){
        System.out.println(service.query(1));
    }

    @Test
    public void test(){
        int[][] a = {{1,2,3},{1,2,3},{1,2,3},{1,2,3}};
        System.out.println(a.length);
        System.out.println(a[0].length);
    }
}
