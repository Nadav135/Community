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
@Table(name="event")
@NamedQueries({
		@NamedQuery(name=Event.GET_ALL_EVENT,
				query="SELECT a FROM Event a"),
		@NamedQuery(name=Event.GET_ALL_EVENT_BY_NAME,
				query="SELECT a FROM Event a WHERE name like :name"),
		@NamedQuery(name=Event.GET_EVENT_BY_ID,
				query="SELECT a FROM Event a WHERE id=:id")
})
@XmlRootElement
public class Event {

	public static final String GET_ALL_EVENT = "GET_ALL_EVENT";
	public static final String GET_ALL_EVENT_BY_NAME = "GET_ALL_EVENT_BY_NAME";
	public static final String GET_EVENT_BY_ID = "GET_EVENT_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="name")
	private String name;

	@Column(name="body")
	private String body;

	@Column(name="teaser")
	private String teaser;

	@Column(name="type")
	private String type;

	@Column(name="start")
	private Timestamp start;

	@Column(name="end")
	private Timestamp end;

	@Column(name="group_id")
	private Integer groupId;

	@Column(name="status")
	private String status;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	public Event(){

	}

	public Event(Integer id, Integer userId, String name, String body, String teaser, String type, Timestamp start,
				 Timestamp end, Integer groupId, String status, Timestamp updatedAt, Timestamp createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.body = body;
		this.teaser = teaser;
		this.type = type;
		this.start = start;
		this.end = end;
		this.groupId = groupId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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
		return "Event [id=" + id + ", userId=" + userId + ", name=" + name + ", body=" + body + ", teaser=" + teaser
				+ ", type=" + type + ", start=" + start + ", end=" + end + ", groupId=" + groupId + ", status=" + status
				+ ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
	}





}
