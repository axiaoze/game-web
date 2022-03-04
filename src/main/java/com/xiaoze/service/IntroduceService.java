package com.xiaoze.service;

import com.xiaoze.pojo.Introduce;

import java.util.List;

public interface IntroduceService {
    int add(Introduce introduce);

    int remove(int id);

    int remove(int[] ids);

    int modify(Introduce introduce);

    List<Introduce> query();

    Introduce query(int id);

    List<Introduce> query(Introduce introduce);



}
