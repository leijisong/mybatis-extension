package com.leijs.mybatis.extension.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.collect.Lists;
import com.leijs.mybatis.extension.app.StartApplication;
import com.leijs.mybatis.extension.app.dal.dataobject.UserDO;
import com.leijs.mybatis.extension.app.dal.mapper.UserMapper;
import com.leijs.mybatis.extension.app.dto.UserQueryParam;
import com.leijs.mybatis.extension.app.dto.UserUpdateParam;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author leijisong
 * @date 2023/5/28 下午8:04
 */
@SpringBootTest(classes = StartApplication.class)
@RunWith(SpringRunner.class)
@Sql(scripts = {"classpath:db/schema.sql"})
@Sql(scripts = {"classpath:db/data.sql"})
public class OfferMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO userDO = new UserDO();
        userDO.setId(10L);
        userDO.setAge(20);
        userDO.setName("Test");
        userDO.setEmail("test@xxxx.com");
        userMapper.insert(userDO);

        UserUpdateParam userUpdateParam = new UserUpdateParam();
        userUpdateParam.setId(10L);
        userUpdateParam.setEmail("test123@xxxx.com");
        int updateSize = userMapper.update(userUpdateParam);
        Assert.assertEquals(1, updateSize);

        UserQueryParam queryParam = new UserQueryParam();
        queryParam.setName("Test");
        UserDO user = userMapper.select(queryParam);
        System.out.println("update:" + user.toString());

        List<UserDO> users = userMapper.selectUsersByNames(Lists.newArrayList("Test", "Jone"));
        users.forEach(u -> System.out.println("select:" + u.toString()));
    }
}
