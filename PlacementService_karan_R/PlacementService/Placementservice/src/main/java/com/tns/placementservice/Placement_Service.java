package com.tns.placementservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class Placement_Service
{
	@Autowired
	private Placement_Service_Repository repo;
	
	public List<Placement> listAll()
	{
		return repo.findAll();
	}
	
	public void save(Placement P)
	{
		repo.save(P);
	}
	
	public Placement get(Integer P_companyid)
	{
		return repo.findById(P_companyid).get();
	}
	public void delete(Integer P_companyid)
	{
		repo.deleteById(P_companyid);
	}
}
