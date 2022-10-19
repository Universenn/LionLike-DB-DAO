package com.likelion.dao;

import com.likelion.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired //Spring
    ApplicationContext context;
    @Test
    void addAndSelect() {
//        UserDao userDao = new UserDao(new LoclaConnectionMaker());
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        UserDao userDao2 = context.getBean("awsUserDao", UserDao.class);


        // 주소가 같다 (Single Tone(ApplicationContext)을 써야하는 이유
        // 중요하다..왜지?
        //com.likelion.dao.UserDao@7fab4be7
        //com.likelion.dao.UserDao@7fab4be7
        System.out.println(userDao);
        System.out.println(userDao2);




        String id = "8";
        User user = new User(id,"juwan", "110055qwe");
        userDao.add(user);

        User userSelecte = userDao.findById(id);
        Assertions.assertEquals("juwan",userSelecte.getName());
    }
}