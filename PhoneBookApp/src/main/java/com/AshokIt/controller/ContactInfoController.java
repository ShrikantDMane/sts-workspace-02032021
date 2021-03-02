package com.AshokIt.controller;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.AshokIt.pojo.Contact;
import com.AshokIt.service.ContactService;

@Controller
public class ContactInfoController {

	
	//private static final Logger logger = (Logger) LoggerFactory.logger(ContactInfoController.class);
	
	@Autowired
	private ContactService contactservice;

	@GetMapping(value = { "/", "/loadForm" })
	public String loadContactForm(Model model) {

		//logger.info("***loadcontact() started***");
		
		Contact contactemptyobj = new Contact();
		model.addAttribute("contactobjkey", contactemptyobj);
		//logger.info("***loadcontact() ended***");
		
		return "ContactForm";
		
		
	}

	@PostMapping("/addcontact")
	public String handleSubmitBtn(@ModelAttribute("contactobjkey") Contact c, RedirectAttributes rda) {

		//logger.info("***handlesubmitbutton() started***");
		
		boolean isSaved = contactservice.addContact(c);
		if (isSaved) {

			if (c.getId() != null) {

				rda.addFlashAttribute("sucssmsg", "Contact is updated successfully");
			} else {

				rda.addFlashAttribute("sucssmsg", "Contact Saved");
			}

		} else {

			rda.addFlashAttribute("errmsg", "Failed To Save Contact");
		}
		
		//logger.info("***handlesubmitbutton() executed***");
		return "redirect:loadForm";

		
	}

	@GetMapping("/viewContacts")
	public String viewContacts(Model model) {

		List<Contact> allContacts = contactservice.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "ViewContacts";

	}

}
