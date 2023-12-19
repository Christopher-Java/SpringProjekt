// CustomerController.java
package se.yrgo.SpringCusomer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SpringCusomer.domain.Customer;
import se.yrgo.SpringCusomer.service.CustomerService;

import java.util.List;

@CrossOrigin(origins="*", maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers(Model model) {
        return customerService.getAllCustomers(); // Assuming you have a Thymeleaf template named customer-list.html
    }

    @GetMapping("/customers/{customerId}")
    public String getCustomerById(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);
        return "customer-details"; // Assuming you have a Thymeleaf template named customer-details.html
    }

    // Additional controller methods for creating, updating, and deleting customers
    @PostMapping("/create-customer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.ok("Customer created successfully" + customer);
    }
}
