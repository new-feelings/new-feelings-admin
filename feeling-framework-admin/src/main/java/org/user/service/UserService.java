package org.user.service;

import org.user.entity.User;

import java.util.List;

public interface UserService {
    User selectById(String id);
    List<User> selectAll();
}
