package guru.springwork.springrestclientexamples.controllers;


import guru.springwork.api.domin.Param;
import guru.springwork.springrestclientexamples.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Function;

/**
 * Darcy Xian  20/11/20  9:50 am      spring-rest-client-examples
 */
@Slf4j
@Controller
public class CustomerController {

    private ApiService apiService;

    public CustomerController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index(Model model) {
        model.addAttribute("pparam", new Param());
        return "index";
    }

    @PostMapping("/customersId/")
    public String formPost(@ModelAttribute Param param, Model model) {
        log.error("I am in @PostMapping 34:" + param.getId());

        //  model.addAttribute("customers", apiService.getCustomerById(param.getId()));
        model.addAttribute("customers", apiService.getCustomerReactive(param.getId()));
        return "customers";
    }

    @GetMapping("/allCustomers")
    public String allCustomers(Model model) {
        model.addAttribute("customers", apiService.getListCustomers().getCustomers());


        return "customers";
    }


}



















