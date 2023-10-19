package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.dto.SkillDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class BootDemoApplicationTests {

	@Autowired
	private UserController userController;

	@MockBean
	UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSaveUser() {
		UserDto userDto = new UserDto(123, "Testname", List.of(new SkillDto()));
		assertDoesNotThrow(() -> userController.saveUser(userDto), "Could not call the saveUser method.");
	}

}
