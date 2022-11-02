package com.cg.Program;


public class PlacementNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PlacementNotFoundException(Long id) {
		super("could not found the Placement with id" + id);
	}
	
}
