package com.sample.spring.form.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.sample.spring.form.model.LoginVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login")
	public String homepage(Model model) {
		LoginVO login = new LoginVO();
		model.addAttribute("loginVO", login);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid LoginVO loginVO, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			return "login";
		}
		
		if (loginVO.getPassword() == null || loginVO.getPassword().equals("")) {
			loginVO.setCaptcha("");
			model.addAttribute("message", "Password is required");
			return "login";
		}

		String captcha = (String) session.getAttribute("CAPTCHA");
		if (captcha == null || (captcha != null && !captcha.equals(loginVO.getCaptcha()))) {
			loginVO.setCaptcha("");
			model.addAttribute("message", "Captcha does not match");
			return "login";
		}

		if (loginVO.getUserId().equals("guest") && loginVO.getPassword().equals("ddd")) {
			LOGGER.info("user id and password matches");
			model.addAttribute("loginId", loginVO.getUserId());
			return "home";

		} else {
			loginVO.setCaptcha("");
			model.addAttribute("message", "User ID or Password Incorrect");
			return "login";
		}

	}

}
