package com.backend.rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.rest.model.UserM;

@Repository
public interface UserRepository extends CrudRepository<UserM, Long>{
	
}
