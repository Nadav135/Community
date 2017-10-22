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
@Table(name="userActivity")
@NamedQueries({
		@NamedQuery(name=UserActivity.GET_USERACTIVITY_BY_ID,
				query="SELECT a FROM UserActivity a WHERE id=:id")
})
@XmlRootElement
public class UserActivity {

	public static final String GET_USERACTIVITY_BY_ID = "GET_USERACTIVITY_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="activity_id")
	private Integer activityId;

	@Column(name="is_partner")
	private Boolean isPartner;


	public UserActivity(){

	}


	public UserActivity(Integer id, Integer userId, Integer activityId, Boolean isPartner) {
		super();
		this.id = id;
		this.userId = userId;
		this.activityId = activityId;
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


	public Integer getActivityId() {
		return activityId;
	}


	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}


	public Boolean getIsPartner() {
		return isPartner;
	}


	public void setIsPartner(Boolean isPartner) {
		this.isPartner = isPartner;
	}


	@Override
	public String toString() {
		return "UserActivity [id=" + id + ", userId=" + userId + ", activityId=" + activityId + ", isPartner="
				+ isPartner + "]";
	}



}
