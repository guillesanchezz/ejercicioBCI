package com.exerciseBCI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exerciseBCI.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query(value = "SELECT * FROM USERS WHERE EMAIL = ?1", nativeQuery = true)
	Optional<UserEntity> findByEmail(String email);

}
