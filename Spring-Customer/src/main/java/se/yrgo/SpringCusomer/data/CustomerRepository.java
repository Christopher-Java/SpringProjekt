package se.yrgo.SpringCusomer.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.SpringCusomer.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

