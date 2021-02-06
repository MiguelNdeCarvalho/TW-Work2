package org.pingu.shop.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchProductController {

    @Autowired
    private ProductRepository repository;
    
    @PostMapping("/search")
	public String searchProduct(
			@RequestParam(name="search", required=true, defaultValue="") String search,
			Model model) 
	{
        List<Product> productList = (List<Product>) repository.findByNameContainingIgnoreCase(search);

        model.addAttribute("productList", productList);
	model.addAttribute("fromSearch", "true");
	return "index";
	}
}
