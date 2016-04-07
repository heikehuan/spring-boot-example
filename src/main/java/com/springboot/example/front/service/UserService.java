package com.springboot.example.front.service;

import com.springboot.example.front.bean.UserBean;
import com.springboot.example.front.model.User;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2015/12/9 - 18:56
 */
public interface UserService {

    User selectUser(UserBean userBean);
}
