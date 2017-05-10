package services;

import dao.impl.WaiterDaoTest;
import entities.WaitersEntity;

import java.util.List;

/**
 * Created by Сергей on 10.05.2017.
 */
public class WaiterServiceTest {

    private static WaiterDaoTest waiterDao;

    public WaiterServiceTest() {
        waiterDao = new WaiterDaoTest();
    }

    public void persist(WaitersEntity entity) {
        waiterDao.openCurrentSessionwithTransaction();
        waiterDao.persist(entity);
        waiterDao.closeCurrentSessionwithTransaction();
    }

    public void update(WaitersEntity entity) {
        waiterDao.openCurrentSessionwithTransaction();
        waiterDao.update(entity);
        waiterDao.closeCurrentSessionwithTransaction();
    }

    public WaitersEntity findById(String id) {
        waiterDao.openCurrentSession();
        WaitersEntity client = waiterDao.findById(id);
        waiterDao.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        waiterDao.openCurrentSessionwithTransaction();
        WaitersEntity client = waiterDao.findById(id);
        waiterDao.delete(client);
        waiterDao.closeCurrentSessionwithTransaction();
    }

    public List<WaitersEntity> findAll() {
        waiterDao.openCurrentSession();
        List<WaitersEntity> clients = waiterDao.findAll();
        waiterDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        waiterDao.openCurrentSessionwithTransaction();
        waiterDao.deleteAll();
        waiterDao.closeCurrentSessionwithTransaction();
    }

    public WaiterDaoTest waiterDao() {
        return waiterDao;
    }
}
