package com.rahul.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rahul.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	//@Query(value="select username from admin a where username=?",nativeQuery=true)
	//@Query("select a from admin a whre username=?")
	public Optional<Admin> findByUsername(String usrname);
	//Optional<Admin> findByUsername(String username);
}
