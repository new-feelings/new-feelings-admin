package org.feelings.auth.base.repository;

import org.feelings.auth.base.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lyq
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
