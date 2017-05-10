import dao.ClientServiceTest;
import entities.ClientsEntity;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by Сергей on 10.05.2017.
 */
public class ClientServiceTesting {

    @Test
    public void save()
    {
        ClientServiceTest clientServiceTest = new ClientServiceTest();
        ClientsEntity clientsEntity = new ClientsEntity();

        clientsEntity.setClientName("TEST");

        clientServiceTest.persist(clientsEntity);

        List<ClientsEntity> list = clientServiceTest.findAll();

        assertEquals("Object is not created", list.get(list.size() - 1).getClientName(), clientsEntity.getClientName() );
    }

    @Test
    public void read()
    {
        ClientsEntity clientsEntity = new ClientsEntity();
        ClientServiceTest clientServiceTest = new ClientServiceTest();
        List<ClientsEntity> list = clientServiceTest.findAll();

        clientsEntity = clientServiceTest.findById(String.valueOf(list.get(list.size() - 1).getId()));
        assertNotNull("Object not found", clientsEntity);
    }

    @Test
    public void delete()
    {
        ClientServiceTest clientServiceTest = new ClientServiceTest();
        ClientsEntity clientsEntity = new ClientsEntity();
        List<ClientsEntity> list = null;


        clientsEntity.setClientName("TEST");
        clientServiceTest.persist(clientsEntity);
        list = clientServiceTest.findAll();
        clientsEntity.setId(list.get(list.size() - 1).getId());

        clientServiceTest.delete(String.valueOf(clientsEntity.getId()));

        ClientsEntity findClient = clientServiceTest.findById(String.valueOf(clientsEntity.getId()));
        assertNull("Object not deleted", findClient);
    }

    @Test
    public void update()
    {
        ClientsEntity clientsEntity = new ClientsEntity();
        ClientServiceTest clientServiceTest = new ClientServiceTest();
        List<ClientsEntity> list = clientServiceTest.findAll();

        clientsEntity.setClientName("TEST");
        clientServiceTest.persist(clientsEntity);

        String oldName = clientsEntity.getClientName();

        clientsEntity = list.get(list.size() - 1);

        clientsEntity.setClientName("NEW_TEST");
        clientServiceTest.update(clientsEntity);
        list = clientServiceTest.findAll();
        assertNotSame("Not updated", list.get(list.size() -1).getClientName(), oldName);

    }
}
