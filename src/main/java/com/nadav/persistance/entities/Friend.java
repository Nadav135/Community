package com.nadav.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;

@Entity
@Table(name="friend")
@NamedQueries({
		@NamedQuery(name=Friend.GET_ALL_FRIEND,
				query="SELECT a FROM Friend a"),
		@NamedQuery(name=Friend.GET_ALL_RELATED_FRIEND,
				query="SELECT a FROM Friend a WHERE user_id=:userId"),
		@NamedQuery(name=Friend.GET_FRIEND_BY_ID,
				query="SELECT a FROM Friend a WHERE id=:id"),
		@NamedQuery(name=Friend.GET_FRIENDSHIP,
				query="SELECT a FROM Friend a WHERE user_id=:userId AND friend_id=:friendId")
})

@XmlRootElement
public class Friend {

	public static final String GET_ALL_FRIEND = "GET_ALL_FRIEND";
	public static final String GET_ALL_RELATED_FRIEND = "GET_ALL_RELATED_FRIEND";
	public static final String GET_FRIEND_BY_ID = "GET_FRIEND_BY_ID";
	public static final String GET_FRIENDSHIP = "GET_FRIENDSHIP";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="friend_id")
	private Integer friendId;

	@Column(name="relation_status")
	private String relationStatus;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Friend(){

	}

	public Friend(Integer id, Integer userId, Integer friendId, String relationStatus, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.friendId = friendId;
		this.relationStatus = relationStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String getRelationStatus() {
		return relationStatus;
	}

	public void setRelationStatus(String relationStatus) {
		this.relationStatus = relationStatus;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", userId=" + userId + ", friendId=" + friendId + ", relationStatus="
				+ relationStatus + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	


}
