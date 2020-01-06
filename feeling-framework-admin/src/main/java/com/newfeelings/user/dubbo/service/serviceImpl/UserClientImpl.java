package com.newfeelings.user.dubbo.service.serviceImpl;


import com.newfeelings.user.dubbo.service.UserClient;
import com.newfeelings.user.entity.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserClientImpl implements UserClient {

    public User selectById(String id){
        return new User();
    }
}
