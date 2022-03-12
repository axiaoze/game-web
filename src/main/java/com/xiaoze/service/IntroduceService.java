package com.xiaoze.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoze.pojo.Introduce;

import java.util.List;

public interface IntroduceService {
    Boolean add(Introduce introduce);

    Boolean remove(Integer id);

    Boolean remove(Integer[] ids);

    Boolean modify(Introduce introduce);

    List<Introduce> list();

    Introduce query(Integer id);

    List<Introduce> query(Introduce introduce);

    IPage<Introduce> getPage(Integer currentPage, Integer PageSize);

    IPage<Introduce> LimitByCondition(Integer currentPage, Integer PageSize, Introduce introduce);

    String getAddress(int id);

}
