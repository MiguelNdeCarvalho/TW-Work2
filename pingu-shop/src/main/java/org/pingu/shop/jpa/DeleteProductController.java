package org.pingu.shop.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DeleteProductController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    // @Autowired
    // private OrderRepository orderRepository;
	
	@PostMapping("/remove-product")
	public String listProduct(
        @RequestParam(name="id", required=true, defaultValue="") long id,
        Model model) 
	{
		productRepository.deleteById(id);

        List<User> userList = (List<User>) userRepository.findAll();
		List<Product> productList = (List<Product>) productRepository.findAll(); //Get all products
        // List<Orders> ordersList = (List<Orders>) repository.findAll(); //Get all orders

        model.addAttribute("userList", userList);
		model.addAttribute("productList", productList);
        // model.addAttribute("orderList", orderList);
        return "admin";
	}
}