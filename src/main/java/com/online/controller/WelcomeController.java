package com.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.entity.Welcome;

@Controller
public class WelcomeController {
	private static final String welcomemsg = "Welcome Mr. %s!";

	@GetMapping("/welcome/user")
	@ResponseBody
	public Welcome welcomeUser(
			@RequestParam(name = "name", required = false, defaultValue = "Java Fan") String name) {
		return new Welcome(String.format(welcomemsg, name));
	}
	
	
	@GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}