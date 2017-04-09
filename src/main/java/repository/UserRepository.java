package repository;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 80561 on 2017/3/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
