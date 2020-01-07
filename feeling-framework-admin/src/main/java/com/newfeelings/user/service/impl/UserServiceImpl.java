package com.newfeelings.user.service.impl;

import com.newfeelings.user.entity.User;
import com.newfeelings.user.mapper.UserMapper;
import com.newfeelings.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor =@__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
