package com.wego.controller;

import com.wego.entity.Food;
import com.wego.entity.Skin;
import com.wego.entity.User;
import com.wego.model.ResultModel;
import com.wego.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author elizayuan
 * 主要用于用户的接口
 */
@RestController
public class UserController {
    @Autowired
    UserServer userServer;

    /**
     * 注册
     *
     * @param pwd
     * @param name
     * @param email
     * @return Map key,1代表注册成功,message:注册成功，key:0表示注册失败,message:用户已经存在
     */
    @PostMapping("user/register")
    @ResponseBody
    ResultModel<Integer> register(@RequestParam String pwd, @RequestParam String name, @RequestParam String email) {
        return userServer.register(pwd, name, email);
    }

    /**
     * 用户登录，登录成功后返回uid
     *
     * @param name
     * @param pwd
     * @return
     */
    @PostMapping("user/login")
    @ResponseBody
    ResultModel login(@RequestParam String name, @RequestParam String pwd) {
        return userServer.login(name, pwd);
    }

    /***
     * 查看用户信息，同时更新数据库的等级
     *
     */
    @GetMapping("user/viewinfo")
    @ResponseBody
    ResultModel<User> viewInfo(Integer uid) {
        return userServer.showInfo(uid);
    }

    @GetMapping("user/showfood")
    @ResponseBody
    ResultModel<List<Food>> showfood(Integer uid) {
        return userServer.showFood(uid);
    }

    @GetMapping("user/showskin")
    @ResponseBody
    ResultModel<List<Skin>> showskin(Integer uid) {
        return userServer.showSkin(uid);
    }

    /**
     * 根据用户的id，宠物id，食物id喂食，同时增在宠物的col
     *
     * @param uid
     * @param pid
     * @param fid
     * @return
     */
    @PostMapping("user/usefood")
    ResultModel usefood(@RequestParam Integer uid, @RequestParam Integer pid, @RequestParam Integer fid) {
        return userServer.useFood(uid, pid, fid);
    }
}
