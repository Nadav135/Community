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
@Table(name="location")
@NamedQueries({
		@NamedQuery(name=Location.GET_ALL_LOCATION,
				query="SELECT a FROM Location a"),
		@NamedQuery(name=Location.GET_ALL_LOCATION_BY_NAME,
				query="SELECT a FROM Location a WHERE name like :name"),
		@NamedQuery(name=Location.GET_LOCATION_BY_ID,
				query="SELECT a FROM Location a WHERE id=:id")
})
@XmlRootElement
public class Location {

	public static final String GET_ALL_LOCATION = "GET_ALL_LOCATION";
	public static final String GET_ALL_LOCATION_BY_NAME = "GET_ALL_LOCATION_BY_NAME";
	public static final String GET_LOCATION_BY_ID = "GET_LOCATION_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="code")
	private String code;

	@Column(name="name")
	private String name;

	@Column(name="parent_id")
	private Integer parentId;

	public Location(){

	}

	public Location(Integer id, String code, String name, Integer parentId) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public static String getGetAllLocation() {
		return GET_ALL_LOCATION;
	}

	public static String getGetAllLocationByName() {
		return GET_ALL_LOCATION_BY_NAME;
	}

	public static String getGetLocationById() {
		return GET_LOCATION_BY_ID;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", code=" + code + ", name=" + name + ", parentId=" + parentId + "]";
	}




}
