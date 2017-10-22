package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.FriendDao;
import com.nadav.persistance.dao.impl.FriendDaoImpl;
import com.nadav.persistance.entities.Friend;
import com.nadav.service.FriendService;

public class FriendServiceImpl implements FriendService{

	private final Logger log = Logger.getLogger(FriendServiceImpl.class);
	
	private FriendDao friendtDao = new FriendDaoImpl();
	
	public FriendServiceImpl() {
		
	}

	@Override
	public void insertFriend(Friend friend) {
		friendtDao.insertFriend(friend);
	}

	@Override
	public void deleteFriend(Integer friendId) {
		friendtDao.deleteFriend(friendId);
	}

	@Override
	public Friend getFriendById(Integer friendId) {
		Friend friend = friendtDao.getFriendById(friendId);
		return friend;
	}

	@Override
	public Friend getFriendship(Integer userId, Integer friendId) {
		Friend friend = friendtDao.getFriendship(userId, friendId);
		return friend;
	}

	@Override
	public void updateFriend(Friend friend) {
		friendtDao.updateFriend(friend);
		
	}

	@Override
	public List<Friend> getAllRelatedFriends(Integer userId) {
		List<Friend> friends = friendtDao.getAllRelatedFriends(userId);
		return friends;
	}

	@Override
	public List<Friend> getAllFriends() {
		List<Friend> friends = friendtDao.getAllFriends();
		return friends;
	}
}
