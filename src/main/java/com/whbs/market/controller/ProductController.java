/**
 * 
 */
package com.whbs.market.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.whbs.market.model.Place;
import com.whbs.market.model.Product;
import com.whbs.market.model.User;
import com.whbs.market.service.PlaceService;
import com.whbs.market.service.ProductService;
import com.whbs.market.service.UserService;

/**   
 * @Description: 产品信息相关控制
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Controller
public class ProductController {

	
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	
	@Autowired 
	private PlaceService placeService;
	/**
	 * 获取产品id，并展示
	 * @param id
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/show/{id}")
	public ModelAndView showItem(@PathVariable Integer id,ModelAndView mv,HttpSession session){
	    Product product=productService.findProductById(id);
	    User sellUser=userService.selectByUserId(product.getUserId());
	    Place sellPlace=placeService.findPlaceByUserId(product.getUserId());
	    mv.addObject("product", product);
	    mv.addObject("sellUser", sellUser);
	    mv.addObject("sellPlace", sellPlace);
	    mv.setViewName("detail");
		return mv;
	}
	/**
	 * 获得用户上架产品
	 * @param id
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/showSellPQ/{id}")
	public ModelAndView showPhoneQQ(@PathVariable Integer id,ModelAndView mv,HttpSession session){
	    Product product=productService.findProductById(id);
	    User sellUser=userService.selectByUserId(product.getUserId());
	    Place sellPlace=placeService.findPlaceByUserId(product.getUserId());
	    mv.addObject("product", product);
	    mv.addObject("sellUser", sellUser);
	    mv.addObject("sellPlace", sellPlace);
	    mv.setViewName("showSell");
		return mv;
	}
	/**
	 * 删除产品，此功能只有admin 才能用
	 * @param id
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable Integer id,ModelAndView mv,HttpSession session){
	    productService.deletePorductById(id);
	    return "redirect:/index";
	}
	
	/**
	 * 获取我发布过的所有商品
	 * @param userId
	 * @param mv
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/myFa/{userId}")
	public ModelAndView myFa(@PathVariable Integer userId,ModelAndView mv,User user){
	   if (user==null) {
		   mv.setViewName("redirect:/login");
	}else {
		List<Product> pList=productService.findProductByUserId(userId);
	    mv.addObject("pList", pList);
	    mv.setViewName("myFa");
	}
		return mv;
	}
	/**
	 * 编辑产品信息，更改状态
	 * @param id
	 * @param mv
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value="/editDetail/{id}")
	public ModelAndView editDetail(@PathVariable Integer id,ModelAndView mv,HttpSession session){
	    productService.updatePorductById(id);
	    Product product=productService.findProductById(id);
	    User sellUser=userService.selectByUserId(product.getUserId());
	    Place sellPlace=placeService.findPlaceByUserId(product.getUserId());
	    mv.addObject("product", product);
	    mv.addObject("sellUser", sellUser);
	    mv.addObject("sellPlace", sellPlace);
	    mv.setViewName("detail");
		return mv;
	}
	/**
	 * 发布展品注册，并上传图片
	 * @param session
	 * @param response
	 * @param userId
	 * @param categoryId
	 * @param name
	 * @param subtitle
	 * @param detail
	 * @param price
	 * @param oldPrice
	 * @param placeAddress
	 * @param mv
	 * @param request
	 * @param image
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sellProduct")
	public ModelAndView sellProduct(HttpSession session,HttpServletResponse response,
		@RequestParam("userId") Integer userId,@RequestParam("categoryId") Integer categoryId,
		@RequestParam("name") String name,@RequestParam("subtitle") String subtitle,
		@RequestParam("detail") String detail,@RequestParam("price") BigDecimal price,
		@RequestParam("oldPrice") BigDecimal oldPrice,@RequestParam("placeAddress") String placeAddress,
		
		ModelAndView mv,HttpServletRequest request,@RequestParam("image") MultipartFile image) throws Exception{
		//判断登陆，无登录，跳转登陆
	   if (userId==null) {
		   mv.setViewName("login");
			return mv;
	}else {
		if (!image.isEmpty()) {
			//设置编码格式
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String pathString;  
			//设置图片存储路径
		    if (System.getProperty("os.name").equals("Linux")) {  
		    	pathString = "/data/www/images/";  
		    } else {  
		    	pathString = "D:\\testImage";  
		    }  
//			String pathString=request.getServletContext().getRealPath("/data/www/images/");
		    //把用户上传图片加uuid防止重复
			String imageName=UUID.randomUUID()+"-"+image.getOriginalFilename();
			File filepathFile=new File(pathString, imageName);
			if (!filepathFile.getParentFile().exists()) {
				filepathFile.getParentFile().mkdirs();
			}
			image.transferTo(new File(pathString+File.separator+imageName));
			Product product=new Product();
			product.setUserId(userId);
			product.setCategoryId(categoryId);
			product.setName(name);
			product.setMainImage("/images/"+imageName);
			product.setSubtitle(subtitle);
			product.setDetail(detail);
			product.setPrice(price);
			product.setOldPrice(oldPrice);
			productService.insertProduct(product);
//			placeService.updatePlaceByUserId(placeAddress, userId);
			Place place=placeService.findPlaceByUserId(userId);
			if (place==null) {
				placeService.insertPlaceByUserId(placeAddress, userId);
			}
			else {
				placeService.updatePlaceByUserId(placeAddress, userId);
			}
			mv.setViewName("redirect:/index");
			return mv;
		
		}
	    mv.setViewName("redirect:/index");
		return mv;
	}
 }
	
}
