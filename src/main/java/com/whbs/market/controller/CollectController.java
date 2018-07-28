/**   
 * @Description: 
 *     
 * @author wanghao   
 * @version  1.0   
 */
package com.whbs.market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whbs.market.model.Collect;
import com.whbs.market.model.Place;
import com.whbs.market.model.Product;
import com.whbs.market.model.User;
import com.whbs.market.service.CollectService;
import com.whbs.market.service.ProductService;

/**   
 * @Description: 收藏相关功能控制
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Controller
public class CollectController {

	@Autowired
	private CollectService collectService;
	
	@Autowired
	private ProductService productService;
	
	/**   
	 * 用户添加收藏
	 * @param productId
	 * @param mv
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/itemCollect/{productId}")
	public ModelAndView showItem(@PathVariable Integer productId,ModelAndView mv,HttpSession session,User user){
	    if (user==null) {
	    	  mv.setViewName("redirect:/login");
		}else {
			//获取用户名
			user=(User) session.getAttribute("user"); 
			//保存用户id及产品id
			collectService.saveUserCollect(user.getId(), productId);
			//获取用户的所以收藏，用于展示
			List<Product> cList=collectService.findCollerctByUserId(user.getId());
			mv.addObject("cList", cList);
		    mv.setViewName("myCol");
		}
		
		return mv;
	}
	/**  
	 * 收藏信息
	 * @param userId
	 * @param mv
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/myCol/{userId}")
	public ModelAndView myFa(@PathVariable Integer userId,ModelAndView mv,User user){
	   if (user==null) {
		   mv.setViewName("redirect:/login");
	}else {
		List<Product> cList=collectService.findCollerctByUserId(userId);
	    mv.addObject("cList", cList);
	    mv.setViewName("myCol");
	}
		return mv;
	}
}
