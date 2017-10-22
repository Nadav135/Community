package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.Likeable;

public interface LikeableService {

	public void insertLikeable(Likeable likeable);
	
	public void deleteLikeable(Integer likeableId);
	
	public Likeable getLikeableById(Integer likeableId);
	
	public List<Likeable> getLikeableByType(String type);
		
	public void updateLikeable(Likeable likeable);
	
	public List<Likeable> getAllLikeables();
}
