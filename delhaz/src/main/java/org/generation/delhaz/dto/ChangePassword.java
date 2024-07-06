package org.generation.delhaz.dto;

public class ChangePassword {
	private String password;
	private String newpassword;
	
	public ChangePassword(String password, String newpassword) {
		super();
		this.password = password;
		this.newpassword = newpassword;
	}//constructor
	
    // Constructor vacio
    public ChangePassword() {}
	
	//getters and setters
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", newpassword=" + newpassword + "]";
	}//toString
	
}
