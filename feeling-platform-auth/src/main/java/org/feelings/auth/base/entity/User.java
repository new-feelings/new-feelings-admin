package org.feelings.auth.base.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author lyq on 2019-12-27 11:15 上午
 * @desc
 */
@Table(name = "tbl_user")
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    private String username;

    private String password;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Role.class
    )
    @JoinTable(
            name = "rl_user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")
            }
    )
    private List<Role> roles;

    public User(String username) {
        this.username = username;
    }
}
