package org.common.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    protected String id;
    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;
    protected LocalDateTime createBy;
    protected LocalDateTime updateBy;
    protected String host;
}
