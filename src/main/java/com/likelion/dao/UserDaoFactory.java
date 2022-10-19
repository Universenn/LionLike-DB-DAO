package com.likelion.dao;

public class UserDaoFactory {
    // 조립을 해줍니다.
    public UserDao awsUserDao(){
        AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();
        UserDao userDao = new UserDao();
        return userDao;
    }
    public UserDao localUserDao(){
        LoclaConnectionMaker loclaConnectionMaker = new LoclaConnectionMaker();
        UserDao userDao = new UserDao();
        return userDao;

    }
}
