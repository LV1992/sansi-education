package com.sansi.education.common;

import lombok.Data;

import java.io.Serializable;
@Data
public class BaseEnterDto implements Serializable {
    private String sessionKey;
}
