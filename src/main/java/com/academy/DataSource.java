package com.academy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

public class DataSource {
    private static DataSource instance;
    
    private final EntityManagerFactory entityManagerFactory;

    public static DataSource getInstance() {
        if(instance == null) {
            instance = new DataSource();
        }
        return instance;
    }
    private DataSource() {
        entityManagerFactory= Persistence.createEntityManagerFactory("academy");
    }
    public EntityManager getEntityManager(){
        return  entityManagerFactory.createEntityManager();
    }
    public Session getSession(){
        return getEntityManager().unwrap(Session.class);
    }

}