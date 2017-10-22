package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.RatingDao;
import com.nadav.persistance.dao.impl.RatingDaoImpl;
import com.nadav.persistance.entities.Rating;
import com.nadav.service.RatingService;

public class RatingServiceImpl implements RatingService{
	
	private final Logger log = Logger.getLogger(RatingServiceImpl.class);
	
	private RatingDao ratingDao = new RatingDaoImpl();
	
	public RatingServiceImpl() {
		
	}

	@Override
	public void insertRating(Rating rating) {
		ratingDao.insertRating(rating);
		
	}

	@Override
	public void deleteRating(Integer ratingId) {
		ratingDao.deleteRating(ratingId);
		
	}

	@Override
	public Rating getRatingById(Integer ratingId) {
		Rating rating = ratingDao.getRatingById(ratingId);
		return rating;
	}

	@Override
	public List<Rating> getRatingByValue(Integer value) {
		List<Rating> ratings = ratingDao.getRatingByValue(value);
		return ratings;
	}

	@Override
	public void updateRating(Rating rating) {
		ratingDao.updateRating(rating);
		
	}

	@Override
	public List<Rating> getAllRatings() {
		List<Rating> ratings = ratingDao.getAllRatings();
		return ratings;
	}
}
