package guru.springwork.springrestclientexamples.services;

import guru.springwork.api.domin.Customer;
import guru.springwork.api.domin.ListCustomers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Darcy Xian  18/11/20  10:24 pm      spring-rest-client-examples
 */
@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;
    private final String api_url;


    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public Customer getCustomerById(String s) {

        Customer customer = restTemplate.getForObject("https://api.predic8.de:443/shop/customers/" + s, Customer.class);
        return customer;
    }

    @Override
    public ListCustomers getListCustomers() {

        ListCustomers listCustomers = restTemplate.getForObject("https://api.predic8.de:443/shop/customers/", ListCustomers.class);
        return listCustomers;
    }

    @Override
    public Mono<Customer> getCustomerReactive(String ss) {

        return WebClient.create(api_url)
                .get()
                .uri("/" + ss)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(result -> result.bodyToMono(Customer.class));
    }


}


















