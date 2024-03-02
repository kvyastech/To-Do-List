package com.spring.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.todolist.model.ToDo;



public interface Todorepo extends JpaRepository<ToDo, Long>{

	

}