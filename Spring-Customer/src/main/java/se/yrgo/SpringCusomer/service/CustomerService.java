// CustomerService.java
package se.yrgo.SpringCusomer.service;

import se.yrgo.SpringCusomer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    //public Customer getCustomerById(Long customerId);
    Optional<Customer> getCustomerById(Long id);

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Long customerId, Customer updatedCustomer);

    public void deleteCustomer(Long customerId);
}
