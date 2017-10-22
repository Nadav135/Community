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
@Table(name="userInEvent")
@NamedQueries({
		@NamedQuery(name=UserInEvent.GET_ALL_USERINEVENT,
				query="SELECT a FROM UserInEvent a"),
		@NamedQuery(name=UserInEvent.GET_USERINEVENT_BY_ID,
				query="SELECT a FROM UserInEvent a WHERE id=:id")
})
@XmlRootElement
public class UserInEvent {

	public static final String GET_ALL_USERINEVENT = "GET_ALL_USERINEVENT";
	public static final String GET_USERINEVENT_BY_ID = "GET_USERINEVENT_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="event_id")
	private Integer eventId;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="status")
	private String status;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	public UserInEvent(){

	}

	public UserInEvent(Integer id, Integer eventId, Integer userId, String status, Timestamp updatedAt, Timestamp createdAt) {
		super();
		this.id = id;
		this.eventId = eventId;
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

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
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
		return "UserInEvent [id=" + id + ", eventId=" + eventId + ", userId=" + userId + ", status=" + status
				+ ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
	}


}
