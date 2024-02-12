package db;


import no.hvl.dao.AddressDAO;
import no.hvl.entities.Address;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestAdress {


    private Address testAddress;
    private AddressDAO addressDao;


    @BeforeEach
    void setup(){
        addressDao = new AddressDAO();
        testAddress = new Address("Hello Street 55", "5055", "Bergen");
    }

    @Test
    void testWrite(){
        addressDao.writeEntity(testAddress);
        Address response = addressDao.getById(testAddress.getStreetAddress());
        Assertions.assertNotNull(response);
        Assertions.assertEquals(testAddress, response);
        addressDao.deleteEntity(response);
    }


    @AfterAll
    static void removeStuffFromDB(){

    }





}
