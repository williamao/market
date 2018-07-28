/**
 * 
 */
package com.whbs.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whbs.market.dao.CategoryDao;
import com.whbs.market.model.Category;

/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Service
public class CategoryService {

	
	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * 查找种类通过名字
	 * @param name
	 * @return
	 */
	public Category findCategoryByName(String name){
		return categoryDao.selectIdByName(name);
	}
	/**
	 * 查找种类通过别名
	 * @param alias
	 * @return
	 */
	public Category findCategoryByAlias(String alias){
		return categoryDao.selectIdByAlias(alias);
	}
	
	/**
	 * 查找种类通过id
	 * @param id
	 * @return
	 */
	public Category findCategoryById(Integer	 id){
		return categoryDao.selectNameById(id);
	}
	
}
