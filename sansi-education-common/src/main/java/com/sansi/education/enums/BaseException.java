package com.sansi.education.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yihang.lv 2018/8/21、13:30
 */
@Getter
@AllArgsConstructor
public enum BaseException {

    LOGIN_EXPIRE(0001,"登录失效，请重新登录"),
    LIMITED_IP_LIST(0002,"IP受限");

    private int code;
    private String msg;
}
