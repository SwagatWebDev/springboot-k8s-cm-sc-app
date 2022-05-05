package com.sahosoft.Spring.Boot.CRUD.Application.repository;

import com.sahosoft.Spring.Boot.CRUD.Application.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
