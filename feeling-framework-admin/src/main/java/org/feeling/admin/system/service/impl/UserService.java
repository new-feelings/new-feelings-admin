package org.feeling.admin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.feeling.admin.system.entity.User;
import org.feeling.admin.system.mapper.UserMapper;
import org.feeling.admin.system.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

/**
* @author lyq
* @create 2020-01-09T15:16:09.307
*/
@Service
@Primary
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService{
}
