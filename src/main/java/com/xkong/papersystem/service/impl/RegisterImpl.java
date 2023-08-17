package com.xkong.papersystem.service.impl;

import com.xkong.papersystem.dao.User;
import com.xkong.papersystem.service.authentication.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RegisterImpl implements Register {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public String userRegister(User user) {
        User existUser = mongoTemplate.findOne(new Query(Criteria.where("username").is(user.getUsername())), User.class);
        if(!Objects.isNull(existUser)){
            return "The username has been used";
        }
        try{
            mongoTemplate.insert(user);
            return "Success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
