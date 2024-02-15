package com.tns.placementservice;

import javax.persistence.NoResultException;

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
public class Placement_Service_Controller 
{
	@Autowired(required=true)
	private Placement_Service service;
	
	@GetMapping("/Placementservice")
	public java.util.List<Placement> list()
	{
		return service.listAll();
	}
	
	@GetMapping("/Placementservice/{P_companyid}")
	public ResponseEntity<Placement> get(@PathVariable Integer P_companyid)
	{
		try
		{
			Placement P=service.get(P_companyid);
			return new ResponseEntity<Placement>(P,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Placementservice")
	public void add(@RequestBody Placement P)
	{
		service.save(P);
	}
	
	@PutMapping("/P;acementservice/{P_companyid}")
	public ResponseEntity<?> update(@RequestBody Placement P, @PathVariable Integer P_companyid)
	{
		Placement existP=service.get(P_companyid);
		service.save(existP);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/Placementservice/{P_companyid}")
	public void delete(@PathVariable Integer P_companyid)
	{
		service.delete(P_companyid);
	}

}
