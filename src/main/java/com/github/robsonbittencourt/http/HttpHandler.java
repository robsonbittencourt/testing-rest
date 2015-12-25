package com.github.robsonbittencourt.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public final class HttpHandler {

	private static HttpHandler instance;

	private static HttpClient client;

	private HttpHandler() {

	}

	public static synchronized HttpHandler getInstance() {
		if (instance == null) {
			instance = new HttpHandler();
			client = HttpClientBuilder.create().build();
		}

		return instance;
	}

	public HttpResponse doRequest(String resourceUrl) {
		HttpUriRequest request = new HttpGet(resourceUrl);
		HttpResponse response = null;

		try {
			response = client.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}