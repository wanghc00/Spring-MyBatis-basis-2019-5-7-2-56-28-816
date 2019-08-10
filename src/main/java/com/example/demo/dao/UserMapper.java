package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    // 1. 实现查询所有用户
    @Select("select * from user")
    List<User> getAllUser();

    // 2. 根据用户id查询用户
    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    // 3. 添加新用户
    @Insert("insert into user(id,name) values(${id},#{name})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertUser(User user);

    // 4. 根据用户id删除用户
    @Delete("delete from user where id = #{userId}")
    void deleteUserById(@Param("userId") int userId);

    // 5. 根据用户id更新用户
    @Update("update user set name = #{user.name} where id = #{userId}")
    void updateUserById(@Param("user") User user, @Param("userId") int userId);

}

