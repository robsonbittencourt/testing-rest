package com.github.robsonbittencourt.test;

import static junit.framework.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.github.robsonbittencourt.entity.GitHubUser;
import com.github.robsonbittencourt.http.HttpsStatusCode;
import com.github.robsonbittencourt.rest.GitHubUserRest;

public class GitHubUserTest {
	
	private GitHubUserRest userRest = new GitHubUserRest();

	@Test
	public void shouldRecoverUser() throws ClientProtocolException, IOException {
		String userName = "robsonbittencourt";

		GitHubUser gitHubUser = userRest.getUser(userName);

		assertEquals("robsonbittencourt", gitHubUser.getLogin());
	}

	@Test
	public void shouldReturnNOKStatus() {
		String invalidUsername = "hsuhfkk";

		GitHubUser gitHubUser = userRest.getUser(invalidUsername);

		assertEquals(HttpsStatusCode.NOT_FOUND, gitHubUser.getResponseStatusCode());
	}

}
