package com.nadav.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.nadav.persistance.dao.GroupDao;
import com.nadav.persistance.dao.impl.GroupDaoImpl;
import com.nadav.persistance.entities.Group;
import com.nadav.service.GroupService;

public class GroupServiceImpl implements GroupService{
	
	private final Logger log = Logger.getLogger(GroupServiceImpl.class);
	
	private GroupDao groupDao = new GroupDaoImpl();
	
	public GroupServiceImpl() {
		
	}

	@Override
	public void insertGroup(Group newGroup) {
		groupDao.insertGroup(newGroup);
		
	}

	@Override
	public void deleteGroup(Integer groupId) {
		groupDao.deleteGroup(groupId);
		
	}

	@Override
	public Group getGroupById(Integer groupId) {
		Group group = groupDao.getGroupById(groupId);
		return group;
	}

	@Override
	public List<Group> getGroupByName(String name) {
		List<Group> groups = groupDao.getGroupByName(name);
		return groups;
	}

	@Override
	public void updateGroup(Group group) {
		groupDao.updateGroup(group);
		
	}

	@Override
	public List<Group> getAllGroups() {
		List<Group> groups = groupDao.getAllGroups();
		return groups;
	}
	
}
