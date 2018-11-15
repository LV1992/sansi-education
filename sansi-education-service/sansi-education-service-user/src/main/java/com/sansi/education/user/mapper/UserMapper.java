package com.sansi.education.user.mapper;

import com.sansi.education.user.dto.UserEnter;
import com.sansi.education.user.dto.UserResult;

public interface UserMapper{
    UserResult selectUserById(UserEnter enter);
    UserResult selectUserByMobile(UserEnter enter);
}
