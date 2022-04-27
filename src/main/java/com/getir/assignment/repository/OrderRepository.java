package com.getir.assignment.repository;

import com.getir.assignment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface OrderRepository extends JpaRepository<Order, Id> {

}
