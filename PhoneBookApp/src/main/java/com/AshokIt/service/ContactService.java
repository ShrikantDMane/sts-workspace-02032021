package com.AshokIt.service;

import java.util.List;

import com.AshokIt.pojo.Contact;

public interface ContactService {

	
	public boolean addContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact editContactById(Integer id);
	
	public boolean updateContact(Contact contact);
	
	public boolean deleteContact(Integer id);
}
