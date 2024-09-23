package com.ProductCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.ProductCRUD.Dao.ProductDao;
import com.ProductCRUD.Model.Product;
import java.util.*;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {
		
		List<Product> products=productDao.getProducts();
		m.addAttribute("product",products);
		
		return "index";
	}
	
	@RequestMapping("/add_product")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	//show add product form
	@RequestMapping(value="/handle-product",method=RequestMethod.POST)
	public RedirectView HandleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//delete handler
	@RequestMapping("/delete/{pid}")
	public RedirectView deleteProduct(@PathVariable("pid") int pid,HttpServletRequest request) {
		
		this.productDao.deleteProduct(pid);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
	}
	
	@RequestMapping("/update/{pid}")
	public String updateForm(@PathVariable("pid") int pid,Model m) {
		
		Product product=this.productDao.getProduct(pid);
		m.addAttribute("product",product);
		return "update_form";
	}
}
