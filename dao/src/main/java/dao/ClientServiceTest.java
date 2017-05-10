package dao;


import dao.impl.ClientDaoTest;
import entities.*;
import dao.*;
import java.util.List;

/**
 * Created by Сергей on 04.05.2017.
 */
public class ClientServiceTest {

    private static ClientDaoTest clientDao;

    public ClientServiceTest() {
        clientDao = new ClientDaoTest();
    }

    public void persist(ClientsEntity entity) {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.persist(entity);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public void update(ClientsEntity entity) {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.update(entity);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public ClientsEntity findById(String id) {
        clientDao.openCurrentSession();
        ClientsEntity client = clientDao.findById(id);
        clientDao.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        clientDao.openCurrentSessionwithTransaction();
        ClientsEntity client = clientDao.findById(id);
        clientDao.delete(client);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public List<ClientsEntity> findAll() {
        clientDao.openCurrentSession();
        List<ClientsEntity> clients = clientDao.findAll();
        clientDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.deleteAll();
        clientDao.closeCurrentSessionwithTransaction();
    }

    public ClientDaoTest clientDao() {
        return clientDao;
    }
}
