package com.leijs.mybatis.extension.app.dto;

import lombok.Data;

/**
 * 更新参数
 *
 * @author leijisong
 * @date 2023/5/28 下午10:57
 */
@Data
public class UserUpdateParam {
    private Long id;

    private String name;

    private Integer age;

    private String email;
}
