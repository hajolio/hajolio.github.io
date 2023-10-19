package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class UserControllerITTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	UserRepository userRepository;
	@MockBean
	UserService userService;

	@Test
	public void testGetUserById() throws Exception {
		mockMvc.perform(get("/user/getUser/{userId}", 456)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllUsers() throws Exception {
		mockMvc.perform(get("/user/getAllUsers")).andExpect(status().isOk());
	}

	@Test
	public void testSaveUser() throws Exception {
		UserDto userDto = new UserDto(null, null, null);

		mockMvc.perform(post("/user/saveUser")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(userDto))
				)
				.andExpect(status().isOk());
	}


}
