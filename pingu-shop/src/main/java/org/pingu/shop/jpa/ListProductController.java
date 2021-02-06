package org.pingu.shop.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListProductController {

    @Autowired
    private ProductRepository repository;
	
	@GetMapping(value={"", "/", "/index"})
	public String listProduct(Model model) 
	{
		List<Product> productList = (List<Product>) repository.findAll();

		model.addAttribute("productList", productList);
		return "index";
	}
}