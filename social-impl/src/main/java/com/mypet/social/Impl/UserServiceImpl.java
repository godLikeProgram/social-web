package com.mypet.social.Impl;

import com.mypet.social.dao.UserMapper;
import com.mypet.social.model.User;
import com.mypet.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mrhou on 2016/11/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public void insert(User user) {
        userMapper.doInsert(user);
    }
}
