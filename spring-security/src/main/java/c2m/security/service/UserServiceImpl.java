package c2m.security.service;

import c2m.security.entity.Role;
import c2m.security.entity.User;
import c2m.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> allUsers() {
        return userRepository.findAllUsers("user");
    }

    @Override
    public UserDetailsService getUserDetails() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)  {
                return userRepository.findByEmail(username).orElseThrow( () -> new UsernameNotFoundException("Use not found"));
            }
        };
    }

    @Override
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
