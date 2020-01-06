package com.newfeelings.user.dubbo.service;


import com.newfeelings.user.entity.User;


public interface UserClient {

    User selectById(String id);
}
