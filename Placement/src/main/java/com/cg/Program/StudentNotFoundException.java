package com.cg.Program;

public class StudentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(Long id) {
		super("could not found the Student with id " + id);
	}
	

}
