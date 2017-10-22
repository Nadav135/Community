package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.LikeableDao;
import com.nadav.persistance.dao.impl.LikeableDaoImpl;
import com.nadav.persistance.entities.Likeable;
import com.nadav.service.LikeableService;

public class LikeableServiceImpl implements LikeableService{
	
	private final Logger log = Logger.getLogger(LikeableServiceImpl.class);
	
	private LikeableDao likeableDao = new LikeableDaoImpl();
	
	public LikeableServiceImpl() {
		
	}

	@Override
	public void insertLikeable(Likeable likeable) {
		likeableDao.insertLikeable(likeable);
		
	}

	@Override
	public void deleteLikeable(Integer likeableId) {
		likeableDao.deleteLikeable(likeableId);
		
	}

	@Override
	public Likeable getLikeableById(Integer likeableId) {
		Likeable likeable = likeableDao.getLikeableById(likeableId);
		return likeable;
	}

	@Override
	public List<Likeable> getLikeableByType(String type) {
		List<Likeable> likeables = likeableDao.getLikeableByType(type);
		return likeables;
	}

	@Override
	public void updateLikeable(Likeable likeable) {
		likeableDao.updateLikeable(likeable);
		
	}

	@Override
	public List<Likeable> getAllLikeables() {
		List<Likeable> likeables = likeableDao.getAllLikeables();
		return likeables;
	}
}
