package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.Location;

public interface LocationDao {
	
	public void insertLocation(Location location);
	
	public void deleteLocation(Integer locationId);
	
	public Location getLocationById(Integer locationId);
	
	public List<Location> getLocationByName(String name);
		
	public void updateLocation(Location location);

	public List<Location> getAllLocations();

}
