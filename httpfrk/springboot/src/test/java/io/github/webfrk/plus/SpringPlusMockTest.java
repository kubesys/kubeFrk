/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.webfrk.plus;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.github.kubesys.devfrk.spring.assists.HttpConstants;


/**
 * @author wuheng@iscas.ac.cn
 * @since  2019.11.16
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringPlusBootServer.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages= {"io.github.kubesys.httpfrk", "io.github.webfrk.plus.examples"})
class SpringPlusMockTest  {

	final static String INVALID_GET_REQUEST_PATH = "/mock/listMock8";
	
	final static String VALID_POST_REQUEST_PATH = "/swagger/echoHello";
	
	final static String VALID_POST_REQUEST_PATH2 = "/swagger/echoHello2";
	
	final static String LESS_THAN_MIN_SIZE = "ab";
	
	final static String GREAT_THAN_MAX_SIZE = "abccccccccc";
	
	final static String VALID_SIZE = "abc";
	
	@Autowired
	private MockMvc mvc;

	@Test
	void testInvalidGetRequestBody() throws Exception {
		@SuppressWarnings("deprecation")
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(
							INVALID_GET_REQUEST_PATH)
				.param("name", LESS_THAN_MIN_SIZE)
				.accept(MediaType.APPLICATION_JSON_UTF8);
		mvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(jsonPath("code").value(HttpConstants.HTTP_RESPONSE_STATUS_FAILED));
	}
	
	
	@Test
	void testInValidPostParameterBody() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post(VALID_POST_REQUEST_PATH)
				.content("{ \"name\": \"hen\" }")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(jsonPath("code").value(50000));
	}
	
	@Test
	void testInValidPost2ParameterBody() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post(VALID_POST_REQUEST_PATH2)
				.content("{ \"user\": { \"name\": \"hen\", \"age\": 23 }}")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(jsonPath("code").value(50000));
	}
	
	@Test
	void testValidPostRequestBody() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post(VALID_POST_REQUEST_PATH)
				.content("{ \"name\": \"henry\" }")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(jsonPath("data").value("Hello henry!"));
	}
	
	public static void main(String[] args) {
		System.out.println("{ \"user\": { \"name\": \"hen\", \"age\": 23 }}");
	}
}
