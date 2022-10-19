package com.likelion.dao;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring
public class UserDaoFactory {
    // 조립을 해줍니다.
    @Bean
    public UserDao awsUserDao(){
        AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();
        UserDao userDao = new UserDao();
        return userDao;
    }

    @Bean
    public UserDao localUserDao(){
        LoclaConnectionMaker loclaConnectionMaker = new LoclaConnectionMaker();
        UserDao userDao = new UserDao();
        return userDao;

    }
}
