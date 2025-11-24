package com.kdt11.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.kdt11.entity.Post;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class TestRepositoryTests {
	
	@Autowired
	TestRepository repository;
	
	@Test 
	@Transactional
	@Rollback(false) //test후에도 데이터를 남기는 설정 
	void testInsertOne() {
		Post post = Post.builder()
						.title("네번째 글을 올립니다.")
						.writer("oksmin")
						.content(" JPA가 편하긴 하죠 :) ")
						.build();
		
		Post saved = repository.save(post);
		log.info(">> 저장된 Seq - " + saved.getSeq());
	}
	@Test  
	void testSelectAllPosts() {
		List<Post> list = repository.findAll();
		
		log.info(">>> 게시글 수 = {}", list.size());
		
		for( Post p : list) {
			log.info(">>> id = {}, title = {}, writer = {}"
					 , p.getSeq(), p.getTitle(), p.getWriter()		);
		}
	}

}
