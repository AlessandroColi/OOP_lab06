package it.unibo.exceptions.arithmetic;

import java.io.IOException;

public class NetworkException extends IOException {
	
	private static final long serialVersionUID = 1L;
	
	public NetworkException() {
		super("Network error: no response");
	}
	public NetworkException(String s) {
		super("Network error whlie sending message:" + s);
	}
}