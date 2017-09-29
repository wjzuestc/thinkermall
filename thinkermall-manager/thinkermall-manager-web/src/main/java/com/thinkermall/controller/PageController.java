package com.thinkermall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 负责页面跳转
 * Created by wjz on 2017/9/26.
 */
@Controller
public class PageController {

    /**
     * 跳转到后台首页
     * 在springmvc配置文件中已经配置了前后缀，还需配置静态资源映射，才能找到js，css。
     *
     * @return
     */
    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }

    /**
     * 根据index页面的url 跳转对应的页面
     *
     * @param page 点击跳转的页面
     * @return 返回对应的页面
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
