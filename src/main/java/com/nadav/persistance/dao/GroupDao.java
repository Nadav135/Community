package com.nadav.persistance.dao;

import java.util.List;

import com.nadav.persistance.entities.Group;

public interface GroupDao {
	
	public void insertGroup(Group newGroup);
	
	public void deleteGroup(Integer groupId);
	
	public Group getGroupById(Integer groupId);
	
	public List<Group> getGroupByName(String name);
		
	public void updateGroup(Group group);
	
	public List<Group> getAllGroups();
}
