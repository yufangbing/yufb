package com.yufb.top.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 前台首页
 */
@Controller
@RequestMapping("/")
public class LoginController {
    /**
     * 跳转到首页
     */
    @GetMapping
    public String index(@RequestParam Map<String,Object> params){
        return "home/index";
    }

    /**
     *跳转到列表页
     */
    @GetMapping(value = "list")
    public String list(@RequestParam Map<String,Object> params){
        return "home/list";
    }

    /**
     *跳转到详情页
     */
    @GetMapping(value = "show")
    public String show(@RequestParam Map<String,Object> params){
        return "home/show";
    }


    /**
     *跳转到404页面
     */
    @GetMapping(value = "404")
    public String fourZeroFour(@RequestParam Map<String,Object> params){
        return "home/404";
    }

    /**
     * 跳转到后台首页
     */
    @GetMapping(value = "index")
    public String afterIndex(@RequestParam Map<String,Object> params){
        return "xadmin/index";
    }


}
