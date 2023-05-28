package com.leijs.mybatis.extension.app.dal.mapper;

import com.leijs.mybatis.extension.app.dal.dataobject.UserDO;
import com.leijs.mybatis.extension.app.dto.UserQueryParam;
import com.leijs.mybatis.extension.app.dto.UserUpdateParam;
import com.leijs.mybatis.infrastructure.SimpleInsertLangDriver;
import com.leijs.mybatis.infrastructure.SimpleSelectInLangDriver;
import com.leijs.mybatis.infrastructure.SimpleSelectLangDriver;
import com.leijs.mybatis.infrastructure.SimpleUpdateLangDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户mapper
 *
 * @author leijisong
 * @date 2023/5/28 下午7:54
 */
@Mapper
public interface UserMapper {

    /**
     * 更新
     *
     * @param user 用户信息
     * @return 影响行数
     */
    @Update("update t_user (#{user}) where id = #{id}")
    @Lang(SimpleUpdateLangDriver.class)
    int update(UserUpdateParam user);

    /**
     * 插入
     *
     * @param user 用户信息
     */
    @Insert("insert into t_user (#{user})")
    @Lang(SimpleInsertLangDriver.class)
    void insert(UserDO user);

    @Select("select * from t_user (#{queryParam})")
    @Lang(SimpleSelectLangDriver.class)
    UserDO select(UserQueryParam queryParam);


    @Select("SELECT * FROM t_user WHERE name IN (#{userNames})")
    @Lang(SimpleSelectInLangDriver.class)
    List<UserDO> selectUsersByNames(@Param("userNames") List<String> userNames);
}
