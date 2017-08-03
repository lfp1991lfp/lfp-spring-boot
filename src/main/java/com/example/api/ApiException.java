package com.example.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date =
		"2017-08-02T03:21:02.511Z")

public class ApiException extends Exception {
	private int code;
	
	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
