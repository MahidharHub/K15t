package com.k15t.pat.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.k15t.pat.domain.Registration;

/**
 * HomeController is used to direct the user to the home page and to the registration form
 * 
 * @author Mahidhar
 *
 */

@Controller
public class HomeController {
	
	/**
	 * 
	 * @return index. The page index.html is displayed
	 */
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	/**
	 * 
	 * @param model
	 * @return view of the registration form
	 */
	@RequestMapping("/newRegistration")
	public String registration(Model model) {
		model.addAttribute("registration", new Registration());
		return "registration/registrationForm";
	}

}
