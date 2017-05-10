package dao.impl;

import dao.IFoodDao;

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
public class FoodDaoTest implements IFoodDao {

    private Session currentSession;

    private Transaction currentTransaction;

    public FoodDaoTest() {
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

    public void persist(FoodEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(FoodEntity entity) {
        getCurrentSession().update(entity);
    }

    public FoodEntity findById(String id) {
        FoodEntity foodEntity = (FoodEntity) getCurrentSession().get(FoodEntity.class, Integer.parseInt(id));
        return foodEntity;
    }

    public void delete(FoodEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<FoodEntity> findAll() {
        List<FoodEntity> FoodEntitys = (List<FoodEntity>) getCurrentSession().createQuery("from FoodEntity").list();
        return FoodEntitys;
    }

    public void deleteAll() {
        List<FoodEntity> entityList = findAll();
        for (FoodEntity entity : entityList) {
            delete(entity);
        }
    }

}
