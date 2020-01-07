package org.registry.controller;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("")
    public String selectById() {
        return "test";
    }
}