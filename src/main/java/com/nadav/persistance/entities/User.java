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

import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name="user")
@NamedQueries({
		@NamedQuery(name=User.GET_ALL_USER,
				query="SELECT a FROM User a"),
		@NamedQuery(name=User.GET_ALL_USER_BY_NAME,
				query="SELECT a FROM User a WHERE last_name like :name OR first_name like :name"),
		@NamedQuery(name=User.GET_ALL_USER_BY_FIRSTNAME_AND_LASTNAME,
				query="SELECT a FROM User a WHERE last_name =:lastname AND first_name =:firsname"),
		@NamedQuery(name=User.GET_USER_BY_USERNAME,
				query="SELECT a FROM User a WHERE username =:username"),
		@NamedQuery(name=User.GET_USER_LIKE_USERNAME,
				query="SELECT a FROM User a WHERE username like :username"),
		@NamedQuery(name=User.GET_USER_BY_ID,
				query="SELECT a FROM User a WHERE id=:id")
})
@XmlRootElement
public class User {

	public static final String GET_ALL_USER = "GET_ALL_USER";
	public static final String GET_ALL_USER_BY_NAME = "GET_ALL_USER_BY_NAME";
	public static final String GET_ALL_USER_BY_FIRSTNAME_AND_LASTNAME = "GET_ALL_USER_BY_FIRSTNAME_AND_LASTNAME";
	public static final String GET_USER_BY_USERNAME = "GET_USER_BY_USERNAME";
	public static final String GET_USER_LIKE_USERNAME = "GET_USER_LIKE_USERNAME";
	public static final String GET_USER_BY_ID = "GET_USER_BY_ID";

	//Class variables
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="username")
	private String username;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="gender")
	private String gender;

	@Column(name="birthday")
	private Date birthday; 	//Date

	@Column(name="account_status")
	private String accountStatus;

	@Column(name="bio")
	private String bio;

	@Column(name="location_id")
	private Integer locationId;

	@Column(name="last_login")
	private Timestamp lastLogin;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="is_online")
	private Boolean isOnline;

	@Column(name="rating_id")
	private Integer ratingId;

	@Column(name="image")
	private String image;

	//Constructor
	public User(){

	}

	public User(Integer id, String username, String firstName, String lastName, String email, String password,
				String gender, Date birthday, String accountStatus, String bio, Integer locationId, Timestamp lastLogin,
				Timestamp updatedAt, Timestamp createdAt, Boolean isOnline, Integer ratingId, String image) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.accountStatus = accountStatus;
		this.bio = bio;
		this.locationId = locationId;
		this.lastLogin = lastLogin;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
		this.isOnline = isOnline;
		this.ratingId = ratingId;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
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

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", gender=" + gender + ", birthday=" + birthday
				+ ", accountStatus=" + accountStatus + ", bio=" + bio + ", locationId=" + locationId + ", lastLogin="
				+ lastLogin + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + ", isOnline=" + isOnline
				+ ", ratingId=" + ratingId + ", image=" + image + "]";
	}


}
