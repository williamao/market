/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
package com.whbs.market.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.whbs.market.model.Place;

/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Mapper
public interface PlaceDao {
	
	
	//查询用户地点
	@Select("select * from place  where user_id = #{userId}")
     Place selectPlaceByUserId(@Param("userId") Integer userId);
	
	//更新用户地点
	@Update(" update place set  place_address=#{placeAddress} where user_id=#{userId}")
	void updatePlaceByUserId(@Param("placeAddress") String placeAddress,
			@Param("userId") Integer userId);
	
	//插入用户地点
		@Insert("insert into place(user_id,place_address ) values(#{userId},#{placeAddress})")
		void  saveUserPlace(@Param("userId") Integer userId,@Param("placeAddress")  String placeAddress);
		
	
}
