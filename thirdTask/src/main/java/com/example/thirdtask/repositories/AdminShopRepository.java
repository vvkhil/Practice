package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.AdminShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminShopRepository extends JpaRepository<AdminShop, Integer> {
}
