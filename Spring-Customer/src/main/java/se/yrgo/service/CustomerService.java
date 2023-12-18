// CustomerService.java
package se.yrgo.service;

import se.yrgo.domain.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public Customer getCustomerById(Long customerId);

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Long customerId, Customer updatedCustomer);

    public void deleteCustomer(Long customerId);
}
