// CustomerController.java
package se.yrgo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer-list"; // Assuming you have a Thymeleaf template named customer-list.html
    }

    @GetMapping("/customers/{customerId}")
    public String getCustomerById(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);
        return "customer-details"; // Assuming you have a Thymeleaf template named customer-details.html
    }

    // Additional controller methods for creating, updating, and deleting customers
}
