package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.UserDao;
import com.academy.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class UserDaoImpl extends DefaultDaoIml<User> implements UserDao {

    @Override
    public List<User> findAll() {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        Query query = entityManager.createQuery("FROM User ");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public List<User> findAllByAge(int age) {

        return null;
    }
    public User getById(int id){
        Session session = DataSource.getInstance().getSession();
        User user = session.get(User.class, id);
        return user;
    }
    public User loadById(int id){
        Session session = DataSource.getInstance().getSession();
        User user = session.load(User.class, id);
        return user;
    }




}
