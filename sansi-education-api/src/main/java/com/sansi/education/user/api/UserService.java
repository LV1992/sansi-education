package com.sansi.education.user.api;

import com.sansi.education.user.dto.UserEnter;
import com.sansi.education.user.dto.UserResult;

public interface UserService {
    UserResult getUserById(UserEnter enter);
    UserResult getUserByMobile(UserEnter enter);
}
