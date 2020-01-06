package com.newfeelings.user.feign;


import com.newfeelings.user.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("user/select/{id}")
    User selectById(@PathVariable("id") String id);
}
