package com.kdt11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdt11.entity.Post;

public interface TestRepository extends JpaRepository<Post, Integer>{ //Post:entity, Integer:pk타입
	
	// save(), findAll(), findById(), deleteById() 등은 이미 상속됨!
}
