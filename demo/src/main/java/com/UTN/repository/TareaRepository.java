package com.UTN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UTN.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
