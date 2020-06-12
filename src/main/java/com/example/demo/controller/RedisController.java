package com.example.demo.controller;

import com.example.demo.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiongyoujin
 * @date 2020/6/12 17:17
 **/
@RequestMapping("/redis")
@RestController
public class RedisController {

    // redis中存储的过期时间60s
    private static int expireTime = 60;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("set")
    public boolean redisset(String key, String value){
//        UserEntity userEntity =new UserEntity();
//        userEntity.setId(Long.valueOf(1));
//        userEntity.setGuid(String.valueOf(1));
//        userEntity.setName("zhangsan");
//        userEntity.setAge(String.valueOf(20));
//        userEntity.setCreateTime(new Date());

        //return redisUtil.set(key,userEntity,ExpireTime);

        return redisUtil.set(key,value);
    }

    @RequestMapping("get")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key){
        return redisUtil.expire(key,expireTime);
    }
}
