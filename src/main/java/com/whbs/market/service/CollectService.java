/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
package com.whbs.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whbs.market.dao.CollectDao;
import com.whbs.market.model.Collect;
import com.whbs.market.model.Product;

/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Service
public class CollectService {

	@Autowired
	private CollectDao collectDao;
	/**
	 * 发现用户的所有收藏
	 * @param userId
	 * @return
	 */
	public List<Product>   findCollerctByUserId(Integer userId){
		return collectDao.selectCollerctByUserId(userId);
	}
	/**
	 * 保存用户的收藏
	 * @param userId
	 * @param productId
	 */
	public void saveUserCollect(Integer userId ,Integer productId){
		collectDao.saveUserCollect(userId, productId);
	}
	
	/**
	 * 更新用户的收藏
	 * @param id
	 */
	public void updateCollectById(Integer id){
		collectDao.updateCollectById(id);
	}
	
	
}
