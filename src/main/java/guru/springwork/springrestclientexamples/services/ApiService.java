package guru.springwork.springrestclientexamples.services;

import guru.springwork.api.domin.Customer;
import guru.springwork.api.domin.ListCustomers;
import reactor.core.publisher.Mono;


/**
 * Darcy Xian  18/11/20  10:18 pm      spring-rest-client-examples
 */
public interface ApiService {
    Customer getCustomerById(String s);

    ListCustomers getListCustomers();

    Mono<Customer> getCustomerReactive(String s);

}
