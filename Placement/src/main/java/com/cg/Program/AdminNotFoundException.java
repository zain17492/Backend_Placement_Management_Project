package com.cg.Program;

public class AdminNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AdminNotFoundException(Long id) {
		super("could not found the Admin with id" + id);
	}
	


}
