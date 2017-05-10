package services;

import dao.impl.FoodDaoTest;
import entities.FoodEntity;

import java.util.List;

/**
 * Created by Сергей on 10.05.2017.
 */
public class FoodServiceTest {

    private static FoodDaoTest foodDao;

    public FoodServiceTest() {
        foodDao = new FoodDaoTest();
    }

    public void persist(FoodEntity entity) {
        foodDao.openCurrentSessionwithTransaction();
        foodDao.persist(entity);
        foodDao.closeCurrentSessionwithTransaction();
    }

    public void update(FoodEntity entity) {
        foodDao.openCurrentSessionwithTransaction();
        foodDao.update(entity);
        foodDao.closeCurrentSessionwithTransaction();
    }

    public FoodEntity findById(String id) {
        foodDao.openCurrentSession();
        FoodEntity client = foodDao.findById(id);
        foodDao.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        foodDao.openCurrentSessionwithTransaction();
        FoodEntity client = foodDao.findById(id);
        foodDao.delete(client);
        foodDao.closeCurrentSessionwithTransaction();
    }

    public List<FoodEntity> findAll() {
        foodDao.openCurrentSession();
        List<FoodEntity> clients = foodDao.findAll();
        foodDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        foodDao.openCurrentSessionwithTransaction();
        foodDao.deleteAll();
        foodDao.closeCurrentSessionwithTransaction();
    }

    public FoodDaoTest foodDao() {
        return foodDao;
    }
}
