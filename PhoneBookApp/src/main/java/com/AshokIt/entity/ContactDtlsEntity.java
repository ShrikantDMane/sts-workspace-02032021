package com.AshokIt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "Contact_Details")
public class ContactDtlsEntity {

	@Id
	@GeneratedValue
	@Column(name="Contact_ID")
	private Integer id;
	
	@Column(name="Contact_Name")
	private String cname;
	
	@Column(name="Contact_Email")
	private String cemail;
	
	@Column(name="Contact_Number")
	private Double cno;
	
	
	
	
	
}
