package org.feeling.admin.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author lyq
* @Date 2020-01-09T15:16:09.307
*/
@TableName("tbl_user")
@Data
public class User extends Model<User> {

    /**
    * 
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 
    */
    @TableField("name")
    private String name;
    /**
    * 
    */
    @TableField("username")
    private String username;
    /**
    * 
    */
    @TableField("password")
    private String password;
}