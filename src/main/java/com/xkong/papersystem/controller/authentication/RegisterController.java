package com.xkong.papersystem.controller.authentication;

import com.xkong.papersystem.dao.User;
import com.xkong.papersystem.service.authentication.Register;
import com.xkong.papersystem.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {
    @Autowired
    Register register;

    @PostMapping("/register")
    public ResBody register(@RequestBody User user) {
        String message = register.userRegister(user);
        if(Objects.equals(message, "Success")){
            return new ResBody(true, message);
        } else{
            return new ResBody(false, message);
        }
    }
}
