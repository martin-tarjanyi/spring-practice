package com.martin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController
{
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/user")
    public String userPage()
    {
        return "user";
    }

    @RequestMapping("/admin")
    public String adminPage()
    {
        return "admin";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized()
    {
        return "unauthorized";
    }
}

