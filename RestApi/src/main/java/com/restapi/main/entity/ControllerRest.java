package com.restapi.main.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {
	
	@Autowired
	private Books book;
	
	@Autowired
	private Services ser;
	
	/*
	 Without Response Entity
	
	
	@GetMapping("/books")
	public List<Books> GetAl()
	{
		return ser.getAlls();
	}
	

	
	@GetMapping("/books/{a}")
	public Books GetById(@PathVariable("a") int idd)
	{
		return ser.GetByIDD(idd);
	}
	
	@PostMapping("/books")
	public Books add(@RequestBody Books b)
	{
		return ser.save(b);
	}
	
	@DeleteMapping("/books/{n}")
	public void delete(@PathVariable("n") int id)
	{
		ser.deltee(id);
	}
	
	@PutMapping("/books/{n}")
	public Books update(@RequestBody Books b,@PathVariable("n") int id)
	{
		return ser.updatee(b, id);
	}
	
	 */
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Books>> GetAl()
	{
		List<Books> li=ser.getAlls();
		if(li.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
		return ResponseEntity.of(Optional.of(li));
	}
	

	
	@GetMapping("/books/{a}")
	public ResponseEntity<Books> GetById(@PathVariable("a") int idd)
	{
		try{Books b=ser.GetByIDD(idd);
		if(b==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<Void> add(@RequestBody Books b)
	{
		try {
			Books bb=ser.save(b);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/books/{n}")
	public ResponseEntity<Void> delete(@PathVariable("n") int id)
	{
		try {
		ser.deltee(id);
		return ResponseEntity.ok().build();		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{n}")
	public ResponseEntity<Books> update(@RequestBody Books b,@PathVariable("n") int id)
	{
		try {
		Books be=ser.updatee(b, id);
		return ResponseEntity.of(Optional.of(be));
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	

}
