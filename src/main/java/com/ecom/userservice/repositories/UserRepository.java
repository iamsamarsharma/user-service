package com.ecom.userservice.repositories;

import com.ecom.userservice.entities.EComUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<EComUser, String> {
}
