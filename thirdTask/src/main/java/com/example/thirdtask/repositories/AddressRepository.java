package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
