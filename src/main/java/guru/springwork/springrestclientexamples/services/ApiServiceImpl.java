package guru.springwork.springrestclientexamples.services;

import guru.springwork.api.domin.Customer;
import guru.springwork.api.domin.ListCustomers;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Darcy Xian  18/11/20  10:24 pm      spring-rest-client-examples
 */
@Service
public class ApiServiceImpl implements ApiService{

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Customer getCustomerById (String s) {

        Customer customer = restTemplate.getForObject("https://api.predic8.de:443/shop/customers/" + s, Customer.class);
        return customer;
    }

    @Override
    public ListCustomers getListCustomers() {

        ListCustomers listCustomers = restTemplate.getForObject("https://api.predic8.de:443/shop/customers/",ListCustomers.class);
        return listCustomers;
    }

}
