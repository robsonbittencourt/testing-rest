package com.github.robsonbittencourt.util;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.robsonbittencourt.http.HttpsStatusCode;
import com.github.robsonbittencourt.http.Response;

public class JsonUtil {
	
	public static <T extends Response> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) {
		String jsonFromResponse;

		try {
			jsonFromResponse = EntityUtils.toString(response.getEntity());
			ObjectMapper mapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

			T entity = mapper.readValue(jsonFromResponse, clazz);

			int statusCode = response.getStatusLine().getStatusCode();
			entity.setResponseStatusCode(HttpsStatusCode.fromCode(statusCode));

			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
