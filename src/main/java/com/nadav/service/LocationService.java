package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.Location;

public interface LocationService {

	public void insertLocation(Location location);
	
	public void deleteLocation(Integer locationId);
	
	public Location getLocationById(Integer locationId);
	
	public List<Location> getLocationByName(String name);
		
	public void updateLocation(Location location);

	public List<Location> getAllLocations();
}
