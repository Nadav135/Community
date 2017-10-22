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
@Table(name="status")
@NamedQueries({
		@NamedQuery(name=Status.GET_ALL_STAUTS,
				query="SELECT a FROM Status a"),
		@NamedQuery(name=Status.GET_ALL_STAUTS_BY_NAME,
				query="SELECT a FROM Status a WHERE name like :name"),
		@NamedQuery(name=Status.GET_STAUTS_BY_ID,
				query="SELECT a FROM Status a WHERE id=:id")
})
@XmlRootElement
public class Status {

	public static final String GET_ALL_STAUTS = "GET_ALL_STAUTS";
	public static final String GET_ALL_STAUTS_BY_NAME = "GET_ALL_STAUTS_BY_NAME";
	public static final String GET_STAUTS_BY_ID = "GET_STAUTS_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")
	private String name;

	public Status() {
	}

	public Status(Integer id, String name) {
		super();
		this.id = id;
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
		return "Status [id=" + id + ", name=" + name + "]";
	}

}
