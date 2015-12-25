package com.github.robsonbittencourt.http;

public enum HttpsStatusCode {

	OK(200), BAD_REQUEST(400), NOT_FOUND(404);

	private final int code;

	HttpsStatusCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static HttpsStatusCode fromCode(int statusCode) {
		for (HttpsStatusCode httpStatus : HttpsStatusCode.values()) {
			if (httpStatus.getCode() == statusCode) {
				return httpStatus;
			}
		}

		return null;
	}

}
