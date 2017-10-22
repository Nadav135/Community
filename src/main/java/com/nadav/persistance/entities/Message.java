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
@Table(name="message")
@NamedQueries({
		@NamedQuery(name=Message.GET_ALL_MESSAGE,
				query="SELECT a FROM Message a"),
		@NamedQuery(name=Message.GET_ALL_MESSAG_BY_BODY,
				query="SELECT a FROM Message a WHERE body like :body"),
		@NamedQuery(name=Message.GET_MESSAG_BY_ID,
				query="SELECT a FROM Message a WHERE id=:id")
})
@XmlRootElement
public class Message {

	public static final String GET_ALL_MESSAGE = "GET_ALL_MESSAGE";
	public static final String GET_ALL_MESSAG_BY_BODY = "GET_ALL_MESSAG_BY_BODY";
	public static final String GET_MESSAG_BY_ID = "GET_MESSAG_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="from_Id")
	private Integer fromId;

	@Column(name="to_Id")
	private Integer toId;

	@Column(name="body")
	private String body;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	public Message(){

	}

	public Message(Integer id, Integer fromId, Integer toId, String body, Timestamp updatedAt, Timestamp createdAt) {
		super();
		this.id = id;
		this.fromId = fromId;
		this.toId = toId;
		this.body = body;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
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

	@Override
	public String toString() {
		return "Message [id=" + id + ", fromId=" + fromId + ", toId=" + toId + ", body=" + body + ", updatedAt="
				+ updatedAt + ", createdAt=" + createdAt + "]";
	}


}
