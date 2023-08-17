package com.xkong.papersystem.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="User")
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String username;
    private String signature;
    private String role;
    private String status;
    private String token;
    private String avatar;
    private Date registerTime;
    private String timeZone;
}
