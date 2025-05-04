package com.ecom.userservice.repositories;

import com.ecom.userservice.entities.EComUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EComUser, Long> {
}
