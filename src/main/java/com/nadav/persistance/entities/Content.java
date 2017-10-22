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
@Table(name="content")
@NamedQueries({
		@NamedQuery(name=Content.GET_ALL_CONTENT,
				query="SELECT a FROM Content a"),
		@NamedQuery(name=Content.GET_ALL_CONTENT_BY_TITLE,
				query="SELECT a FROM Content a WHERE title like :title"),
		@NamedQuery(name=Content.GET_CONTENT_BY_ID,
				query="SELECT a FROM Content a WHERE id=:id")
})
@XmlRootElement
public class Content {

	public static final String GET_ALL_CONTENT = "GET_ALL_CONTENT";
	public static final String GET_ALL_CONTENT_BY_TITLE = "GET_ALL_CONTENT_BY_TITLE";
	public static final String GET_CONTENT_BY_ID = "GET_CONTENT_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="parent_id")
	private Integer parentId;

	@Column(name="body")
	private String body;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="path")
	private String path;

	@Column(name="rating")
	private Integer rating;

	@Column(name="title")
	private String title;

	@Column(name="content_type")
	private String contentType;

	@Column(name="group_id")
	private Integer groupId;

	public Content(){

	}

	public Content(Integer id, Integer userId, Integer parentId, String body, Timestamp updatedAt, Timestamp createdAt, String path,
				   Integer rating, String title, String contentType, Integer groupId) {
		super();
		this.id = id;
		this.userId = userId;
		this.parentId = parentId;
		this.body = body;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.path = path;
		this.rating = rating;
		this.title = title;
		this.contentType = contentType;
		this.groupId = groupId;
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", userId=" + userId + ", parentId=" + parentId + ", body=" + body + ", updatedAt="
				+ updatedAt + ", createdAt=" + createdAt + ", path=" + path + ", rating=" + rating + ", title=" + title
				+ ", contentType=" + contentType + ", groupId=" + groupId + "]";
	}



}
