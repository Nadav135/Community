package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.StatusDao;
import com.nadav.persistance.dao.impl.StatusDaoImpl;
import com.nadav.persistance.entities.Status;
import com.nadav.service.StatusService;

public class StatusServiceImpl implements StatusService{

	private final Logger log = Logger.getLogger(StatusServiceImpl.class);
	
	private StatusDao statusDao = new StatusDaoImpl();
	
	public StatusServiceImpl() {
		
	}

	@Override
	public void insertStatus(Status status) {
		statusDao.insertStatus(status);
		
	}

	@Override
	public void deleteStatus(Integer statusId) {
		statusDao.deleteStatus(statusId);
		
	}

	@Override
	public Status getStatusById(Integer statusId) {
		Status status = statusDao.getStatusById(statusId);
		return status;
	}

	@Override
	public List<Status> getStatusByName(String name) {
		List<Status> statuses = statusDao.getStatusByName(name);
		return statuses;
	}

	@Override
	public void updateStatus(Status status) {
		statusDao.updateStatus(status);
		
	}

	@Override
	public List<Status> getAllStatuses() {
		List<Status> statuses = statusDao.getAllStatuses();
		return statuses;
	}

}
