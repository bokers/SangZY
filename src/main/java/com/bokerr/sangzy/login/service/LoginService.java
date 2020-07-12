package com.bokerr.sangzy.login.service;

import com.bokerr.sangzy.login.dao.UserMapper;
import com.bokerr.sangzy.login.po.User;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    @Resource
    private UserMapper userMapper;
    
    public void add(User user){
        userMapper.insert(user);
    }
    
    public User findByName(String userName){
        return userMapper.findByName(userName);
    }
    
}
