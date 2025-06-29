package c2m.security.repository;

import c2m.security.entity.Role;
import c2m.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByRole(Role role);
    @Query(value = "select * from user u where u.role = :role ", nativeQuery = true)
    List<User> findAllUsers(String role);
}
