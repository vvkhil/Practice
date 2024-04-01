package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.Customer;
import com.example.thirdtask.entities.OrderApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAppRepository extends JpaRepository<OrderApp, Integer> {
}
