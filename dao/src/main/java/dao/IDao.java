package dao;

import java.io.Serializable;
import java.util.List;
import exceptions.*;

/**
 * Created by Сергей on 04.05.2017.
 */
//public interface IDao<T> {
//    void persist(T object);
//    List<T> getAll() throws DaoException;
//    T getById(Long id) throws DaoException;
//    void update(T entity) throws DaoException;
//    void delete(Long id) throws DaoException;
//    //Long getAmount() throws DaoException;
//
//}

public interface IDao<T, Id extends Serializable> {

    public void persist(T entity);

    public void update(T entity);

    public T findById(Id id);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();
}
