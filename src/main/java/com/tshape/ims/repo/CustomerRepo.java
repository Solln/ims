package com.tshape.ims.repo;

import com.tshape.ims.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
