package org.pingu.shop.jpa;

import java.lang.reflect.Parameter;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Controller
public class NewUserController {

    @Autowired
    private UserRepository repository;
    
	@PostMapping("/new-user")
	public String newUser(
			@RequestParam(name="firstName", required=false, defaultValue="") String firstName, 
			@RequestParam(name="lastName", required=false, defaultValue="") String lastName,
			@RequestParam(name="mail", required=false, defaultValue="") String mail,
			@RequestParam(name="username", required=false, defaultValue="") String username,
			@RequestParam(name="password", required=false, defaultValue="") String password,
			// @RequestParam(name="role", required=false, defaultValue="user") String role,
			Model model) 
	{
		String encodedPassword = new BCryptPasswordEncoder().encode(password);
        repository.save(new User(firstName, lastName, mail, username, encodedPassword, "ROLE_" + "USER"));

		return "index";
	}
}