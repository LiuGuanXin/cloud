package com.pansoft.accountproviderservice.mapper;

import com.pansoft.accountproviderservice.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(User user);
    @Select("SELECT * FROM user")
    public List<User> findAll();
    @Select("SELECT * FROM user WHERE username = #{username} and name = #{name}")
    public User checkAccount(User user);
}
