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
@Table(name="article")
@NamedQueries({
		@NamedQuery(name=Article.GET_ALL_ARTICLES,
				query="SELECT a FROM Article a"),
		@NamedQuery(name=Article.GET_ALL_ARTICLES_BY_TITLE,
				query="SELECT a FROM Article a WHERE title like :title"),
		@NamedQuery(name=Article.GET_ARTICLE_BY_ID,
				query="SELECT a FROM Article a WHERE id=:id")
})
@XmlRootElement
public class Article {

	public static final String GET_ALL_ARTICLES = "GET_ALL_ARTICLES";
	public static final String GET_ALL_ARTICLES_BY_TITLE = "GET_ALL_ARTICLES_BY_TITLE";
	public static final String GET_ARTICLE_BY_ID = "GET_ARTICLE_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="title")
	private String title;

	@Column(name="body")
	private String body;

	@Column(name="teaser")
	private String teaser;

	@Column(name="subject")
	private String subject;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="topic_id")
	private Integer topicsId;

	@Column(name="rating")
	private Integer ratingId;

	public Article(){

	}


	public Article(String title, String body, String teaser, String subject, Integer userId, Timestamp updatedAt,
				   Timestamp createdAt, Integer topicsId, Integer ratingId) {
		super();
		this.title = title;
		this.body = body;
		this.teaser = teaser;
		this.subject = subject;
		this.userId = userId;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.topicsId = topicsId;
		this.ratingId = ratingId;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getTopicsId() {
		return topicsId;
	}

	public void setTopicsId(Integer topicsId) {
		this.topicsId = topicsId;
	}

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", body=" + body + ", teaser=" + teaser + ", subject="
				+ subject + ", userId=" + userId + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt
				+ ", topicsId=" + topicsId + ", ratingId=" + ratingId + "]";
	}




}
