// CustomerController.java
package se.yrgo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.yrgo.domain.Customer;
import se.yrgo.service.CustomerService;
@CrossOrigin(origins="*", maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


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
