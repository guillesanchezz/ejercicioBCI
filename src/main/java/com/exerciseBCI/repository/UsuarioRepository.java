package com.exerciseBCI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exerciseBCI.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
	
	@Query(value = "SELECT * FROM USUARIOS WHERE EMAIL = ?1", nativeQuery = true)
	Optional<UsuarioEntity> findByEmail(String email);

}
