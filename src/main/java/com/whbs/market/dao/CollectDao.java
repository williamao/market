/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
package com.whbs.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.whbs.market.model.Collect;
import com.whbs.market.model.Product;



/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Mapper
public interface CollectDao {

	//查询用户收藏所有物品
	@Select(" SELECT product.*  FROM product, collect  WHERE product.id=collect.product_id  and collect.user_id = #{userId} ")
	List<Product> selectCollerctByUserId(@Param("userId") Integer userId);

	//插入用户收藏
	@Insert("insert into collect(user_id,product_id ) values(#{userId},#{productId})")
	void  saveUserCollect(@Param("userId") Integer userId,@Param("productId") Integer productId);
	
	//更改用户收藏
	@Update(" update collect  set  status=0  where id=#{id}")
	void updateCollectById(@Param("id") Integer id);
}
