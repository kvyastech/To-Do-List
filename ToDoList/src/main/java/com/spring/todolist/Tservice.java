package com.spring.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tservice {
    @Autowired
    Todorepo repo;

	public List<ToDo> getAllToDoItems() {
		System.out.println("In service for all items");

		try {
			return StreamSupport.stream(repo.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception e) {

			return new ArrayList<>(); // Return an empty list in case of an error
		}
	}

	public ToDo getToDoItemById(Long id) {
		return repo.findById(id).get();
	}

	public boolean updateStatus(Long id) {
		ToDo todo = getToDoItemById(id);
		todo.setStatus("Completed");

		return saveOrUpdateToDoItem(todo);
	}

	public boolean saveOrUpdateToDoItem(ToDo todo) {
		ToDo updatedObj = repo.save(todo);

		if (getToDoItemById(updatedObj.getId()) != null) {
			return true;
		}

		return false;
	}

	public boolean deleteToDoItem(Long id) {
		repo.deleteById(id);

		if (repo.findById(id).isEmpty()) {
			return true;
		}

		return false;
	}

}
