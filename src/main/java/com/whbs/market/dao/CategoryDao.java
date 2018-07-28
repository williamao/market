/**
 * 
 */
package com.whbs.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.whbs.market.model.Category;

/**   
 * @Description: 
 *     商品分类
 * @author wanghao   
 * @version  1.0   
 */
@Mapper
public interface CategoryDao {

	//通过名字查找商品分类
	@Select("select * from category where name  like  #{name} ")
	Category selectIdByName(@Param("name") String name);
	
	//通过别名查找商品分类
	@Select("select * from category where alias=#{alias}")
	Category selectIdByAlias(@Param("alias") String alias);
	
	//通过ID查找商品分类
	@Select("select * from category where id=#{id}")
	Category selectNameById(@Param("id") Integer id);
}
