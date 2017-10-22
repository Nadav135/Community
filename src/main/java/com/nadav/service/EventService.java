package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.Event;

public interface EventService {

	public void insertEvent(Event event);
	
	public void deleteEvent(Integer eventId);
	
	public Event getEventById(Integer eventId);
	
	public List<Event> getEventByName(String name);
		
	public void updateEvent(Event event);

	public List<Event> getAllEvents();
}
