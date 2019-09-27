package com.ust.model;

public class Login {
	
	private int userId;
	private String userName;
	private String password;
	
	////getters and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//constructors
	public Login() {
		super();
		
	}
	public Login(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	//toString() method 
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	

}
