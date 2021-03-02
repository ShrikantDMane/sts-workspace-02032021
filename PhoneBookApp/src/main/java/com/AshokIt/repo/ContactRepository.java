package com.AshokIt.repo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AshokIt.entity.ContactDtlsEntity;

@Repository
public interface ContactRepository extends JpaRepository< ContactDtlsEntity, Serializable> {

	
	
}
