package com.sansi.education.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sansi.education.common.Response;
import com.sansi.education.context.LoginSession;
import com.sansi.education.context.SessionContext;
import com.sansi.education.user.api.UserService;
import com.sansi.education.user.dto.UserEnter;
import com.sansi.education.user.dto.UserResult;
import com.sansi.education.web.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Reference(registry = "consummer")
    private UserService userService;

    @Autowired
    private IpUtil ipUtil;

    @RequestMapping("login")
    public Response login(UserEnter enter){
        UserResult userByMobile = userService.getUserByMobile(enter);
        String ip = ipUtil.getIp();
        SessionContext.setSession(LoginSession.builder().ip(ip).sessionKey("").build());
        return new Response(userByMobile);
    }

}
