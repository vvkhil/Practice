package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.Address;
import com.example.thirdtask.entities.BaskShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaskShopRepository extends JpaRepository<BaskShop, Integer> {
    List<BaskShop> findByUserId(Integer userId);
}
