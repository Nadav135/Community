package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.Rating;

public interface RatingDao {
	
	public void insertRating(Rating rating);
	
	public void deleteRating(Integer ratingId);
	
	public Rating getRatingById(Integer ratingId);
	
	public List<Rating> getRatingByValue(Integer value);
		
	public void updateRating(Rating rating);

	public List<Rating> getAllRatings();
}
