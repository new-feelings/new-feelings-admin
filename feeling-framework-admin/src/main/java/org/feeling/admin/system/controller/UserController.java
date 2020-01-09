package org.feeling.admin.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.common.controller.BaseController;
import org.feeling.admin.system.entity.User;
import org.feeling.admin.system.service.IUserService;
import org.springframework.web.bind.annotation.*;

/**
  * @author lyq
  * @create 2020-01-09T15:16:09.307
*/
@RestController
@RequestMapping("/users")
public class UserController extends BaseController<IUserService, User> {

  @Override
  protected QueryWrapper createQueryWrapper(User user) {
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("name",user.getName());
    return wrapper;
  }

}