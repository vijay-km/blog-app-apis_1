package com.vijayblog.blogappapis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vijayblog.blogappapis.Rpositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest(){
		String className = this.userRepo.getClass().getName();
		String packName = this.userRepo.getClass().getPackage().getName();
		System.out.println(className);
		System.out.println(packName);
		System.out.println("hello");

	}
}
