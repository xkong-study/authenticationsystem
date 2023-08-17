package com.xkong.papersystem.controller.authentication;

import com.xkong.papersystem.service.authentication.ResetPassword;
import com.xkong.papersystem.utils.ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class ResetPasswordController {
    @Autowired
    ResetPassword resetPassword;

    @PostMapping("/reset_password")
    public ResBody resetPassword(@RequestParam("username") String username, @RequestParam("password") String password) {
        String message = resetPassword.resetPassword(username, password);
        if(Objects.equals(message, "Success")){
            return new ResBody(true, message);
        } else{
            return new ResBody(false, message);
        }
    }

}
