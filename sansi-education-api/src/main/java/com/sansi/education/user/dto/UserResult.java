package com.sansi.education.user.dto;

import com.sansi.education.common.BaseResultDto;
import lombok.Data;

@Data
public class UserResult extends BaseResultDto {
    private Long id;
    private String name;
    private String mobile;
}
