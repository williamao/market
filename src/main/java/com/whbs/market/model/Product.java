/**
 * 
 */
package com.whbs.market.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 商品
 * @author wanghao
 * @version 1.0
 */
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer categoryId;
	private Integer userId;
	private String name;
	private String subtitle;
	private String mainImage;
	private String subImages;
	private String detail;
	private BigDecimal price;
	private BigDecimal oldPrice;
	private Integer status;
	private Date createTime;

	private Date updateTime;

	public Product() {
		super();
	}

	

	public Product(Integer id, Integer categoryId, Integer userId, String name, String subtitle, String mainImage,
			String subImages, String detail, BigDecimal price, BigDecimal oldPrice, Integer status, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.userId = userId;
		this.name = name;
		this.subtitle = subtitle;
		this.mainImage = mainImage;
		this.subImages = subImages;
		this.detail = detail;
		this.price = price;
		this.oldPrice = oldPrice;
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getSubImages() {
		return subImages;
	}

	public void setSubImages(String subImages) {
		this.subImages = subImages;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public BigDecimal getOldPrice() {
		return oldPrice;
	}



	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}

}
