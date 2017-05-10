package dao.impl;

import dao.IOrdersDao;
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
public class OrdersDaoTest implements IOrdersDao {


    private Session currentSession;

    private Transaction currentTransaction;

    public OrdersDaoTest() {
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

    public void persist(OrdersEntity entity) {
        getCurrentSession().save(entity);
    }

    public void update(OrdersEntity entity) {
        getCurrentSession().update(entity);
    }

    public OrdersEntity findById(String id) {
        OrdersEntity ordersEntity = (OrdersEntity) getCurrentSession().get(OrdersEntity.class, Integer.parseInt(id));
        return ordersEntity;
    }

    public void delete(OrdersEntity entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<OrdersEntity> findAll() {
        List<OrdersEntity> OrdersEntitys = (List<OrdersEntity>) getCurrentSession().createQuery("from OrdersEntity").list();
        return OrdersEntitys;
    }

    public void deleteAll() {
        List<OrdersEntity> entityList = findAll();
        for (OrdersEntity entity : entityList) {
            delete(entity);
        }
    }

}
