package com.newfeelings.user.service;

import com.newfeelings.user.entity.User;

import java.util.List;

public interface UserService {
    User selectById(String id);
    List<User> selectAll();
}
