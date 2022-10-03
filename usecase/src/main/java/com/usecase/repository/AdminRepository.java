package com.usecase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usecase.entity.Admin;
import com.usecase.entity.Patient;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	@Query(value = "Select * from admin a where a.username=:username", nativeQuery = true )
	public Admin getUser(@Param("username")String username);

	boolean existsByUserName(String username);
	Admin findByUserNameAndPassword(String username, String password);

	
}
