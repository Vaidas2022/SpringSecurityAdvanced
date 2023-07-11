package lt.codeacademy.learn.securitydb.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import lt.codeacademy.learn.securitydb.entities.MyUser;
import lt.codeacademy.learn.securitydb.exceptions.UserAlreadyExistException;
import lt.codeacademy.learn.securitydb.services.MyUserDetailsService;
import lt.codeacademy.learn.securitydb.utils.Roles;

@Controller
public class MainController {
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MyUserDetailsService uService;
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/user/hello")
	public String helloUser() {
		return "/user/hello";
	}
	
	@GetMapping("/admin/users")
	public String adminUsers(Model model) {
		model.addAttribute("users",uService.loadAllUsers() ); 		
		return "/admin/users";
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
	    model.addAttribute("user", new MyUser());
	    return "registration";
	}
	
	@PostMapping("/registration")
	public String registerUserAccount(MyUser user, Model model) {
		user.setRole(Roles.USER);		
		logger.info("Registering new user: " + user);
		try {
			MyUser registered = uService.registerNewUserAccount(user);
			logger.info(  registered != null? "Registered success" : "User not saved"    );
			return "redirect:/";
		} catch (UserAlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("user", user);
		//model.addAttribute(errors);
		return "registration";
	}
	
	@GetMapping("/json")
	public @ResponseBody MyUser getJson() {
		return new MyUser();
	}
}
