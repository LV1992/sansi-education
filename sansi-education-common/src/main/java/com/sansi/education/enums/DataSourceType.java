package com.sansi.education.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yihang.lv 2018/8/21、13:30
 */
@Getter
@AllArgsConstructor
public enum DataSourceType {

    XQTRAVEL_RW("xqdb_rw","xqdb读写库");

    private String name;
    private String desc;
}
