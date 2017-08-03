package com.example.user.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user_info")
public class UserInfo {
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "LOGIN_NAME")
	private String loginName;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "SALT")
	private String salt;
	
	@Column(name = "BIRTHDAY")
	private Date birthday;
	
	@Column(name = "GENDER")
	private Short gender;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "ICON")
	private String icon;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "LOGIN_COUNT")
	private Short loginCount;
	
	@Column(name = "PREVIOUS_VISIT")
	private Date previousVisit;
	
	@Column(name = "LAST_VISIT")
	private Date lastVisit;
	
	@Column(name = "DEL_FLAG")
	private String delFlag;
	
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	/**
	 * @return ID
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return LOGIN_NAME
	 */
	public String getLoginName() {
		return loginName;
	}
	
	/**
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}
	
	/**
	 * @return NAME
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	
	/**
	 * @return PASSWORD
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
	
	/**
	 * @return SALT
	 */
	public String getSalt() {
		return salt;
	}
	
	/**
	 * @param salt
	 */
	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}
	
	/**
	 * @return BIRTHDAY
	 */
	public Date getBirthday() {
		return birthday;
	}
	
	/**
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * @return GENDER
	 */
	public Short getGender() {
		return gender;
	}
	
	/**
	 * @param gender
	 */
	public void setGender(Short gender) {
		this.gender = gender;
	}
	
	/**
	 * @return EMAIL
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}
	
	/**
	 * @return PHONE
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	
	/**
	 * @return ICON
	 */
	public String getIcon() {
		return icon;
	}
	
	/**
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}
	
	/**
	 * @return CREATE_DATE
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * @return STATE
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
	
	/**
	 * @return LOGIN_COUNT
	 */
	public Short getLoginCount() {
		return loginCount;
	}
	
	/**
	 * @param loginCount
	 */
	public void setLoginCount(Short loginCount) {
		this.loginCount = loginCount;
	}
	
	/**
	 * @return PREVIOUS_VISIT
	 */
	public Date getPreviousVisit() {
		return previousVisit;
	}
	
	/**
	 * @param previousVisit
	 */
	public void setPreviousVisit(Date previousVisit) {
		this.previousVisit = previousVisit;
	}
	
	/**
	 * @return LAST_VISIT
	 */
	public Date getLastVisit() {
		return lastVisit;
	}
	
	/**
	 * @param lastVisit
	 */
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	
	/**
	 * @return DEL_FLAG
	 */
	public String getDelFlag() {
		return delFlag;
	}
	
	/**
	 * @param delFlag
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag == null ? null : delFlag.trim();
	}
	
	/**
	 * @return UPDATE_TIME
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * @return DESCRIPTION
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}