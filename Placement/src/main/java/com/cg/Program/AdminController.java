package com.cg.Program;

	import java.util.List;
	import org.springframework.beans.factory.annotation.*;
	
	import org.springframework.web.bind.annotation.*;


	@RestController
	@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	
		
		@Autowired
		 private AdminRepository adminRepository;
		
		//RESTful API method for Create operation
		@PostMapping("/admin")
		 Admin newadmin(@RequestBody Admin newadmin) {
		 return adminRepository .save(newadmin);
		 
		 }
		 
		 //RESTful API methods for Retrieval operations
		 @GetMapping("/admins")
		 List<Admin> getAllAdmins() {
		    return adminRepository.findAll();
		 }
		 
		 @GetMapping("/admin/{id}")
		  Admin getAdminById(@PathVariable Long id) {
			 
		 
		 return adminRepository.findById(id)
				 .orElseThrow(()-> new AdminNotFoundException(id));
		 
		 }
		 
		 
		 //RESTful API method for Update operation
		 @PutMapping("/admin/{id}")
		 Admin updateAdmin(@RequestBody Admin newadmin, @PathVariable Long id) { 
		 
		 return adminRepository.findById(id)
				 .map(admin-> {
					 admin.setAdminname(newadmin.getAdminname());
					 admin.setPassword(newadmin.getPassword());
			    
			     return adminRepository.save(admin);
		 }).orElseThrow(() -> new AdminNotFoundException(id));
		 
		 }
		 //RESTful API method for Delete operation
		 @DeleteMapping("/admin/{id}")
		 String deleteAdmin(@PathVariable Long id) {
			 if(!adminRepository.existsById(id)) {
				 throw new AdminNotFoundException(id);
			 }
			 adminRepository.deleteById(id);
			 return "Admin with id "  + id + " has been deleted successfully";
			 
		 }

	}


