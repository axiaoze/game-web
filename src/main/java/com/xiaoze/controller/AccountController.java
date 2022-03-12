package com.xiaoze.controller;

import com.xiaoze.service.AccountService;
import com.xiaoze.utils.CheckCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping("/login")
    public String login(String username, String password) {
        boolean flag = service.login(username, password);
        if (flag) {
            return "redirect:../html/display.html";
        } else {
            return "redirect:../html/account/login_err.html";
        }
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request, String username, String password, String repeatPw, String checkCode) {
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        if (!checkCodeGen.equalsIgnoreCase(checkCode)){
            return "redirect:../html/account/register_cap_err.html";
        }
        int result = service.register(username, password, repeatPw);
        switch (result) {
            case 1 : return "redirect:../html/account/login_suc.html";
            case 10 : return "redirect:../html/account/register_usr_err.html";
            default : return "redirect:../html/account/register_err.html";
        }
    }

    @RequestMapping("/captcha")
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream os = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);
        HttpSession session = request.getSession();
        session.setAttribute("checkCodeGen",checkCode);
    }
}
