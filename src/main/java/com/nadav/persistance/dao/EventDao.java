package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.Event;

public interface EventDao {
	
	public void insertEvent(Event event);
	
	public void deleteEvent(Integer eventId);
	
	public Event getEventById(Integer eventId);
	
	public List<Event> getEventByName(String name);
		
	public void updateEvent(Event event);

	public List<Event> getAllEvents();
}
