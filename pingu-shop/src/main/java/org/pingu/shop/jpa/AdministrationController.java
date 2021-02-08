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
public class AdministrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;
	
	@GetMapping(value={"/admin"})
	public String adminControl(Model model) 
	{
        List<User> userList = (List<User>) userRepository.findAll();
		List<Product> productList = (List<Product>) productRepository.findAll(); //Get all products
        List<Orders> ordersList = (List<Orders>) ordersRepository.findAll(); //Get all orders

        model.addAttribute("userList", userList);
		model.addAttribute("productList", productList);
        model.addAttribute("ordersList", ordersList);
        System.out.print(ordersList);
        return "admin";
	}
}