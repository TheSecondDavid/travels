package com.zhouhao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhouhao.dao.LoginMapper;
import com.zhouhao.entity.User;
import com.zhouhao.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    @Override
    public String getPassword(String username) {
        User user = loginMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        if(user == null)
            return null;
        return user.getPassword();
    }

    @Override
    public void register(String username, String password, String email) {
        loginMapper.insert(new User(username, password, email));
    }
}
