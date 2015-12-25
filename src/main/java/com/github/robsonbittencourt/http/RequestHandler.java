package com.github.robsonbittencourt.http;

import org.apache.http.HttpResponse;

import com.github.robsonbittencourt.rest.Rest;
import com.github.robsonbittencourt.util.JsonUtil;

public class RequestHandler {

	public <T extends Response> T get(String resourceUrl, Class<T> clazz) {
		HttpHandler httpHandler = HttpHandler.getInstance();

		HttpResponse response = httpHandler.doRequest(Rest.BASE_URL + resourceUrl);

		return JsonUtil.retrieveResourceFromResponse(response, clazz);
	}

	public int get(String resourceUrl) {
		HttpHandler httpHandler = HttpHandler.getInstance();

		HttpResponse response = httpHandler.doRequest(resourceUrl);

		return response.getStatusLine().getStatusCode();
	}

}
