//package db_test;
//
//import com.sun.deploy.ClientContainer;
////import dao.impl.ClientDaoImpl;
//import exceptions.DaoException;
//import org.hibernate.Session;
//import utils.HibernateUtils;
//import com.sun.deploy.util.SessionState;
//import utils.*;
//import entities.*;
//import org.hibernate.Session;
//import entities.*;
//import dao.*;
//import org.hibernate.Transaction;
//import java.util.List;
//
//
//public class Db_test {
//
//        public static void main (String[] args)
//        {
//          System.out.println("Now in hibernate test");
//
////            Session session = HibernateUtils.getSessionFactory().openSession();
////            session.beginTransaction();
////
////            ClientsEntity client = new ClientsEntity();
////
////            client.setClientName("TATRKA_1111111");
////            client.setClientEmail("@TATARKA");
////            client.setClientCash(777777d);
////
////
////            session.save(client);
////            session.getTransaction().commit();
////
////            session.close();
//
////            HibernateUtils utils = new HibernateUtils();
////
////            Session session = utils.getSession();
////            Transaction transaction = session.beginTransaction();
////
////            ClientsEntity client = new ClientsEntity();
////            client.setClientName("TATRKA_1111111");
////            client.setClientEmail("@TATARKA");
////            client.setClientCash(777777d);
////
////            System.out.println(client);
////
////            ClientDaoImpl clientDao = new ClientDaoImpl(ClientsEntity.class);
////
////            try {
////                clientDao.save(client);
////            } catch (DaoException e) {
////                e.printStackTrace();
////            }
////
////
////            System.out.println(client);
////            transaction.commit();
//
//
//            ClientServiceTest clientServiceTest = new ClientServiceTest();
//
//            ClientsEntity clientsEntity = new ClientsEntity();
//            clientsEntity.setClientName("bsuir");
//            clientsEntity.setClientEmail("bsuir");
//            System.out.println("*** Persist - start ***");
//            clientServiceTest.persist(clientsEntity);
//            System.out.println("*** Persist - end ***");
//            //List<ClientsEntity> client_list = clientServiceTest.findAll();
////            for (ClientsEntity cl: client_list)
////            {
////                System.out.println(cl);
////            }
////            System.out.println("*** Find - start ***");
//            //clientsEntity.setClientCash(90d);
//            //clientServiceTest.update(clientsEntity);
//
////            clientsEntity = clientServiceTest.findById(String.valueOf(27));
////            System.out.println(clientsEntity);
////
////            clientsEntity.setClientCash(77777d);
////            clientServiceTest.update(clientsEntity);
//            //System.out.println(clientServiceTest.findById(String.valueOf(2)));
//            //System.out.println("*** Find - end ***");
//
//            //clientServiceTest.delete(String.valueOf(27));
//
//            System.exit(0);
//        }
//}
//
//
