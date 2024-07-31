package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.DefaultDao;
import com.academy.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class DefaultDaoIml<T> implements DefaultDao<T> {

    @Override
    public void createOrUpdate(T entity) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entityManager.contains(entity) ? entity: entityManager.merge(entity));
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(entity) ? entity: entityManager.merge(entity));
        entityManager.getTransaction().commit();
    }

    @Override
    public <T> T findById(Integer id, Class<T> type) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        Query query = entityManager.createQuery("FROM "+type.getName()+" t WHERE t.id =: id");
        query.setParameter("id", id);
        return entityManager.find(type, id);
    }


}
