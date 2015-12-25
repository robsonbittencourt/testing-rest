package com.github.robsonbittencourt.rest;

import com.github.robsonbittencourt.entity.GitHubUser;

public class GitHubUserRest extends Rest {

	public GitHubUser getUser(String userName) {
		String resourceUrl = "users/";

		GitHubUser gitHubUser = requestHandler.get(resourceUrl + userName, GitHubUser.class);
		
		return gitHubUser;
	}

}
