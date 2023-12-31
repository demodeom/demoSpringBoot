package com.example.demo.ApiController;


import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloApiController {

    @GetMapping("/api/hello")
    public Map<String, Object> hello() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("message", "success");
        res.put("data", "Hello Restfull Api");
        return res;
    }

    @GetMapping("/api/hi")
    public Map<String, Object> hi(
            @RequestParam(name = "name", defaultValue = "Tony") String name,
            @RequestParam(name = "age", defaultValue = "18") Integer age
    ) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("message", "success");
        res.put("data", "姓名：" + name + ", 年龄: " + age);
        return res;
    }

    @GetMapping("/api/hi/user/{userId}")
    public Map<String, Object> user(
        @PathVariable(name = "userId", required = true) Integer userId
    ) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("message", "success");
        res.put("data", "id: " + userId);
        return res;
    }

    @GetMapping("/api/bcrypt/hash")
    public String  hash() {
        String userPassword= "12345678";
        // $2a$10$IbDeBLkQe82Pz1BYinXatu4cDCBON8sLwjmvYTbm0nX7OxyaYL1we
        return BCrypt.withDefaults().hashToString(10, userPassword.toCharArray());
    }

    @GetMapping("/api/bcrypt/verify")
    public String  verify() {
        String userPassword= "123456789";
        String userPasswordHash = "$2a$10$IbDeBLkQe82Pz1BYinXatu4cDCBON8sLwjmvYTbm0nX7OxyaYL1we";
        // $2a$10$IbDeBLkQe82Pz1BYinXatu4cDCBON8sLwjmvYTbm0nX7OxyaYL1we
        boolean res = BCrypt.verifyer().verify(userPassword.toCharArray(), userPasswordHash).verified;
        if (res){
            return "密码校验通过";
        }
        return "密码校验失败";


    }

}
