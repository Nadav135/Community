package com.nadav.service;

import java.util.List;

import com.nadav.persistance.entities.Friend;

public interface FriendService {

	public void insertFriend(Friend friend);
	
	public void deleteFriend(Integer friendId);
	
	public Friend getFriendById(Integer friendId);
	
	public Friend getFriendship(Integer userId, Integer friendId);
		
	public void updateFriend(Friend friend);
	
	public List<Friend> getAllRelatedFriends(Integer userId);

	public List<Friend> getAllFriends();
}
