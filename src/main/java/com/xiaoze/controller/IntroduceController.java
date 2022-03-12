package com.xiaoze.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoze.pojo.Introduce;
import com.xiaoze.pojo.R;
import com.xiaoze.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/introduces")
public class IntroduceController {
    @Autowired
    private IntroduceService service;

    @PostMapping
    public R save(@RequestBody Introduce introduce) {
        return new R(service.add(introduce));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        return new R(service.remove(id));
    }

    @DeleteMapping("ordinal/{ids}")
    public R delete(@PathVariable Integer[] ids) {
        return new R(service.remove(ids));
    }

    @PutMapping
    public R update(@RequestBody Introduce introduce) {
        return new R(service.modify(introduce));
    }

    @GetMapping
    public R list() {
        return new R(true, service.list());
    }

    @GetMapping("/{id}")
    public R query(@PathVariable Integer id) {
        return new R(true, service.query(id));
    }

    /*
    @PostMapping
    public R query(@RequestBody Introduce introduce){
        List<Introduce> introduces = service.query(introduce);
        Boolean flag = introduces != null;
        return new R(flag,introduces);
    }
    */

    @GetMapping("/{currentPage}/{pageSize}")
    public R limit(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        IPage<Introduce> page = service.getPage(currentPage, pageSize);
        return new R(null != page, page);
    }

    @PostMapping("/{currentPage}/{pageSize}")
    public R conditionLimit(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Introduce introduce) {
        IPage<Introduce> page = service.LimitByCondition(currentPage, pageSize, introduce);
        return new R(null != page,page);
    }

    @GetMapping("/enter/{id}")
    @CrossOrigin
    public ModelAndView enter(@PathVariable Integer id) {
        String address = service.getAddress(id);
        return new ModelAndView("redirect:" + address);
    }
}
