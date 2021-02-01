package com.ding.demo.dao;

import com.ding.demo.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ding
 * @date 2021/2/1
 */
public interface CustomerRepository extends MongoRepository<Customer,String> {

}
