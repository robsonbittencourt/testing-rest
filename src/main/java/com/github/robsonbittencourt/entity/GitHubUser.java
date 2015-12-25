package com.github.robsonbittencourt.entity;

import com.github.robsonbittencourt.http.Response;

public class GitHubUser extends Response {
	
	private String login;
	private String url;
	
	public String getLogin() {
		return login;
	}
	
	public String getUrl() {
		return url;
	}
	
}
