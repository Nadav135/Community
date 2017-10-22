package com.nadav.persistance.entities;

import java.sql.Timestamp;

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
@Table(name="groups")
@NamedQueries({
		@NamedQuery(name=Group.GET_ALL_GROUP,
				query="SELECT a FROM Group a"),
		@NamedQuery(name=Group.GET_ALL_GROUP_BY_NAME,
				query="SELECT a FROM Group a WHERE name like :name"),
		@NamedQuery(name=Group.GET_GROUP_BY_ID,
				query="SELECT a FROM Group a WHERE id=:id")
})
@XmlRootElement
public class Group {

	public static final String GET_ALL_GROUP = "GET_ALL_GROUP";
	public static final String GET_ALL_GROUP_BY_NAME = "GET_ALL_GROUP_BY_NAME";
	public static final String GET_GROUP_BY_ID = "GET_GROUP_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Group(){

	}

	public Group(Integer id, String name, String description, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", description=" + description + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}



}
