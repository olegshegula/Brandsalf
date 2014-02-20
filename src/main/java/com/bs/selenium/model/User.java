package com.bs.selenium.model;

public class User {

	private String id;
	private String login;
	private String email;
	private String password;
	private String role;
	private String uservideo;
	private String username;
	private String phone;
	private String password2;

	public String getUservideo() {
		return uservideo;
	}

	public User setUservideo(String uservideo) {
		this.uservideo = uservideo;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getPassword2() {
		return password2;
	}

	public User setPassword2(String password2) {
		this.password2 = password2;
		return this;
	}

	public String getId() {
		return id;
	}

	public User setId(String id) {
		this.id = id;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getRole() {
		return role;
	}

	public User setRole(String role) {
		this.role = role;
		return this;
	}

}
