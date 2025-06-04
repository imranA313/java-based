package c2m.security.controller;

import c2m.security.entity.User;
import c2m.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        List <User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/greet")
    public ResponseEntity<String> greeting(){
        return ResponseEntity.ok("Hi User !");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("Record deleted successfully");
    }
}
