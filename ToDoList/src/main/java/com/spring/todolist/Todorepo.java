package com.spring.todolist;

import org.springframework.data.jpa.repository.JpaRepository;



public interface Todorepo extends JpaRepository<ToDo, Long>{

	

}