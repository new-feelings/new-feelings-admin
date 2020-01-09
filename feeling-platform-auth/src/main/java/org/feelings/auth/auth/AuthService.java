package org.feelings.auth.auth;

import org.feelings.auth.base.entity.User;
import org.feelings.auth.base.repository.UserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author lyq on 2019-12-27 3:47 下午
 * @desc
 */
@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example<User> example = Example.of(new User(username));
        Optional<User> optional = userDao.findOne(example);
        User user = null;
        if ((user = optional.get()) == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        AuthUser authUser = new AuthUser();
        BeanUtils.copyProperties(user, authUser);
        return authUser;
    }
}
