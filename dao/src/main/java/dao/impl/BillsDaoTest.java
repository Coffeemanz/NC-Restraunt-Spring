package dao.impl;

import dao.IBillDao;

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
public class BillsDaoTest implements IBillDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public BillsDaoTest() {
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

    public void persist(BillsEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(BillsEntity entity) {
        getCurrentSession().update(entity);
    }

    public BillsEntity findById(String id) {
        BillsEntity billsEntity = (BillsEntity) getCurrentSession().get(BillsEntity.class, Integer.parseInt(id));
        return billsEntity;
    }

    public void delete(BillsEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<BillsEntity> findAll() {
        List<BillsEntity> BillssEntitys = (List<BillsEntity>) getCurrentSession().createQuery("from BillsEntity").list();
        return BillssEntitys;
    }

    public void deleteAll() {
        List<BillsEntity> entityList = findAll();
        for (BillsEntity entity : entityList) {
            delete(entity);
        }
    }
}
