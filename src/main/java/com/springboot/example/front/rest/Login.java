package com.springboot.example.front.rest;

import com.springboot.example.front.bean.UserBean;
import com.springboot.example.front.model.User;
import com.springboot.example.front.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2015/12/9 - 17:37
 */
@Controller
//@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class Login {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String tologin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserBean userBean, Model model, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.selectUser(userBean);
        request.setAttribute("user", user);
        return "index";
    }

}
