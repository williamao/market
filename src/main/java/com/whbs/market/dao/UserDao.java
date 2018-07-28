/**
 * 
 */
package com.whbs.market.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.whbs.market.model.User;



/**   
 * @Description: 
 *     UserDao
 * @author wanghao   
 * @version  1.0   
 */
@Mapper
public interface UserDao {

	
	//登陆
	@Select("select * from user where username = #{username} and password = #{password}")
	User selectByLoginnameAndPassword(
			@Param("username") String username,
			@Param("password") String password);
	
	//查询是否有账号
	@Select("select * from user where username = #{username}")
	User selectByUsername(@Param("username") String username);
	
	//查询id
	@Select("select * from user where id = #{id}")
	User selectByUserId(@Param("id") Integer id);
	
	//查询是否有手机
	@Select("select * from user where phone = #{phone}")
	User selectByPhone(@Param("phone") String phone);
	
	//查询是否有邮箱
	@Select("select * from user where email = #{qq}")
	User selectByEmail(@Param("qq") String qq);

	
	
	//插入数据--注册
	@Insert("insert into user(username,password,phone ,qq,question,"
			+ "answer,role) "
			+ " values(#{username},#{password},#{phone}, #{qq}, #{question},#{answer},#{role})")
	void  save(@Param("username") String username,
			@Param("password") String password,@Param("phone") String phone,
			@Param("qq") String email,@Param("question") String question,
			@Param("answer") String answer,@Param("role") Integer role);
	
	//修改个人主页
	@Update(" update user set  password=#{password} ,phone=#{phone},qq=#{qq} where id=#{id}")
	void  updateUserById(	@Param("password") String password,
			@Param("phone") String phone,
			@Param("qq") String qq,@Param("id") Integer id);
	
	//修改密码
	@Update(" update user set  password=#{password}  where id=#{id}")
	void  updateUserPasswordById(@Param("password") String password,@Param("id") Integer id);


   


}
