package org.feeling.admin.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.feeling.admin.auth.AuthEntity;
import org.feeling.admin.auth.AuthService;
import org.feeling.admin.system.entity.User;
import org.feeling.admin.system.service.IUserService;
import org.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
  * @author lyq
  * @create 2020-01-09T15:16:09.307
*/
@RestController
@RequestMapping("/users")
public class UserController extends BaseController<IUserService, User> {

  @Autowired
  private AuthService authService;

  @PostMapping("/login")
  public AuthEntity login(String username,String password){
    return authService.login(username,password);
  }

  @PutMapping("/logout")
  public boolean logout(@RequestHeader("Authorization") String token){
    return authService.logout(token);
  }

  @Override
  protected QueryWrapper createQueryWrapper(User user) {
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("name",user.getName());
    return wrapper;
  }

}