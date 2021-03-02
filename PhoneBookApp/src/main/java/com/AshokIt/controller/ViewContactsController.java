package com.AshokIt.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.AshokIt.pojo.Contact;
import com.AshokIt.service.ContactService;

@Controller
public class ViewContactsController {

	
	//private static final Logger logger =(Logger) LoggerFactory.logger(ViewContactsController.class);
	
	
	@Autowired
	private ContactService contactservice;
	
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("id") Integer id,Model model) {
		
		Contact contact = contactservice.editContactById(id);
		model.addAttribute("contactobjkey",contact);
	    return "ContactForm";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("id") Integer id,RedirectAttributes rart) {
		 
	//	logger.info("***deleteContact() started ***");
		
		
		contactservice.deleteContact(id);            
		rart.addFlashAttribute("delsuccss","Contact is deleted successfully");
	//	logger.info("***deleteContact() executed***");
		return "redirect:viewContacts";
	}
	
	
	
}
