/**
 * 
 */
package com.whbs.market.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 交易地址
 * @author wanghao
 * @version 1.0
 */
public class Place implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private String placeAddress;
	private Date createTime;
	private Date updateTime;

	public Place() {
		super();
	}
	
	

	public Place(Integer id, Integer userId, String placeAddress, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.placeAddress = placeAddress;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPlaceAddress() {
		return placeAddress;
	}

	public void setPlaceAddress(String placeAddress) {
		this.placeAddress = placeAddress;
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

}
