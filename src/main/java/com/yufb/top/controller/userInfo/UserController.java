package com.yufb.top.controller.userInfo;

import com.yufb.top.service.userInfo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户的增删改查
 */
@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = {"/findAll"})
    public List getAllUsers(@RequestParam Map<String,Object> params){
        List list =  userService.findAllUser();
        return list;
    }



    @GetMapping(value = {"/count"})
    public Integer count(@RequestParam Map<String,Object> params){
        Integer count =  userService.count(params);
        return count;
    }


    @PostMapping
    public Integer add(@RequestBody Map<String,Object> params){
        Integer num =  userService.add(params);
        return num;
    }


    @PutMapping
    public Integer update(@RequestBody Map<String,Object> params){
        Integer num =  userService.update(params);
        return num;
    }


    @DeleteMapping
    public Integer del(@RequestBody Map<String,Object> params){
        Integer num =  userService.del(params);
        return num;
    }



}
