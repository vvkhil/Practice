package com.example.thirdtask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.thirdtask.entities.UserApp;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Integer> {
}
