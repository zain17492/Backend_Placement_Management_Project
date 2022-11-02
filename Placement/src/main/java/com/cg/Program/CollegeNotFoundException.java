package com.cg.Program;

public class CollegeNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CollegeNotFoundException(Long id) {
		super("could not found the College with id" + id);
	}
	


}
