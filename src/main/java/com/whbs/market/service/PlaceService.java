/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
package com.whbs.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whbs.market.dao.PlaceDao;
import com.whbs.market.model.Place;

/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Service
public class PlaceService {

	@Autowired
	private  PlaceDao placeDao;
	
	/**
	 * 通过用户id查找他的地址
	 * @param userId
	 * @return
	 */
	public Place findPlaceByUserId(Integer userId){
		return placeDao.selectPlaceByUserId(userId);
	}
	
	/**
	 * 更新用户地址
	 * @param placeAddress
	 * @param userId
	 */
	public void updatePlaceByUserId(String placeAddress,Integer userId){
		placeDao.updatePlaceByUserId(placeAddress, userId);
	}
	
	
	/**
	 * 插入用户地址
	 * @param 
	 * @return
	 */
	public void insertPlaceByUserId(String placeAddress,Integer userId){
		 placeDao.saveUserPlace(userId, placeAddress);
	}
	
}
