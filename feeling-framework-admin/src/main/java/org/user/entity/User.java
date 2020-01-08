package org.user.entity;

import org.common.entity.BaseEntity;
import lombok.Data;

@Data
public class User extends BaseEntity {
    private String name;
    private String password;
}
