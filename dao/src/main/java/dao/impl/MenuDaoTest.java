package dao.impl;

import dao.IMenuDao;


import dao.*;
import entities.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Сергей on 04.05.2017.
 */
public class MenuDaoTest implements IMenuDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public MenuDaoTest() {
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

    public void persist(MenuEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(MenuEntity entity) {
        getCurrentSession().update(entity);
    }

    public MenuEntity findById(String id) {
        MenuEntity menuEntity = (MenuEntity) getCurrentSession().get(MenuEntity.class, Integer.parseInt(id));
        return menuEntity;
    }

    public void delete(MenuEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<MenuEntity> findAll() {
        List<MenuEntity> MenuEntitys = (List<MenuEntity>) getCurrentSession().createQuery("from MenuEntity").list();
        return MenuEntitys;
    }

    public void deleteAll() {
        List<MenuEntity> entityList = findAll();
        for (MenuEntity entity : entityList) {
            delete(entity);
        }
    }
}
