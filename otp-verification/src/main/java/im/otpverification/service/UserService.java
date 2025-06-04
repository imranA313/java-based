package im.otpverification.service;

import im.otpverification.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService, UserDetailsPasswordService {

    /**
     * @return list of User
     */
    List<User> getUsers();

    /**
     * @param user ussr object
     * @return user saved or updated
     */
    User save(User user);
}
