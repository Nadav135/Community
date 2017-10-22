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
@Table(name="activity")
@NamedQueries({
		@NamedQuery(name=Activity.GET_ALL_ACTIVITIES,
				query="SELECT a FROM Activity a"),
		@NamedQuery(name=Activity.GET_ALL_ACTIVITIES_BY_NAME,
				query="SELECT a FROM Activity a WHERE name like :name"),
		@NamedQuery(name=Activity.GET_ACTIVITY_BY_ID,
				query="SELECT a FROM Activity a WHERE id=:id")
})
@XmlRootElement
public class Activity {

	public static final String GET_ALL_ACTIVITIES = "GET_ALL_ACTIVITIES";
	public static final String GET_ALL_ACTIVITIES_BY_NAME = "GET_ALL_ACTIVITIES_BY_NAME";
	public static final String GET_ACTIVITY_BY_ID = "GET_ACTIVITY_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")
	private String name;


	public Activity(){

	}


	public Activity(String name) {
		super();
		this.name = name;
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


	@Override
	public String toString() {
		return "Activity [Id=" + id + ", Name=" + name + "]";
	}


}
