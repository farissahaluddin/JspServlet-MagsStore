package com.faris.service;

import com.faris.dao.UserDao;
import com.faris.dao.impl.UserDaoImpl;
import com.faris.entity.User;

public class UserService implements BaseUser {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User Save(User entity) {
        if (entity.getId_user() == 0){
            entity= userDao.Save(entity);
        }else {
            System.out.println("update");
        }
        return entity;
    }

}
