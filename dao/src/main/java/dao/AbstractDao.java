//package dao;
//
//
//import exceptions.*;
//import utils.*;
//
//import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.criterion.Projection;
//import org.hibernate.criterion.Projections;
//import org.hibernate.SessionFactory;
//
//import javax.transaction.Transactional;
//import java.io.Serializable;
//import java.util.List;
//
///**
// * Created by Сергей on 04.05.2017.
// */
//
//
//public abstract class AbstractDao<T> implements IDao<T> {
//
//    protected HibernateUtils util;
//    private Class persistentClass;
//
////    protected AbstractDao(Class persistentClass){
////        this.persistentClass = persistentClass;
////    }
//
//    public AbstractDao(Class<T> persistentClass) {
//        this.persistentClass = persistentClass;
//        util = HibernateUtils.getInstance();
//    }
//
//    public Serializable save(T entity) throws DaoException{
//        Serializable id;
//        try {
//            Session session = util.getSession();
//            session.save(entity);
//            id = session.getIdentifier(entity);
//        }
//        catch(HibernateException e) {
//            throw new DaoException();
//        }
//        return id;
//    }
//
//    public void persist(T object) {
//        try {
//            Session session = util.getSession();
//            session.persist(object);
//            System.out.println("PERSIST COMPLETED");
//        } catch (Exception e) {
//            System.out.println("CAN'T CREATE OBJECT");
//        }
//    }
//
//
//    public void update(T entity) throws DaoException{
//        try {
//            Session session = util.getSession();
//            session.merge(entity);
//        }
//        catch(HibernateException e) {
//            throw new DaoException();
//        }
//    }
//
//
//    public T getById(Long id) throws DaoException{
//        T entity;
//        try {
//            Session session = util.getSession();
//            entity = (T)session.get(persistentClass, id);
//        }
//        catch(HibernateException e){
//            throw new DaoException();
//        }
//        return entity;
//    }
//
//
//    public void delete(Long id) throws DaoException{
//        try {
//            Session session = util.getSession();
//            T entity = (T) session.get(persistentClass, id);
//            session.delete(entity);
//        }
//        catch(HibernateException e){
//            //TODO исправить
//
//            throw new DaoException(e.getMessage());
//        }
//        catch(IllegalArgumentException e){
//            throw new DaoException();
//        }
//    }
//
//    public List<T> getAll() throws DaoException {
//        List<T> results;
//        try {
//            Session session = util.getSession();
//            Criteria criteria = session.createCriteria(persistentClass);
//            results = criteria.list();
//        }
//        catch(HibernateException e){
//
//            throw new DaoException();
//        }
//        return results;
//    }
//
//}
