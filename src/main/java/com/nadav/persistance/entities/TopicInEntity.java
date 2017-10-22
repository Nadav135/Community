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
@Table(name="topicinentity")
@NamedQueries({
		@NamedQuery(name=TopicInEntity.GET_ALL_TOPICINENTITY,
				query="SELECT a FROM TopicInEntity a"),
		@NamedQuery(name=TopicInEntity.GET_TOPICINENTITY_BY_ID,
				query="SELECT a FROM TopicInEntity a WHERE id=:id")
})
@XmlRootElement
public class TopicInEntity {

	public static final String GET_ALL_TOPICINENTITY = "GET_ALL_TOPICINENTITY";
	public static final String GET_TOPICINENTITY_BY_ID = "GET_TOPICINENTITY_BY_ID";

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="topic_id")
	private Integer topicId;

	@Column(name="entity_id")
	private Integer entityId;

	@Column(name="entity_type")
	private String entityType;

	public TopicInEntity(){

	}

	public TopicInEntity(Integer id, Integer topicId, Integer entityId, String entityType) {
		super();
		this.id = id;
		this.topicId = topicId;
		this.entityId = entityId;
		this.entityType = entityType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@Override
	public String toString() {
		return "TopicInEntity [id=" + id + ", topicId=" + topicId + ", entityId=" + entityId + ", entityType="
				+ entityType + "]";
	}



}
