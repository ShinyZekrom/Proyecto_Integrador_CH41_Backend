package org.generation.delhaz.dto;

public class Token {
	private final String accessToken;
	private Long userId;
	private String email;
	private String username;

	public Token(String accessToken, Long userId, String email, String username) {
		this.accessToken = accessToken;
		this.userId = userId;
        this.email = email;
        this.username = username;
	}//constructor

	public String getAccessToken() {
		return accessToken;
		
		
	}//getAccessToken

	public Long getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
}
