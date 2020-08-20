package com.cos.jwtex01.repository;

import java.util.List;

import com.cos.jwtex01.dto.ProductDto;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.jwtex01.model.User;

public interface UserRepository{
	User findByUsername(String username);
	List<User> findAll();
	public User saveGoogle(User user);
	public void save(User user);
	List<ProductDto> productDto();
}
