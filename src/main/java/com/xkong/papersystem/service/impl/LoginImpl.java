package com.xkong.papersystem.service.impl;

import com.xkong.papersystem.dao.User;
import com.xkong.papersystem.service.authentication.Login;
import com.xkong.papersystem.utils.LoginRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements Login {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    @Service
public class LoginImpl implements Login {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public LoginRes userLogin(String username, String password) {
        try{
            // find user by username
            User existUser = mongoTemplate.findOne(new Query(Criteria.where("username").is(username)), User.class);
            if(existUser == null){
                return new LoginRes("Invalid Credentials", false, null);
            } else{
                if(!passwordEncoder.matches(password, existUser.getPassword())){
                    return new LoginRes("Invalid Credentials", false, null);
                }
                return new LoginRes("Success", true, existUser);
            }
        } catch (Exception e) {
            // Log the exception for internal review
            // Return a generic error message
            return new LoginRes("An error occurred. Please try again later.", false, null);
        }
    }
}
