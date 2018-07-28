/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
package com.whbs.market.model;

import java.io.Serializable;
import java.util.Date;

/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
public class Collect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private Integer userId;
	private Integer productId;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	
	
	
	public Collect() {
		super();
	}
	
	public Collect(Integer id, Integer userId, Integer productId, Integer status, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.status = status;
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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
