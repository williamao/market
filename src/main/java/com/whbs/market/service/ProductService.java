package com.whbs.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whbs.market.dao.ProductDao;
import com.whbs.market.model.Product;

/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	/**
	 * 查找所有商品通过名字
	 * @param name
	 * @return
	 */
	public List<Product> findProductByName(String name){
		return productDao.selectProductByName(name);
	}
	/**
	 * 通过id展示一个商品
	 * @param id
	 * @return
	 */
	public Product findProductById(Integer id){
		return productDao.selectProductById(id);
	}
	/**
	 * 查找分类下的所有的商品
	 * @param categoryId
	 * @return
	 */
	public List<Product> findProductByCategoryId(Integer categoryId){
		return productDao.selectProductByCategoryId(categoryId);
	}
	
	/**
	 * 查找用户出售的所有产品
	 * @param userId
	 * @return
	 */
	public List<Product>  findProductByUserId(Integer userId){
		return productDao.selectProductByUserId(userId);
	}
	
	/**
	 * 查找产品搜索
	 * @param categoryId
	 * @return
	 */
	public List<Product> findProductBySearchCategoryId(Integer categoryId){
		return productDao.selectProductBySearchCategoryId(categoryId);
	}
	
	/**
	 * 插入产品
	 * @param product
	 */
	public void insertProduct(Product product){
		productDao.insertProduct(product.getUserId(), product.getCategoryId(), product.getName(), 
				product.getSubtitle()	, product.getMainImage(), product.getSubImages(), 
				product.getDetail(), product.getPrice(),product.getOldPrice());
	}
	
	/**
	 * 删除产品
	 * @param id
	 */
	public void deletePorductById(Integer id){
		productDao.deletePorductById(id);
	} 
	
	/**
	 * 更新产品
	 * @param id
	 */
	public void updatePorductById(Integer id){
		productDao.updatePorductById(id);
	} 
}
