/**
 * 
 */
package com.whbs.market.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.whbs.market.model.Place;
import com.whbs.market.model.Product;
import com.whbs.market.model.User;
import com.whbs.market.service.PlaceService;
import com.whbs.market.service.ProductService;
import com.whbs.market.service.UserService;

/**
 * @Description: UserController
 * @author wanghao
 * @version 1.0
 */

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PlaceService placeService;
	
	@RequestMapping(value={"index", "/"})
	public ModelAndView index(ModelAndView mv,HttpSession session) {
		List<Product> findshoujiList= productService.findProductByCategoryId(10000);
		List<Product> findshumaList= productService.findProductByCategoryId(10002);
		List<Product> findyundongList= productService.findProductByCategoryId(10003);
		List<Product> findyiwuList= productService.findProductByCategoryId(10004);
		List<Product> findtushuList= productService.findProductByCategoryId(10005);
		List<Product> findxiaoyuanList= productService.findProductByCategoryId(10007);
		mv.addObject("findtushuList", findtushuList);
	   mv.addObject("findshoujiList", findshoujiList);
	   mv.addObject("findshumaList", findshumaList);
	   mv.addObject("findyundongList", findyundongList);
	   mv.addObject("findyiwuList", findyiwuList);
	   mv.addObject("findxiaoyuanList", findxiaoyuanList);
	   mv.setViewName("index");
		return mv;
	}

	
	
	@RequestMapping(value = "/home")
	public String home( @ModelAttribute User user, Model model) {
		User userById = userService.selectByUserId(user.getId());
		model.addAttribute("user", userById);
		return "home";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session,  ModelAndView mv ) throws Exception {
		try {
			User user = userService.login(username, password);
		if (user != null) {
			session.setAttribute("user", user);
			Place place=placeService.findPlaceByUserId(user.getId());
			session.setAttribute("place", place);
			mv.setViewName("redirect:/index");
		}
		else {
				mv.addObject("message", "用户名或密码错误请重新输入！");
//				mv.setViewName("forward:/login");
		}
		} catch (Exception e) {
			mv.addObject("message", "用户名或密码错误请重新输入！");
//			mv.setViewName("forward:/login");
		}
		return mv;
	}

	@RequestMapping(value = "/register")
	public String register(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "qq") String qq,
			@RequestParam(value = "question", defaultValue = "") String question,
			@RequestParam(value = "answer", defaultValue = "") String answer, HttpSession session, Model model) throws Exception {
		User user = new User(username, password, phone, qq, question, answer, 1);
		userService.register(user);
		return "redirect:/login";
	}
	
	@RequestMapping(value="/u/home")
	 public ModelAndView upHome( @ModelAttribute User user,HttpSession session,
			 @RequestParam("placeAddress") String placeAddress,
			 ModelAndView mv) throws Exception{
			userService.updateUserById(user.getPassword(), user.getPhone(), user.getQq(), user.getId());
			placeService.updatePlaceByUserId(placeAddress, user.getId());
			session.invalidate();
			mv.setViewName("redirect:/login");
		return mv;
	}

	
	@RequestMapping(value="/phoneAndPassword")
	public String phoneAndPassword(HttpSession session,Model model,@RequestParam(value = "phone") String phone){
	     User user=userService.HavePhone(phone);
	     if (user != null) {
				session.setAttribute("user", user);
				session.setAttribute("answer", user.getAnswer());
				session.setAttribute("id", user.getId());
				return "resetPaFrom";
			}
			else {
					model.addAttribute("message", "没有此号码，请先注册");
					return "forward:/login";
			}
	}
	
	@RequestMapping(value="/findPas")
	public String findPass(@ModelAttribute User user,HttpSession session,Model model,
			@RequestParam(value = "answer") String answer,
           @RequestParam(value = "password") String password) throws Exception{
		if (session.getAttribute("answer").equals(answer)) {
			userService.updateUserPasswordById(password, (Integer)session.getAttribute("id"));
			session.invalidate();
			return "redirect:/login";
		}
		else {
			model.addAttribute("message", "密码与答案不对应,请重新填写");
			return "forward:/resetPaFrom";
	}
  }

}
