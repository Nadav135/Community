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
@Table(name="topic")
@NamedQueries({
		@NamedQuery(name=Topic.GET_ALL_TOPIC,
				query="SELECT a FROM Topic a"),
		@NamedQuery(name=Topic.GET_ALL_TOPIC_BY_NAME,
				query="SELECT a FROM Topic a WHERE name like :name"),
		@NamedQuery(name=Topic.GET_TOPIC_BY_ID,
				query="SELECT a FROM Topic a WHERE id=:id")
})
@XmlRootElement
public class Topic {

	public static final String GET_ALL_TOPIC = "GET_ALL_TOPIC";
	public static final String GET_ALL_TOPIC_BY_NAME = "GET_ALL_TOPIC_BY_NAME";
	public static final String GET_TOPIC_BY_ID = "GET_TOPIC_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="parent_id")
	private Integer parentId;

	@Column(name="name")
	private String name;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	public Topic(){

	}

	public Topic(Integer id, Integer parentId, String name, Timestamp updatedAt, Timestamp createdAt) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Topic [id=" + id + ", parentId=" + parentId + ", name=" + name + ", updatedAt=" + updatedAt
				+ ", createdAt=" + createdAt + "]";
	}


}
