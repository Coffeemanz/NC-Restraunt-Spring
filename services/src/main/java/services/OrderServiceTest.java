package services;

import dao.impl.OrdersDaoTest;
import entities.OrdersEntity;

import java.util.List;

/**
 * Created by Сергей on 10.05.2017.
 */
public class OrderServiceTest {

    private static OrdersDaoTest orderDao;

    public OrderServiceTest() {
        orderDao = new OrdersDaoTest();
    }

    public void persist(OrdersEntity entity) {
        orderDao.openCurrentSessionwithTransaction();
        orderDao.persist(entity);
        orderDao.closeCurrentSessionwithTransaction();
    }

    public void update(OrdersEntity entity) {
        orderDao.openCurrentSessionwithTransaction();
        orderDao.update(entity);
        orderDao.closeCurrentSessionwithTransaction();
    }

    public OrdersEntity findById(String id) {
        orderDao.openCurrentSession();
        OrdersEntity client = orderDao.findById(id);
        orderDao.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        orderDao.openCurrentSessionwithTransaction();
        OrdersEntity client = orderDao.findById(id);
        orderDao.delete(client);
        orderDao.closeCurrentSessionwithTransaction();
    }

    public List<OrdersEntity> findAll() {
        orderDao.openCurrentSession();
        List<OrdersEntity> clients = orderDao.findAll();
        orderDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        orderDao.openCurrentSessionwithTransaction();
        orderDao.deleteAll();
        orderDao.closeCurrentSessionwithTransaction();
    }

    public OrdersDaoTest orderDao() {
        return orderDao;
    }
}
