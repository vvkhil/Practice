package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.BaskShoe;
import com.example.thirdtask.entities.BaskShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BaskShoeRepository extends JpaRepository<BaskShoe, Integer> {
    List<BaskShoe> findAllByShopContains(Set<BaskShop> shop);
    List<BaskShoe> findAllByShopNotContains(Set<BaskShop> shop);
}
