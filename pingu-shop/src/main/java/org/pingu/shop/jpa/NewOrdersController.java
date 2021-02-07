package org.pingu.shop.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.*;

@Controller
public class NewOrdersController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productsRepository;
    
    @Autowired
    private OrdersRepository ordersRepository;
    
    @PostMapping("/new-order")
	public String newOrder(
			@RequestParam(name="clientID", required=true) String clientName, 
			@RequestParam(name="productID", required=true) long productID,
            @RequestParam(name="productID", required=true) int quantity,
			Model model)
	{
		
		User user = userRepository.findOneByUsername(clientName);
        Product product = productsRepository.findById(productID);
        LocalDateTime date = LocalDateTime.now();
        Float price = product.getPrice() * quantity;

		ordersRepository.save(new Orders(user, product, quantity, price, date));
		return "index";
	}
}