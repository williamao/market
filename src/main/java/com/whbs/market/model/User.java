package com.whbs.market.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户
 * @author wanghao
 * @version 1.0
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private String phone;
	private String qq;
	private String question;
	private String answer;
	private Integer role;
	private Date createTime;
	private Date updateTime;

	public User() {
		super();
	}

	
	

	public User(Integer id, String username, String password, String phone, String qq, String question,
			String answer, Integer role, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.qq = qq;
		this.question = question;
		this.answer = answer;
		this.role = role;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	/**
	 * @param username
	 * @param password
	 * @param phone
	 * @param qq
	 * @param question
	 * @param answer
	 * @param i
	 */
	public User(String username, String password, String phone, String qq, 
			String question, String answer,Integer role) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.qq = qq;
		this.question = question;
		this.answer = answer;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public Integer getRole() {
		return role;
	}


	public void setRole(Integer role) {
		this.role = role;
	}

}
