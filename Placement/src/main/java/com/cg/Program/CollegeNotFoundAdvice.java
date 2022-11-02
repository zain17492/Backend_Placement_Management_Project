package com.cg.Program;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CollegeNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(CollegeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,String> exceptionHandler(CollegeNotFoundException exception){
		Map<String,String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;
	}
}
