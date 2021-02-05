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
public class ShowProductController {

    @Autowired
    private ProductRepository repository;
	
	@GetMapping("/product")
	public String showProduct(
        @RequestParam(name="id", required=false, defaultValue="") long id,
        Model model) 
	{
		Product product = repository.findById(id);
		model.addAttribute("product", product);
		return "product";
	}
}