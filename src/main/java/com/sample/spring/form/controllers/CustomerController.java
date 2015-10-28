package com.sample.spring.form.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.spring.form.model.CustomerVO;

@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	private Map<String, CustomerVO> customers = null;

	public CustomerController() {
		customers = new HashMap<String, CustomerVO>();
	}

	@RequestMapping(value = "/cust/save", method = RequestMethod.GET)
	public String saveCustomerPage(Model model) {
		logger.info("Returning custSave.jsp page");
		model.addAttribute("customerVO", new CustomerVO());
		return "custSave";
	}

	@RequestMapping(value = "/cust/save.do", method = RequestMethod.POST)
	public String saveCustomerAction(@Valid CustomerVO customerVO, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info("Returning custSave.jsp page");
			return "custSave";
		}
		logger.info("Returning custSaveSuccess.jsp page");
		model.addAttribute("customerVO", customerVO);
		customers.put(customerVO.getEmail(), customerVO);
		return "custSaveSuccess";
	}
}
