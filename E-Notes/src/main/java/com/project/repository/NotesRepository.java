package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Notes;
import com.project.entity.User;


//JpaRepository<Entity name, data type of primary key>
public interface NotesRepository extends JpaRepository<Notes, Integer> {
	
	//Custom methods
	public List<Notes> findByUser(User user);
	
}







