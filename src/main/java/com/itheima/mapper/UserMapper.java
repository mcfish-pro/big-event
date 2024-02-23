package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    // 根據用戶名查詢用戶
    @Select("SELECT * FROM user WHERE username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("INSERT INTO user(username, password, create_time, update_time)" +
            " values (#{username}, #{password}, now(), now())")
    void add(String username, String password);
}
