package com.xiaoze.service.impl;

import com.xiaoze.mapper.IntroduceMapper;
import com.xiaoze.pojo.Introduce;
import com.xiaoze.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntroduceServiceImpl implements IntroduceService {

    @Autowired
    private IntroduceMapper mapper;

    @Override
    public int add(Introduce introduce) {
        return mapper.insert(introduce);
    }

    @Override
    public int remove(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public int remove(int[] ids) {
        List<Integer> idList = Arrays.stream(ids).boxed().collect(Collectors.toList());
        return mapper.deleteBatchIds(idList);
    }

    @Override
    public int modify(Introduce introduce) {
        return mapper.updateById(introduce);
    }

    @Override
    public List<Introduce> query() {
        return mapper.selectList(null);
    }

    @Override
    public Introduce query(int id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Introduce> query(Introduce introduce) {
        return null;
    }
}
