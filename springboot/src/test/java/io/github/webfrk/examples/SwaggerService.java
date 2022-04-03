package io.github.webfrk.examples;


import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.kubesys.httpfrk.cores.HttpHandler;
import io.github.kubesys.tools.annotations.ServiceDefinition;


@ServiceDefinition
public class SwaggerService extends HttpHandler {
	
	public Object echoHello( /* 参数注解 */
			@Size(min = 5) String name) {
		return "Hello " + name + "!";
	}
	
	public String echoHello1( /* 参数注解 */
			String name,
			String habit) throws Exception {
		throw new Exception("assddd");
	}
	
	@PostMapping
	public Object echoHello2(@RequestBody @Valid User user) {
		return "Hello, " + user.getName();
	}
	
	public static class User {
		
		@Size(min = 1, max = 20)
		protected String name;
		
		@Min(0)
	    @Max(100)
		protected int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(User.class.getSimpleName());
	}
}