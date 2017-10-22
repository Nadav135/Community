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
@Table(name="userInGroup")
@NamedQueries({
		@NamedQuery(name=UserInGroup.GET_ALL_USERINGROUP,
				query="SELECT a FROM UserInGroup a"),
		@NamedQuery(name=UserInGroup.GET_USERINGROUP_BY_ID,
				query="SELECT a FROM UserInGroup a WHERE id=:id")
})
@XmlRootElement
public class UserInGroup {

	public static final String GET_ALL_USERINGROUP = "GET_ALL_USERINGROUP";
	public static final String GET_USERINGROUP_BY_ID = "GET_USERINGROUP_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="group_id")
	private Integer groupId;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="status")
	private String status;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	public UserInGroup(){

	}

	public UserInGroup(Integer id, Integer groupId, Integer userId, String status, Timestamp updatedAt, Timestamp createdAt) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.userId = userId;
		this.status = status;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "UserInGroup [id=" + id + ", groupId=" + groupId + ", userId=" + userId + ", status=" + status
				+ ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
	}


}
