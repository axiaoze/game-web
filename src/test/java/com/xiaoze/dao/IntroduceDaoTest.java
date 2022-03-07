package com.xiaoze.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoze.mapper.IntroduceMapper;
import com.xiaoze.pojo.Introduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntroduceDaoTest {
    @Autowired
    private IntroduceMapper mapper;

    @Test
    public void testInsert(){
        Introduce introduce = new Introduce();
        introduce.setName("二战前线");
        introduce.setType("射击小游戏");
        introduce.setCreationTime(null);
        introduce.setDescription("这次的二战前线版本的游戏是最无敌的！可以随意调关卡、武器全开、血无限。还有什么比这爽的？！速速来体验吧！");
        introduce.setAddress("http://www.4399.com/flash/21674_3.htm");
        System.out.println(mapper.insert(introduce));
        System.out.println(introduce.getId());
    }

    @Test
    public void testUpdateById(){
        Introduce introduce = new Introduce();
        introduce.setId(29);
        introduce.setDescription("这次的二战前线版本的游戏是最无敌的！可以随意调关卡、武器全开、血无限。还有什么比这爽的？！速速来体验吧！");
        mapper.updateById(introduce);
    }

    @Test
    public void testUpdate1(){
        Introduce introduce = new Introduce();
        introduce.setName("无敌二战前线");
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        wrapper.eq("id",29);
        //UPDATE game_introduce SET name = "无敌二战前线" WHERE id = 29;
        System.out.println(mapper.update(introduce, wrapper));
    }

    @Test
    public void testUpdate2(){
        UpdateWrapper<Introduce> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",29).set("name","无敌");
        System.out.println(mapper.update(null, wrapper));
    }

    @Test
    public void testDeleteById(){
        System.out.println(mapper.deleteById(29));
    }

    @Test
    public void testDeleteByMap(){
        HashMap<String,Object> columnMap = new HashMap<>();
        columnMap.put("name","无敌二战前线");
        columnMap.put("creation_time","2009-12-29");
        //DELETE FROM game_introduce WHERE name = ? AND creation_time = ?
        /*
            QueryWrapper<Introduce> wrapper = new QueryWrapper<>(introduce);
            mapper.delete(wrapper);
        */
        System.out.println(mapper.deleteByMap(columnMap));
    }

    @Test
    public void testDeleteBatchIds() {
        //DELETE FROM game_introduce WHERE id IN ( ? , ? , ? )
        int[] data = {34,35};
        List<Integer> list = Arrays.stream(data).boxed().collect(Collectors.toList());
        int result = mapper.deleteBatchIds(list);
        System.out.println("result = " + result);
    }

    @Test
    public void testSelectById(){
        System.out.println(mapper.selectById(1));
    }

    @Test
    public void testSelectList(){
        List<Introduce> users = mapper.selectList(null);
        for (Introduce introduce : users) {
            System.out.println(introduce);
        }
    }

    @Test
    public void testSelectOne(){
        //根据条件查询一条数据，如果结果超过一条会报错
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        wrapper.eq("name","植物大战僵尸");
        System.out.println(mapper.selectOne(wrapper));
    }

    @Test
    public void testSelectCount(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("id",25);
        //SELECT COUNT( 1 ) FROM game_introduce WHERE id > ?
        System.out.println(mapper.selectCount(wrapper));
    }

    @Test
    public void testSelectPage(){
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        wrapper.gt("id",25);
        IPage<Introduce> page = new Page<>(2,2);
        IPage<Introduce> iPage = mapper.selectPage(page, wrapper);
        System.out.println("数据总条数：" + iPage.getTotal());
        System.out.println("总页数：" + iPage.getPages());
        List<Introduce> introduces = iPage.getRecords();
        //SELECT * FROM game_introduce WHERE id > ? LIMIT ?,?
        for (Introduce introduce : introduces) {
            System.out.println("introduce = " + introduce);
        }
    }

    @Test
    public void testLimitByCondition(){
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        wrapper.like("name","切").or().
                like("description","大鱼吃小鱼");
        IPage<Introduce> page = new Page<>(1,5);
        List<Introduce> Introduces = mapper.selectPage(page, wrapper).getRecords();
        for (Introduce introduce : Introduces) {
            System.out.println(introduce);
        }
    }

    @Test
    public void testLike(){
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        wrapper.like("name","切");
        List<Introduce> introduces = mapper.selectList(wrapper);
        //SELECT * FROM game_introduce WHERE name LIKE ?
        //parameter %切%
        for (Introduce introduce : introduces) {
            System.out.println("introduce = " + introduce);
        }
    }

    @Test
    public void testOrder(){
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        //SELECT * FROM game_introduce ORDER BY creation_time DESC
        wrapper.orderByDesc("creation_time");
        List<Introduce> introduces = mapper.selectList(wrapper);
        for (Introduce introduce : introduces) {
            System.out.println(introduce);
        }
    }

    @Test
    public void testAnd(){
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        //SELECT * FROM game_introduce WHERE name = ? AND creation_time = ?
        wrapper.eq("name","保卫萝卜").eq("creation_time","2013-07-12");
        List<Introduce> introduces = mapper.selectList(wrapper);
        for (Introduce introduce : introduces) {
            System.out.println(introduce);
        }
    }

    @Test
    public void testOr(){
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        //SELECT id,type FROM game_introduce WHERE name = "保卫萝卜" or creation_time = "2009-05-10"
        wrapper.eq("name","保卫萝卜")
                .or()
                .eq("creation_time","2009-05-10")
                .select("id","type");
        List<Introduce> introduces = mapper.selectList(wrapper);
        for (Introduce introduce : introduces) {
            System.out.println(introduce);
        }
    }

    @Test
    public void testGetPage(){
        IPage page = new Page(1,5);
        List list = mapper.selectPage(page, null).getRecords();
        for (Object l : list) {
            System.out.println(l);
        }
    }
}
