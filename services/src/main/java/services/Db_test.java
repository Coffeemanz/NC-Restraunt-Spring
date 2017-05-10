package services;

import com.sun.deploy.ClientContainer;
//import dao.impl.ClientDaoImpl;
import exceptions.DaoException;
import org.hibernate.Session;
import utils.HibernateUtils;
import com.sun.deploy.util.SessionState;
import utils.*;
import entities.*;
import org.hibernate.Session;
import entities.*;
import dao.*;
import org.hibernate.Transaction;
import java.util.List;


public class Db_test {

    public static void main (String[] args)
    {
        System.out.println("Now in hibernate test");

//            Session session = HibernateUtils.getSessionFactory().openSession();
//            session.beginTransaction();
//
//            ClientsEntity client = new ClientsEntity();
//
//            client.setClientName("TATRKA_1111111");
//            client.setClientEmail("@TATARKA");
//            client.setClientCash(777777d);
//
//
//            session.save(client);
//            session.getTransaction().commit();
//
//            session.close();

//            HibernateUtils utils = new HibernateUtils();
//
//            Session session = utils.getSession();
//            Transaction transaction = session.beginTransaction();
//
//            ClientsEntity client = new ClientsEntity();
//            client.setClientName("TATRKA_1111111");
//            client.setClientEmail("@TATARKA");
//            client.setClientCash(777777d);
//
//            System.out.println(client);
//
//            ClientDaoImpl clientDao = new ClientDaoImpl(ClientsEntity.class);
//
//            try {
//                clientDao.save(client);
//            } catch (DaoException e) {
//                e.printStackTrace();
//            }
//
//
//            System.out.println(client);
//            transaction.commit();


        ClientServiceTest clientServiceTest = new ClientServiceTest();
        BillServiceTest billServiceTest = new BillServiceTest();
        FoodServiceTest foodServiceTest = new FoodServiceTest();
        MenuServiceTest menuServiceTest = new MenuServiceTest();
        OrderServiceTest orderServiceTest = new OrderServiceTest();
        WaiterServiceTest waiterServiceTest = new WaiterServiceTest();

        ClientsEntity clientsEntity = new ClientsEntity();
//        clientsEntity.setClientName("DANILA");
//        clientsEntity.setClientEmail("DANILA");



        clientsEntity.setClientName("TEST_SACE");


        clientServiceTest.persist(clientsEntity);

        List<ClientsEntity> list = clientServiceTest.findAll();

        clientsEntity = list.get(list.size() - 1);

        clientsEntity.setClientName("NEW_TEST_SACE");
        clientServiceTest.update(clientsEntity);



//        clientsEntity = clientServiceTest.findById(String.valueOf(32));
//        System.out.println("*** Persist - start ***");
//        clientServiceTest.persist(clientsEntity);
//        System.out.println("*** Persist - end ***");
//        System.out.println(clientsEntity);

//        BillsEntity billsEntity = new BillsEntity();
//        billsEntity.setOrder_id(247);
//        billsEntity.setTotalPrice(100f);
//        billServiceTest.persist(billsEntity);

//        FoodEntity foodEntity = new FoodEntity();
//        foodEntity.setFoodName("TEST");
//        foodEntity.setFoodPrice(100f);
//        foodServiceTest.persist(foodEntity);
//        foodEntity = foodServiceTest.findById(String.valueOf(9));
//        System.out.println(foodEntity);

//        MenuEntity menuEntity = new MenuEntity();
//        menuEntity.setId(123);
//        menuEntity.setMenuName("STINMGFTE");
//        menuServiceTest.persist(menuEntity);

//        WaitersEntity waitersEntity = new WaitersEntity();
//        //waitersEntity.setWaiterName("Lesha");
//        waitersEntity = waiterServiceTest.findById(String.valueOf(2));
//        System.out.println(waitersEntity);

        //waiterServiceTest.persist(waitersEntity);


//        OrdersEntity ordersEntity = new OrdersEntity();
//        ordersEntity.setWaiterByWaiterId(waitersEntity);
//        ordersEntity.setClientsByClientId(clientsEntity);
//        ordersEntity.setFoodByFoodId(foodEntity);
//        orderServiceTest.persist(ordersEntity);


        //List<ClientsEntity> client_list = clientServiceTest.findAll();
//            for (ClientsEntity cl: client_list)
//            {
//                System.out.println(cl);
//            }
//            System.out.println("*** Find - start ***");
        //clientsEntity.setClientCash(90d);
        //clientServiceTest.update(clientsEntity);

//            clientsEntity = clientServiceTest.findById(String.valueOf(27));
//            System.out.println(clientsEntity);
//
//            clientsEntity.setClientCash(77777d);
//            clientServiceTest.update(clientsEntity);
        //System.out.println(clientServiceTest.findById(String.valueOf(2)));
        //System.out.println("*** Find - end ***");

        //clientServiceTest.delete(String.valueOf(27));

        System.exit(0);
    }
}


