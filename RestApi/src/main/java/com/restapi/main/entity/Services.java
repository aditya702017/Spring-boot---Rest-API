package com.restapi.main.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.main.repo.UserRepository;

@Component
public class Services {
	
	@Autowired
	private UserRepository ur;
	

	public List<Books> getAlls()
	{
		return (List<Books>) ur.findAll();
	}
	
	public Books GetByIDD(int id)
	{
		Optional<Books> u4=ur.findById(id) ;
		Books bb=u4.get();
		
		return bb;
		
		
	}
	
	public Books save(Books b)
	{
		return ur.save(b);
	}
	
	public void deltee(int id)
	{
		ur.deleteById(id);
	}
	
	public Books updatee(Books b, int id)
	{
		
		 return ur.save(b);
	}

}
