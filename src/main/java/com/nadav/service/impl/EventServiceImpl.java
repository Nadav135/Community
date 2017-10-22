package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.EventDao;
import com.nadav.persistance.dao.impl.EventDaoImpl;
import com.nadav.persistance.entities.Event;
import com.nadav.service.EventService;

public class EventServiceImpl implements EventService{

	private final Logger log = Logger.getLogger(EventServiceImpl.class);
	
	private EventDao eventDao = new EventDaoImpl();
	
	public EventServiceImpl() {
		
	}

	@Override
	public void insertEvent(Event event) {
		eventDao.insertEvent(event);
		
	}

	@Override
	public void deleteEvent(Integer eventId) {
		eventDao.deleteEvent(eventId);
	}

	@Override
	public Event getEventById(Integer eventId) {
		Event event = eventDao.getEventById(eventId);
		return event;
	}

	@Override
	public List<Event> getEventByName(String name) {
		List<Event> events = eventDao.getEventByName(name);
		return events;
	}

	@Override
	public void updateEvent(Event event) {
		eventDao.updateEvent(event);
		
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> events = eventDao.getAllEvents();
		return events;
	}
}
