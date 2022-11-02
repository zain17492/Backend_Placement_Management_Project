package com.cg.Program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:3000")
public class PlacementController {
	
	@Autowired
	 private PlacementRepository placementRepository;
	
	@PostMapping("/placement")
	 Placement newplacement(@RequestBody Placement newplacement) {
	 return placementRepository .save(newplacement);
	 
	 }
	 
	 //RESTful API methods for Retrieval operations
	 @GetMapping("/placements")
	 List<Placement> getAllPlacements() {
	    return placementRepository.findAll();
	 }
	 
	 @GetMapping("/placement/{id}")
	  Placement getPlacementById(@PathVariable Long id) {
		 
	 
	 return placementRepository.findById(id)
			 .orElseThrow(()-> new PlacementNotFoundException(id));
	 
	 }
	 //RESTful API method for Create operation
	 
	 //RESTful API method for Update operation
	 @PutMapping("/placement/{id}")
	 Placement updatePlacement(@RequestBody Placement newplacement, @PathVariable Long id) { 
	 
	 return placementRepository.findById(id)
			 .map(placement-> {
		     placement.setCollegename(newplacement.getCollegename());
		     placement.setName(newplacement.getName());
		     placement.setDate(newplacement.getDate());
		     placement.setQualification(newplacement.getQualification());
		     placement.setYear(newplacement.getYear());
		     return placementRepository.save(placement);
	 }).orElseThrow(() -> new PlacementNotFoundException(id));
	 
	 }
	 //RESTful API method for Delete operation
	 @DeleteMapping("/placement/{id}")
	 String deletePlacement(@PathVariable Long id) {
		 if(!placementRepository.existsById(id)) {
			 throw new PlacementNotFoundException(id);
		 }
		 placementRepository.deleteById(id);
		 return "Placement with id "  + id + " has been deleted success";
		 
	 }

}

