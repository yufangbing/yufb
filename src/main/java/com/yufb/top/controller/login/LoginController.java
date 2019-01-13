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


    /**
     * 跳转到登录页面
     */
    @GetMapping(value = "login")
    public String getLogin(@RequestParam Map<String,Object> params){
        return "login/login";
    }



    @GetMapping(value = "member-list")
    public String memberList(@RequestParam Map<String,Object> params){
        return "xadmin/member-list";
    }

    @GetMapping(value = "member-del")
    public String memberDel(@RequestParam Map<String,Object> params){
        return "xadmin/member-del";
    }

    @GetMapping(value = "order-list")
    public String orderList(@RequestParam Map<String,Object> params){
        return "xadmin/order-list";
    }

    @GetMapping(value = "cate")
    public String cate(@RequestParam Map<String,Object> params){
        return "xadmin/cate";
    }

    @GetMapping(value = "city")
    public String city(@RequestParam Map<String,Object> params){
        return "xadmin/city";
    }

    @GetMapping(value = "admin-list")
    public String adminList(@RequestParam Map<String,Object> params){
        return "xadmin/admin-list";
    }

    @GetMapping(value = "admin-role")
    public String adminRole(@RequestParam Map<String,Object> params){
        return "xadmin/admin-role";
    }

    @GetMapping(value = "admin-cate")
    public String adminCate(@RequestParam Map<String,Object> params){
        return "xadmin/admin-cate";
    }
    @GetMapping(value = "admin-rule")
    public String adminRule(@RequestParam Map<String,Object> params){
        return "xadmin/admin-rule";
    }

    @GetMapping(value = "unicode")
    public String unicode(@RequestParam Map<String,Object> params){
        return "xadmin/unicode";
    }

    @GetMapping(value = "echarts1")
    public String echarts1(@RequestParam Map<String,Object> params){
        return "xadmin/echarts1";
    }

    @GetMapping(value = "echarts2")
    public String echarts2(@RequestParam Map<String,Object> params){
        return "xadmin/echarts2";
    }

    @GetMapping(value = "echarts3")
    public String echarts3(@RequestParam Map<String,Object> params){
        return "xadmin/echarts3";
    }

    @GetMapping(value = "echarts4")
    public String echarts4(@RequestParam Map<String,Object> params){
        return "xadmin/echarts4";
    }

    @GetMapping(value = "welcome")
    public String welcome(@RequestParam Map<String,Object> params){
        return "xadmin/welcome";
    }


}
