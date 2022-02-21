/*
 * DemoApplicationTests
 *
 * date 21-02-2022
 *
 * Copyrights Ideas2IT
 */

package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.AppController.doAdd;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains method to unit test the application.
 *
 * @author  Raji Rajakumar
 * @version 1.0
 */
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		List<String> names = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			FileInputStream inputStream = new FileInputStream(new File("src/main/resources/listOfTeamMembers.json"));
			TypeReference<List<String>> typeReference = new TypeReference<List<String>>() {};
			names = mapper.readValue(inputStream, typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		}
		AppController appController = new AppController();
		assertEquals("Hello world", appController.showHelloWorld());
		assertEquals(names, appController.showTeamMembersName());
		assertEquals("The addition of an number is 10", doAdd("5", "5"));
	}

}
