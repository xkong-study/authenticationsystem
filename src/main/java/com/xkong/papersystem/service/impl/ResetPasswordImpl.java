package com.xkong.papersystem.service.impl;

import com.xkong.papersystem.dao.User;
import com.xkong.papersystem.service.authentication.ResetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordImpl implements ResetPassword {

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public String resetPassword(String username, String password) {
        User existUser = mongoTemplate.findOne(new Query(Criteria.where("username").is(username)), User.class);
        if(existUser == null){
            return "User doesn't exists";
        } else {
            existUser.setPassword(password);
            mongoTemplate.save(existUser);
            return "Success";
        }
    }
}
