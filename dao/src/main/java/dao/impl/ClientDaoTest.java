package dao.impl;

/**
 * Created by Сергей on 04.05.2017.
 */

import dao.*;
import entities.*;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ClientDaoTest implements IClientDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public ClientDaoTest() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        //SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(ClientsEntity entity) {
        getCurrentSession().save(entity);
    }

    public Serializable save (ClientsEntity entity)
    {
        Serializable id;
        id = getCurrentSession().save(entity);
        return id;
    }

    public void update(ClientsEntity entity) {
        getCurrentSession().update(entity);
    }

    public ClientsEntity findById(String id) {
        ClientsEntity client = (ClientsEntity) getCurrentSession().get(ClientsEntity.class, Integer.parseInt(id));
        return client;
    }

    public void delete(ClientsEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<ClientsEntity> findAll() {
        List<ClientsEntity> ClientsEntitys = (List<ClientsEntity>) getCurrentSession().createQuery("from ClientsEntity").list();
        return ClientsEntitys;
    }

    public void deleteAll() {
        List<ClientsEntity> entityList = findAll();
        for (ClientsEntity entity : entityList) {
            delete(entity);
        }
    }

}
