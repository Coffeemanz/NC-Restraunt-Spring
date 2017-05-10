package services;

import dao.impl.MenuDaoTest;
import entities.MenuEntity;
import java.util.*;

/**
 * Created by Сергей on 10.05.2017.
 */
public class MenuServiceTest {

    private static MenuDaoTest menuDao;

    public MenuServiceTest() {
        menuDao = new MenuDaoTest();
    }

    public void persist(MenuEntity entity) {
        menuDao.openCurrentSessionwithTransaction();
        menuDao.persist(entity);
        menuDao.closeCurrentSessionwithTransaction();
    }

    public void update(MenuEntity entity) {
        menuDao.openCurrentSessionwithTransaction();
        menuDao.update(entity);
        menuDao.closeCurrentSessionwithTransaction();
    }

    public MenuEntity findById(String id) {
        menuDao.openCurrentSession();
        MenuEntity client = menuDao.findById(id);
        menuDao.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        menuDao.openCurrentSessionwithTransaction();
        MenuEntity client = menuDao.findById(id);
        menuDao.delete(client);
        menuDao.closeCurrentSessionwithTransaction();
    }

    public List<MenuEntity> findAll() {
        menuDao.openCurrentSession();
        List<MenuEntity> clients = menuDao.findAll();
        menuDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        menuDao.openCurrentSessionwithTransaction();
        menuDao.deleteAll();
        menuDao.closeCurrentSessionwithTransaction();
    }

    public MenuDaoTest menuDao() {
        return menuDao;
    }
}
