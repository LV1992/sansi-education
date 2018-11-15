package com.sansi.education.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResultDto implements Serializable {
    private String requestIp;
}
