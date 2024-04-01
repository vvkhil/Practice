package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.BaskShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaskShopRepository extends JpaRepository<BaskShop, Integer> {
}
