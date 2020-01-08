package org.user.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.common.constants.StatusCode;
import org.common.exception.CustomException;
import org.common.result.Result;
import org.common.result.ResultUtil;
import org.common.product.service.ProductService;
import org.user.entity.User;
import org.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @Reference
    private  ProductService registryService;

    @GetMapping("select/{id}")
    public User selectById(@PathVariable String id) {
        User user = userService.selectById(id);
        user.getId();
        return user;
    }

    @GetMapping("selectAll")
    public List<User> selectAll() {
        Page<Object> page = PageHelper.startPage(1, 2);
        List<User> users = userService.selectAll();
        return users;
    }

    @GetMapping("selectAll2")
    public Result selectAll2() {
        List<User> users = userService.selectAll();
        return ResultUtil.success(users);
    }

    @GetMapping("selectAll3")
    public Result selectAll3() {
        List<User> users = userService.selectAll();
        if(users.size()>0)
            throw new CustomException(StatusCode.ERROR);
        return ResultUtil.success(users);
    }

    @GetMapping("dubbo/test")
    public String test1() {
        return registryService.selectById();
    }
}
