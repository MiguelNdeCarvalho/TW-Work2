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
public class ProfileController {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private OrdersRepository ordersRepository;
	
	@GetMapping("/profile")
	public String profileControl(
                @RequestParam(name="clientName", required=true) String clientName,
                Model model) 
	{
                User user = userRepository.findOneByUsername(clientName);
                List<Orders> ordersList = (List<Orders>) ordersRepository.findByUser(user); //Get all orders for that user
                model.addAttribute("ordersList", ordersList);
                return "profile";
	}
}