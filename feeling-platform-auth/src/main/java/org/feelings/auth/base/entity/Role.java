package org.feelings.auth.base.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author lyq on 2019-12-27 11:18 上午
 * @desc
 */
@Table(name = "tbl_role")
@Data
@Entity
public class Role {

    @Id
    private Long id;

    private String name;

    private String code;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Permission.class
    )
    @JoinTable(
            name = "rl_role_permission",
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id", unique = true)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "permission_id", referencedColumnName = "id")
            }
    )
    private List<Permission> permissions;

}
