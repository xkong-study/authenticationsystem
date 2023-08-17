package com.xkong.papersystem.controller.authentication;

import com.xkong.papersystem.dao.User;
import com.xkong.papersystem.service.authentication.Login;
import com.xkong.papersystem.utils.LoginRes;
import com.xkong.papersystem.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    Login loginService;

    @PostMapping("/login")
    public LoginRes login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return loginService.userLogin(username, password);
    }
}
