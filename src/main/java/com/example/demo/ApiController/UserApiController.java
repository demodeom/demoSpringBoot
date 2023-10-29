package com.example.demo.ApiController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.BcryptPasswordUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserApiController {

    private final UserRepository userRepository;

    public UserApiController(UserRepository repository) {
       userRepository = repository;
    }

    @PostMapping("/api/user")
    public User create(
            @RequestParam String userNo,
            @RequestParam String userName,
            @RequestParam String userPassword
    )
    {
        String hashPassword = BcryptPasswordUtil.password_hash(userPassword);
        User user = new User(userNo, userName, hashPassword);
        return userRepository.save(user);
    }

    @PutMapping("/api/user/{id}")
    public User update(
            @PathVariable Long id,
            @RequestParam String userNo,
            @RequestParam String userName,
            @RequestParam String userPassword
    )
    {
        Optional<User> oldUser = userRepository.findById(id);
        User user = oldUser.orElse(null);

        if (user != null) {
            user.setUserNo(userNo);
            String hashPassword = BcryptPasswordUtil.password_hash(userPassword);
            user.setUserPassword(hashPassword);
            user.setUserName(userName);
            return userRepository.save(user);
        }
        return null;
    }

    @GetMapping("/api/user/{id}")
    public User getUser(
            @PathVariable(name = "id") Long id
    )
    {
        Optional<User> oldUser = userRepository.findById(id);
        return oldUser.orElse(null);
    }

    @GetMapping("/api/users")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @DeleteMapping("/api/user/{id}")
    public String del(@PathVariable long id)
    {
        userRepository.deleteById(id);
        return "删除成功";
    }


}
