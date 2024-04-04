package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.OrderApp;
import com.example.thirdtask.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderAppRepository extends JpaRepository<OrderApp, Integer> {
    List<OrderApp> findByShopId(Integer shopId);
    List<OrderApp> findByCartId(Integer cartId);
}
