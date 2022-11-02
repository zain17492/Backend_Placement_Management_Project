package com.cg.Program;

	import java.util.List;
	import org.springframework.beans.factory.annotation.*;
	import org.springframework.web.bind.annotation.*;


	@RestController
	@CrossOrigin("http://localhost:3000")
public class CollegeController {
	
	
		
		@Autowired
		 private CollegeRepository collegeRepository;
		
		@PostMapping("/college")
		College newcollege(@RequestBody College newcollege) {
		 return collegeRepository .save(newcollege);
		 
		 }
		 
		 //RESTful API methods for Retrieval operations
		 @GetMapping("/colleges")
		 List<College> getAllColleges() {
		    return collegeRepository.findAll();
		 }
		 
		 @GetMapping("/college/{id}")
		 College getCollegeById(@PathVariable Long id) {
			 
		 
		 return collegeRepository.findById(id)
				 .orElseThrow(()-> new CollegeNotFoundException(id));
		 
		 }
		 
		 
		 //RESTful API method for Update operation
		 @PutMapping("/college/{id}")
		 College updateCollege(@RequestBody College newcollege, @PathVariable Long id) { 
		 
		 return collegeRepository.findById(id)
				 .map(college-> {
					 college.setCollegeadmin(newcollege.getCollegeadmin());
					 college.setCollegename(newcollege.getCollegename());
					 college.setLocation(newcollege.getLocation());
					 
			    
			     return collegeRepository.save(college);
		 }).orElseThrow(() -> new CollegeNotFoundException(id));
		 
		 }
		 //RESTful API method for Delete operation
		 @DeleteMapping("/college/{id}")
		 String deleteCollege(@PathVariable Long id) {
			 if(!collegeRepository.existsById(id)) {
				 throw new CollegeNotFoundException(id);
			 }
			 collegeRepository.deleteById(id);
			 return "College with id "  + id + " has been deleted successfully";
			 
		 }

	}





