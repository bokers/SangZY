package com.bokerr.sangzy.login.dao;

import com.bokerr.sangzy.login.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    void insert(User user);
    User findByName(String userName);
}
