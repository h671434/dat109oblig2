package db;


import no.hvl.dao.AddressDAO;
import no.hvl.entities.Address;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
    }


    @AfterAll
    static void removeStuffFromDB(){

    }





}
