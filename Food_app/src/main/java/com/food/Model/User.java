package com.food.Model;

import java.sql.Timestamp;

public class User {
   int UserId;
   private String UserName;
   private  String password;
   private String email;
   private String address;
   private String role;
   private Timestamp createdDate;
  private Timestamp lastLoginDate;
    
     public User() {
    	 
     }
     
     

	 public int getUserId() {
		return UserId;
	}



	 public void setUserId(int userId) {
		 this.UserId = UserId;
	 }



	 public String getUserName() {
		 return UserName;
	 }



	 public void setUserName(String userName) {
		 this.UserName = userName;
	 }



	 public String getPassword() {
		 return password;
	 }



	 public void setPassword(String password) {
		 this.password = password;
	 }



	 public String getEmail() {
		 return email;
	 }



	 public void setEmail(String email) {
		 this.email = email;
	 }



	 public String getAddress() {
		 return address;
	 }



	 public void setAddress(String address) {
		 this.address = address;
	 }



	 public String getRole() {
		 return role;
	 }



	 public void setRole(String role) {
		 this.role = role;
	 }



	 public Timestamp getCreatedDate() {
		 return createdDate;
	 }



	 public void setCreatedDate(Timestamp createdDate) {
		 this.createdDate = createdDate;
	 }



	 public Timestamp getLastLoginDate() {
		 return lastLoginDate;
	 }



	 public void setLastLoginDate(Timestamp lastLoginDate) {
		 this.lastLoginDate = lastLoginDate;
	 }



	 public User(int userId, String userName, String password, String email, String address, String role,
			Timestamp createdDate, Timestamp lastLoginDate) {
		super();
		this.UserId = userId;
		this.UserName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}



	 public User(String userName, String password, String email, String address, String role) {
		super();
		this.UserName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		//this.createdDate = createdDate;
		//this.lastLoginDate = lastLoginDate;
	 }

	 @Override
	 public String toString() {
		return "User [userId=" + UserId + ", userName=" + UserName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", role=" + role +  "]";
	 }
	 
}
