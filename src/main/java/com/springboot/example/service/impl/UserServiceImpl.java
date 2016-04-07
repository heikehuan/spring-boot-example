package com.springboot.example.service.impl;

import com.springboot.example.bean.UserBean;
import com.springboot.example.mapper.UserMapper;
import com.springboot.example.model.User;
import com.springboot.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2015/12/9 - 18:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUser(UserBean userBean) {
        User user = new User();
        user.setLoginName(userBean.getLoginName());
        user.setPassword(userBean.getPassword());
        return userMapper.selectOne(user);
    }
}
