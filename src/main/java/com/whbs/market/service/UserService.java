/**
 * 
 */
package com.whbs.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whbs.market.dao.UserDao;
import com.whbs.market.model.User;
import com.whbs.market.util.PasswordMD5;

/**   
 * @Description: 
 *     UserService
 * @author wanghao   
 * @version  1.0   
 */
@Service
public class UserService {

	@Autowired 
	private UserDao userDao;
	
	private PasswordMD5  passwordMD5=new PasswordMD5();
	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User login(String username,String password) throws Exception{
		password=passwordMD5.EncoderByMd5(password);
		return userDao.selectByLoginnameAndPassword(username, password);
	}
	/**
	 * 判断是否重名
	 * @param username
	 * @return
	 */
	public User HaveUsername(String username){
		return userDao.selectByUsername(username);
	}
	
	/**
	 * 手机号是否重复
	 * @param phone
	 * @return
	 */
	public User HavePhone(String phone){
		return userDao.selectByPhone(phone);
	}
	/**
	 * 邮箱是否重复
	 * @param email
	 * @return
	 */
	public User HaveEmail(String email){
		return userDao.selectByEmail(email);
	}
	
	/**
	 * 注册，并且密码加密存储
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception{
		String password=passwordMD5.EncoderByMd5(user.getPassword());
		 userDao.save(user.getUsername(),password,user.getPhone(),
				 user.getQq(),user.getQuestion(),user.getAnswer(),user.getRole());
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User  selectByUserId(Integer id){
	     return userDao.selectByUserId(id);
	}
	
	/**
	 * 更新用户信息
	 * @param password
	 * @param phone
	 * @param email
	 * @param id
	 * @throws Exception
	 */
	public void updateUserById(String password,String phone,String email,Integer id) throws Exception{
		password=passwordMD5.EncoderByMd5(password);
		userDao.updateUserById(password, phone, email, id);
	}
	
	/**
	 * 更新用户密码
	 * @param password
	 * @param id
	 * @throws Exception
	 */
	public void updateUserPasswordById(String password,Integer id) throws Exception{
		password=passwordMD5.EncoderByMd5(password);
		userDao.updateUserPasswordById(password, id);
	}
	
}
