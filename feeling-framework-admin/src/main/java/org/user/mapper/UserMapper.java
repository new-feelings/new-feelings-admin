package org.user.mapper;

import org.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User selectById(@Param("id") String id);
    List<User> selectAll();
}
