package com.example.vetclinica.repos;

import com.example.vetclinica.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepos extends CrudRepository<Order, Long> {
}
