package dao.impl;

import dao.IWaitersDao;

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
public class WaiterDaoTest implements IWaitersDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public WaiterDaoTest() {
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

    public void persist(WaitersEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(WaitersEntity entity) {
        getCurrentSession().update(entity);
    }

    public WaitersEntity findById(String id) {
        WaitersEntity waitersEntity = (WaitersEntity) getCurrentSession().get(WaitersEntity.class, Integer.parseInt(id));
        return waitersEntity;
    }

    public void delete(WaitersEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<WaitersEntity> findAll() {
        List<WaitersEntity> WaitersEntitys = (List<WaitersEntity>) getCurrentSession().createQuery("from WaitersEntity").list();
        return WaitersEntitys;
    }

    public void deleteAll() {
        List<WaitersEntity> entityList = findAll();
        for (WaitersEntity entity : entityList) {
            delete(entity);
        }
    }

}
