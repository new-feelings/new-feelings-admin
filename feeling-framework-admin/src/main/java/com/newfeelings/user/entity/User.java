package com.newfeelings.user.entity;

import com.newfeelings.common.entity.BaseEntity;
import lombok.Data;

@Data
public class User extends BaseEntity {
    private String name;
    private String password;
}
