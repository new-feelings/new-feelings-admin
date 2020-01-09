package org.feelings.auth.base.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lyq on 2019-12-27 11:23 上午
 * @desc
 */
@Table(name = "tbl_permission")
@Data
@Entity
public class Permission {

    @Id
    private Long id;

    private String name;

    private String code;

}
