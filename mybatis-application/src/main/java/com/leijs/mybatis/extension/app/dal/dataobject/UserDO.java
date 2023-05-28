package com.leijs.mybatis.extension.app.dal.dataobject;

import lombok.Data;
import lombok.ToString;

/**
 * @author leijisong
 * @date 2023/5/28 下午7:27
 */
@Data
@ToString
public class UserDO {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}
