package com.example.thirdtask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.thirdtask.entities.UserApp;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {
}
