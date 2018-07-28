/**
 * 
 */
package com.whbs.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.whbs.market.model.Category;
import com.whbs.market.model.Product;
import com.whbs.market.service.CategoryService;
import com.whbs.market.service.ProductService;

/**   
 * @Description: 分类信息相关控制
 *     
 * @author wanghao   
 * @version  1.0   
 */
@Controller
public class CategoryController {

	@Autowired
	private  CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	/**  
	 * @Description: 查找物品通过种类
	 * @param name
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/p/{name}")
	public ModelAndView item(@PathVariable String name,ModelAndView mv){
	    Category category=	categoryService.findCategoryByName(name);
	    List<Product>  products=productService.findProductByCategoryId(category.getId());
	    mv.addObject("products", products);
	    mv.setViewName("show_item");
		return mv;
	}
	
	/**  
	 * 查找物品
	 * @param name
	 * @param mv
	 * @return
	 */
	@RequestMapping("/search")
    @ResponseBody
	public ModelAndView item2(@RequestParam("name") String name,ModelAndView mv){
		name="%"+name+"%";
       Category category=	categoryService.findCategoryByName(name);
	    if (category==null) {
	    	 mv.addObject("message", "没有查找到相关物品");
		}else {
			List<Product>  products=productService.findProductBySearchCategoryId(category.getId());
		    mv.addObject("products", products);
		}
	    mv.setViewName("show_item");
		return mv;
	}
	
}
