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
@Table(name="likeable")
@NamedQueries({
		@NamedQuery(name=Likeable.GET_ALL_LIKEABLE,
				query="SELECT a FROM Likeable a"),
		@NamedQuery(name=Likeable.GET_ALL_LIKEABLE_BY_CONTENTTYPE,
				query="SELECT a FROM Likeable a WHERE content_type like :type"),
		@NamedQuery(name=Likeable.GET_LIKEABLE_BY_ID,
				query="SELECT a FROM Likeable a WHERE id=:id")
})
@XmlRootElement
public class Likeable {

	public static final String GET_ALL_LIKEABLE = "GET_ALL_LIKEABLE";
	public static final String GET_ALL_LIKEABLE_BY_CONTENTTYPE = "GET_ALL_LIKEABLE_BY_CONTENTTYPE";
	public static final String GET_LIKEABLE_BY_ID = "GET_LIKEABLE_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="content_id")
	private Integer contentId;

	@Column(name="content_type")
	private String contentType;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	public Likeable(){

	}

	public Likeable(Integer id, Integer userId, Integer contentId, String contentType, Timestamp updatedAt, Timestamp createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.contentId = contentId;
		this.contentType = contentType;
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

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
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
		return "Likeable [id=" + id + ", userId=" + userId + ", contentId=" + contentId + ", contentType=" + contentType
				+ ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
	}


}
