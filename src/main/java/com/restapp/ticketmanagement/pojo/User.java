package com.restapp.ticketmanagement.pojo;

public class User {

	private int userid;
	private String username;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(int userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + "]";
	}
	
	

}
