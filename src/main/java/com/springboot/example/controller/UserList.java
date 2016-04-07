package com.springboot.example.controller;

import com.springboot.example.bean.UserBean;
import com.springboot.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2015/12/9 - 23:26
 */
@Controller
@RequestMapping(value = "/user")
public class UserList {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getAllUser", method = RequestMethod.GET)
    public ModelAndView getAllUser(UserBean userBean, Model model, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("tables");
//        User user = userService.selectUser(userBean);
//        view.addObject("user", user);
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Map map = new HashMap();
            map.put("domain", i + ".com");
            map.put("price", "$55");
            map.put("click", 1000 + i);
            map.put("date", "Feb " + (1 + i));
            map.put("status", "Expiring");
            list.add(map);
        }
        view.addObject("lists", list);

        return view;
    }
}
