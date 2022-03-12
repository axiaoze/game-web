package com.xiaoze.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoze.mapper.IntroduceMapper;
import com.xiaoze.pojo.Introduce;
import com.xiaoze.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IntroduceServiceImpl implements IntroduceService {

    @Autowired
    private IntroduceMapper mapper;

    @Override
    public Boolean add(Introduce introduce) {
        return mapper.insert(introduce) > 0;
    }

    @Override
    public Boolean remove(Integer id) {
        return mapper.deleteById(id) > 0;
    }

    @Override
    public Boolean remove(Integer[] ids) {
        //List<Integer> idList = Arrays.stream(ids).boxed().collect(Collectors.toList());
        List<Integer> idList = Arrays.asList(ids);
        return mapper.deleteBatchIds(idList) > 0;
    }

    @Override
    public Boolean modify(Introduce introduce) {
        return mapper.updateById(introduce) > 0;
    }

    @Override
    public List<Introduce> list() {
        return mapper.selectList(null);
    }

    @Override
    public Introduce query(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Introduce> query(Introduce introduce) {
        return mapper.selectList(new QueryWrapper(introduce));
    }

    @Override
    public IPage<Introduce> getPage(Integer currentPage, Integer pageSize){
        IPage<Introduce> page = new Page<>(currentPage,pageSize);
        return mapper.selectPage(page,null);
    }

    @Override
    public IPage<Introduce> LimitByCondition(Integer currentPage, Integer PageSize, Introduce introduce) {
        String name = introduce.getName();
        String description = introduce.getDescription();
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        if (name.length() != 0 && description.length() != 0) {
            wrapper.like("name",name).or().
                    like("description",description);
        } else if (name.length() == 0 && description.length() != 0) {
            wrapper.like("description",description);
        } else if (name.length() != 0) {
            wrapper.like("name", name);
        } else {
            wrapper = null;
        }

        IPage<Introduce> page = new Page<>(currentPage,PageSize);
        return mapper.selectPage(page,wrapper);
    }

    //获取游戏地址
    @Override
    public String getAddress(int id) {
        QueryWrapper<Introduce> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        Introduce introduce = mapper.selectOne(wrapper);
        return introduce.getAddress();
    }
}
