package com.exerciseBCI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.exerciseBCI.entity.TelefonoEntity;

public interface TelefonoRepository extends JpaRepository<TelefonoEntity, Long>{

}
