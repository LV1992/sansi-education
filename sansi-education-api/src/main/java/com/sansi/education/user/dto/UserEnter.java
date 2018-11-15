package com.sansi.education.user.dto;

import com.sansi.education.common.BaseEnterDto;
import lombok.Data;

@Data
public class UserEnter extends BaseEnterDto {
    private Long id;
    private String name;
    private String mobile;
}
