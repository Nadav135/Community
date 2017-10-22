package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.LocationDao;
import com.nadav.persistance.dao.impl.LocationDaoImpl;
import com.nadav.persistance.entities.Location;
import com.nadav.service.LocationService;

public class LocationServiceImpl  implements LocationService{

	private final Logger log = Logger.getLogger(LocationServiceImpl.class);
	
	private LocationDao locationDao = new LocationDaoImpl();
	
	public LocationServiceImpl() {
		
	}

	@Override
	public void insertLocation(Location location) {
		locationDao.insertLocation(location);
		
	}

	@Override
	public void deleteLocation(Integer locationId) {
		locationDao.deleteLocation(locationId) ;
		
	}

	@Override
	public Location getLocationById(Integer locationId) {
		Location location = locationDao.getLocationById(locationId);
		return location;
	}

	@Override
	public List<Location> getLocationByName(String name) {
		List<Location> locations = locationDao.getLocationByName(name);
		return locations;
	}

	@Override
	public void updateLocation(Location location) {
		locationDao.updateLocation(location);
		
	}

	@Override
	public List<Location> getAllLocations() {
		List<Location> locations = locationDao.getAllLocations();
		return locations;
	}

}
