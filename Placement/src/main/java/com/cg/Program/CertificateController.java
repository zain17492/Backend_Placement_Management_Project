package com.cg.Program;

	import java.util.List;
	import org.springframework.beans.factory.annotation.*;
	import org.springframework.web.bind.annotation.*;

	


	@RestController
	@CrossOrigin("http://localhost:3000")
public class CertificateController {
	
	
		
		@Autowired
		 private CertificateRepository certificateRepository;
		
		@PostMapping("/certificate")
		Certificate newcertificate(@RequestBody Certificate newcertificate) {
		 return certificateRepository .save(newcertificate);
		 
		 }
		 
		 //RESTful API methods for Retrieval operations
		 @GetMapping("/certificates")
		 List<Certificate> getAllCertificates() {
		    return certificateRepository.findAll();
		 }
		 
		 @GetMapping("/certificate/{id}")
		 Certificate getCertificateById(@PathVariable Long id) {
			 
		 
		 return certificateRepository.findById(id)
				 .orElseThrow(()-> new CertificateNotFoundException(id));
		 
		 }
		 
		 
		 //RESTful API method for Update operation
		 @PutMapping("/certificate/{id}")
		 Certificate updateCertificate(@RequestBody Certificate newcertificate, @PathVariable Long id) { 
		 
		 return certificateRepository.findById(id)
				 .map(certificate-> {
					 certificate.setCollegename(newcertificate.getCollegename());
					 certificate.setYear(newcertificate.getYear());
			    
			     return certificateRepository.save(certificate);
		 }).orElseThrow(() -> new CertificateNotFoundException(id));
		 
		 }
		 //RESTful API method for Delete operation
		 @DeleteMapping("/certificate/{id}")
		 String deleteCertificate(@PathVariable Long id) {
			 if(!certificateRepository.existsById(id)) {
				 throw new CertificateNotFoundException(id);
			 }
			 certificateRepository.deleteById(id);
			 return "Certificate with id "  + id + " has been deleted successfully";
			 
		 }

	}



