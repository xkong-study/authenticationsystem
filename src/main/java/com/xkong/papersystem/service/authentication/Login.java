package com.xkong.papersystem.service.authentication;

import com.xkong.papersystem.utils.LoginRes;

public interface Login {
    LoginRes userLogin(String username, String password);
}
