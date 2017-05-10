package services;

import dao.impl.BillsDaoTest;
import dao.impl.BillsDaoTest;
import entities.BillsEntity;

import java.util.List;

/**
 * Created by Сергей on 09.05.2017.
 */
public class BillServiceTest {

    private static BillsDaoTest billDao;

    public BillServiceTest() {
        billDao = new BillsDaoTest();
    }

    public void persist(BillsEntity entity) {
        billDao.openCurrentSessionwithTransaction();
        billDao.persist(entity);
        billDao.closeCurrentSessionwithTransaction();
    }

    public void update(BillsEntity entity) {
        billDao.openCurrentSessionwithTransaction();
        billDao.update(entity);
        billDao.closeCurrentSessionwithTransaction();
    }

    public BillsEntity findById(String id) {
        billDao.openCurrentSession();
        BillsEntity client = billDao.findById(id);
        billDao.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        billDao.openCurrentSessionwithTransaction();
        BillsEntity client = billDao.findById(id);
        billDao.delete(client);
        billDao.closeCurrentSessionwithTransaction();
    }

    public List<BillsEntity> findAll() {
        billDao.openCurrentSession();
        List<BillsEntity> clients = billDao.findAll();
        billDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        billDao.openCurrentSessionwithTransaction();
        billDao.deleteAll();
        billDao.closeCurrentSessionwithTransaction();
    }

    public BillsDaoTest billDao() {
        return billDao;
    }
}
