package com.springboot.example.rest;

import com.springboot.example.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ptmind on 2015/11/29.
 */
@RestController
@RequestMapping("/user")
public class Hello {

    @RequestMapping(value = "select", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object hello() {
        User user = new User();
        user.setId("1");
        user.setName("frank");
        user.setPassword("123456");
        return user;
    }


}
