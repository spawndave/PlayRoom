package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.DefaultDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class DefaultDaoIml<T> implements DefaultDao<T> {
    private Class<T> type;

    public DefaultDaoIml(Class<T> type) {
        this.type = type;
    }

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
    public T findById(Integer id) {
        EntityManager entityManager = DataSource.getInstance().getEntityManager();
        Query query = entityManager.createQuery("FROM "+type.getName()+" t WHERE t.id =: id");
        query.setParameter("id", id);
        return entityManager.find(type, id);
    }


}
