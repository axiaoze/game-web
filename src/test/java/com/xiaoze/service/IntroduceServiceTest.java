package com.xiaoze.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoze.pojo.Introduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntroduceServiceTest {
    @Autowired
    private IntroduceService service;

    @Test
    public void testAdd(){
        Introduce introduce = new Introduce();
        introduce.setName("35y6s");
        introduce.setType("hufa小游戏");
        introduce.setDescription("好好玩呀快来玩呀");
        System.out.println(service.add(introduce));
    }

    @Test
    public void testRemove1(){
        System.out.println(service.remove(38));
    }

    @Test
    public void testRemove2(){
        Integer[] ref = {39,40};
        System.out.println(service.remove(ref));
    }

    @Test
    public void testModify(){
        Introduce introduce = new Introduce();
        introduce.setId(58);
        introduce.setName("huang");
        introduce.setCreationTime(new Date(2022-03-22));
        introduce.setDescription("wefqwfsac");
        introduce.setAddress("好玩");
        System.out.println(service.modify(introduce));
    }

    @Test
    public void query1(){
        List<Introduce> introduces = service.list();
        for (Introduce introduce : introduces) {
            System.out.println(introduce);
        }
    }

    @Test
    public void query2(){
        System.out.println(service.query(1));
    }

    @Test
    public void testGetPage(){
        List<Introduce> introduces = service.getPage(0, 5).getRecords();
        for (Introduce introduce : introduces) {
            System.out.println(introduce);
        }
    }

    @Test
    public void testLimitByCondition(){
        Introduce introduce = new Introduce();
        introduce.setName("切");
        introduce.setDescription(null);
        List<Introduce> introduces = service.LimitByCondition(1, 5, introduce).getRecords();
        for (Introduce introduce1 : introduces) {
            System.out.println(introduce1);
        }
    }
}
