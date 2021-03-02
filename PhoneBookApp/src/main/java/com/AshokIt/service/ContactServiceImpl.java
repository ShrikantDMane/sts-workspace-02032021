package com.AshokIt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AshokIt.entity.ContactDtlsEntity;
import com.AshokIt.pojo.Contact;
import com.AshokIt.repo.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactrepository;
	
	
	public boolean addContact(Contact contact) {
		
		ContactDtlsEntity entity =new ContactDtlsEntity();      
	    BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity savedentity = contactrepository.save(entity);
		return savedentity.getId()!=null;
	}

	
	public List<Contact> getAllContacts() {
		
		List<ContactDtlsEntity> entitiesList = contactrepository.findAll();
		List<Contact> contactsList = new ArrayList<>();
		
		  entitiesList.forEach(oftheentitypresentinentitieslist -> {
		  
		  Contact c = new Contact();
		  BeanUtils.copyProperties(oftheentitypresentinentitieslist, c);
		  contactsList.add(c); });
		   return contactsList;
	}


	public Contact editContactById(Integer id) {
		
		Optional<ContactDtlsEntity> optional = contactrepository.findById(id);
		if(optional.isPresent()) {
			
			ContactDtlsEntity entity = optional.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		   return null;
                
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteContact(Integer id) {
		
		contactrepository.deleteById(id);
		return true;
	}

}
