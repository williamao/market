/**
 * 
 */
package com.whbs.market.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 商品类别
 * @author wanghao
 * @version 1.0
 */
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer parentId;
	private String name;
	private String alias;
	private Integer status;
	private Integer sortOrder;
	private Date createTime;
	private Date updateTime;

	public Category() {
		super();
	}

	public Category(Integer id, Integer parentId, String name,String alias, Integer status, Integer sortOrder, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.alias=alias;
		this.status = status;
		this.sortOrder = sortOrder;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
