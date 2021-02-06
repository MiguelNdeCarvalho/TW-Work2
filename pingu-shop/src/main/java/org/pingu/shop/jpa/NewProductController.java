package org.pingu.shop.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NewProductController {

    @Autowired
    private ProductRepository productRepository;
    
    @PostMapping("/new-product")
	public String newProduct(
			@RequestParam(name="name", required=true, defaultValue="") String name,
			@RequestParam(name="imgPath", required=true, defaultValue="") String imgPath,
			@RequestParam(name="desc", required=true, defaultValue="") String desc,
			@RequestParam(name="price", required=true, defaultValue="") Float price,
			Model model) 
	{
		productRepository.save(new Product(name,"/img/products/" + imgPath,desc,price));
		return "index";
	}
}