package com.whbs.market;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whbs.market.model.Product;
import com.whbs.market.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarketApplicationTests {

	@Autowired
	private ProductService productService;
	
	@Test
	public void contextLoads() {
		 List<Product> findshoujiList= productService.findProductByCategoryId(10000);
		 System.out.println(findshoujiList);
	}

}
