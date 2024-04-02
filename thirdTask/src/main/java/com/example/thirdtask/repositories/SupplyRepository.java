package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Integer> {
}
