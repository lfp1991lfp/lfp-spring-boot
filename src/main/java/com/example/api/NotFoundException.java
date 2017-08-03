package com.example.api;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date =
		"2017-08-02T03:21:02.511Z")

public class NotFoundException extends ApiException {
	private int code;
	
	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
