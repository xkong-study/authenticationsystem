package com.xkong.papersystem.utils;

import com.xkong.papersystem.dao.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {
    String message;
    Boolean success;
    User user;
}
