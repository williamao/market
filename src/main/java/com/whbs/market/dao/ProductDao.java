
package com.whbs.market.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.whbs.market.model.Product;

/**   
 * @Description: 
 *     具体商品
 * @author wanghao   
 * @version  1.0   
 */
@Mapper
public interface ProductDao {

	//通过名字查找商品
	@Select("select * from product where name=#{name} ")
	List<Product> selectProductByName(@Param("name") String name);
	
	//通过id查找商品
	@Select("select * from product where id=#{id}")
	Product selectProductById(@Param("id") Integer id);
	
	//通过userId查找商品
	@Select("select * from product where user_id=#{userId}")
	List<Product> selectProductByUserId(@Param("userId") Integer userId);

	
	//通过分类ID查找商品
	@Select("select * from product where category_id=#{categoryId}  and status=1  order by update_time desc limit  0,4 ")
	List<Product> selectProductByCategoryId(@Param("categoryId") Integer categoryId);
	
	
    //通过分类ID查找商品
	@Select("select * from product where category_id=#{categoryId}  and status=1")
	List<Product> selectProductBySearchCategoryId(@Param("categoryId") Integer categoryId);
	
	//更改产品状态
	@Update(" update product set  status=0  where id=#{id}")
	void  updatePorductById(@Param("id") Integer id);
	
	//删除产品状态
		@Delete(" delete  from product where id=#{id}")
		void  deletePorductById(@Param("id") Integer id);
	//插入商品
	@Insert("insert into product(user_id,category_id,name ,subtitle,main_image,"
			+ "sub_images,detail,price,old_price) "
			+ " values(#{userId},#{categoryId},#{name}, #{subtitle}, #{mainImage},#{subImages},#{detail},#{price},#{oldPrice})")
	void insertProduct(@Param("userId") Integer userId,
			@Param("categoryId") Integer categoryId,@Param("name") String name,
			@Param("subtitle") String subtitle,@Param("mainImage") String mainImage,
			@Param("subImages") String subImages,@Param("detail") String detail,@Param("price") BigDecimal price,
			@Param("oldPrice") BigDecimal oldPrice);
   

}
