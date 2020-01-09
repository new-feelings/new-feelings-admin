package org.common.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

public abstract class BaseEntity<T extends Model<?>> extends Model<T> {
    // protected String id;
    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;
    protected LocalDateTime createBy;
    protected LocalDateTime updateBy;
    protected String host;

    // public String getId() {
    //     return id;
    // }
    //
    // public void setId(String id) {
    //     this.id = id;
    // }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateBy() {
        return createBy;
    }

    public void setCreateBy(LocalDateTime createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(LocalDateTime updateBy) {
        this.updateBy = updateBy;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
