package com.restapi.main.repo;

import org.springframework.data.repository.CrudRepository;

import com.restapi.main.entity.Books;

public interface UserRepository extends CrudRepository<Books, Integer>{
	
	

}
