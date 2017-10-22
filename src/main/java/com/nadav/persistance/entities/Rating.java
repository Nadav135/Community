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
@Table(name="rating")
@NamedQueries({
		@NamedQuery(name=Rating.GET_ALL_RATING,
				query="SELECT a FROM Rating a"),
		@NamedQuery(name=Rating.GET_ALL_RATING_BY_VALUE,
				query="SELECT a FROM Rating a WHERE value =:value"),
		@NamedQuery(name=Rating.GET_RATING_BY_ID,
				query="SELECT a FROM Rating a WHERE id=:id")
})
@XmlRootElement
public class Rating {

	public static final String GET_ALL_RATING = "GET_ALL_RATING";
	public static final String GET_ALL_RATING_BY_VALUE = "GET_ALL_RATING_BY_VALUE";
	public static final String GET_RATING_BY_ID = "GET_RATING_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="target_type")
	private String targetType;

	@Column(name="value")
	private Integer value;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;


	public Rating(){

	}

	public Rating(Integer id, Integer userId, String targetType, Integer value, Timestamp updatedAt, Timestamp createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.targetType = targetType;
		this.value = value;
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

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
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
		return "Rating [id=" + id + ", userId=" + userId + ", targetType=" + targetType + ", value=" + value
				+ ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
	}



}
