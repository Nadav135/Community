package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.Likeable;

public interface LikeableDao {
	
	public void insertLikeable(Likeable likeable);
	
	public void deleteLikeable(Integer likeableId);
	
	public Likeable getLikeableById(Integer likeableId);
	
	public List<Likeable> getLikeableByType(String type);
		
	public void updateLikeable(Likeable likeable);
	
	public List<Likeable> getAllLikeables();
}
