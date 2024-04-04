package com.example.thirdtask.repositories;

import com.example.thirdtask.entities.BaskShop;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.thirdtask.entities.UserApp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Integer> {
    List<UserApp> findByRoleId(Integer roleId);
    Optional<UserApp> findByEmail(String email);
    Optional<UserApp> findByEmailAndPassword(String email, String password);
}
