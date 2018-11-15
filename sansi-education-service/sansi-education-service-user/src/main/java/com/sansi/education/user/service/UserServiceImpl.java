package com.sansi.education.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.sansi.education.user.api.UserService;
import com.sansi.education.user.dto.UserEnter;
import com.sansi.education.user.dto.UserResult;
import com.sansi.education.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
@Service(registry = "user-provider")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResult getUserById(UserEnter enter) {
        return userMapper.selectUserById(enter);
    }

    @Override
    public UserResult getUserByMobile(UserEnter enter){
        return userMapper.selectUserByMobile(enter);
    }
}
