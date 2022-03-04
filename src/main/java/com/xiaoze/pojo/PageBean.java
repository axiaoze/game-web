package com.xiaoze.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    //总记录数
    private int TotalCount;
    //当前页数据
    private List<T> rows;
}
