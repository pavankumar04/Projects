package com.example.springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findUser(int id);

}
