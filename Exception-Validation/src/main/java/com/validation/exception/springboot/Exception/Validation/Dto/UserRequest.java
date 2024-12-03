package com.validation.exception.springboot.Exception.Validation.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class UserRequest {
	
	@NotNull(message = "username cannot be null")
	private String name;
	
	@Email(message = "invalid email address entered")
	private String email;
	
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
	private String mobile;
	
	private String gender;
	
	@Min(18)
	@Max(60)
	private int age;
	
	@NotBlank
	private String nationality;
	

	
	public UserRequest(String name, String email, String mobile, String gender, int age, String nationality) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
	}
	
	public UserRequest() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", age="
				+ age + ", nationality=" + nationality + "]";
	}
	
	
	
}
