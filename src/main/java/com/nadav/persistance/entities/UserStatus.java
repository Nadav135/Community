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

@Entity
@Table(name="userStatus")
@NamedQueries({
		@NamedQuery(name=UserStatus.GET_ALL_USERSTATUS,
				query="SELECT a FROM UserStatus a"),
		@NamedQuery(name=UserStatus.GET_USERSTATUS_BY_ID,
				query="SELECT a FROM UserStatus a WHERE id=:id")
})
@XmlRootElement
public class UserStatus {

	public static final String GET_ALL_USERSTATUS = "GET_ALL_USERSTATUS";
	public static final String GET_USERSTATUS_BY_ID = "GET_USERSTATUS_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="status_id")
	private Integer statusId;

	@Column(name="is_partner")
	private Boolean isPartner;


	public UserStatus(){

	}

	public UserStatus(Integer id, Integer userId, Integer statusId, Boolean isPartner) {
		super();
		this.id = id;
		this.userId = userId;
		this.statusId = statusId;
		this.isPartner = isPartner;
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

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Boolean getIsPartner() {
		return isPartner;
	}

	public void setIsPartner(Boolean isPartner) {
		this.isPartner = isPartner;
	}

	@Override
	public String toString() {
		return "UserStatus [id=" + id + ", userId=" + userId + ", statusId=" + statusId + ", isPartner=" + isPartner
				+ "]";
	}

}
