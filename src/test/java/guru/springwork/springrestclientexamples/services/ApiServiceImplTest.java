package guru.springwork.springrestclientexamples.services;

import guru.springwork.api.domin.Customer;
import guru.springwork.api.domin.ListCustomers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;


/**
 * Darcy Xian  18/11/20  10:33 pm      spring-rest-client-examples
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetCustomer() throws Exception {
        Customer pet = apiService.getCustomerById("2");

        //assertEquals(4,pets.size());
    }

    @Test
    public void testGetListCustomers() throws Exception {
        ListCustomers listCustomers = apiService.getListCustomers();
        assertEquals(10, listCustomers.getCustomers().size());
    }
}
