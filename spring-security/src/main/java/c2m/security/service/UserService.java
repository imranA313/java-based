package c2m.security.service;

import c2m.security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService getUserDetails();
    void deleteById(Long id);
    List<User> allUsers();
}
