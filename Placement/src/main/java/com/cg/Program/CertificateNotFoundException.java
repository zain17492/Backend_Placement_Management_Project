package com.cg.Program;

public class CertificateNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CertificateNotFoundException(Long id) {
		super("could not found the Certificate with id" + id);
	}
	


}
