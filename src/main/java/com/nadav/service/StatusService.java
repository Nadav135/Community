package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.Status;

public interface StatusService {
	
	public void insertStatus(Status status);
	
	public void deleteStatus(Integer statusId);
	
	public Status getStatusById(Integer statusId);
	
	public List<Status> getStatusByName(String name);
		
	public void updateStatus(Status status);

	public List<Status> getAllStatuses();
}
