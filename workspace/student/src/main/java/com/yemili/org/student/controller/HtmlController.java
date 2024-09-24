package com.yemili.org.student.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.yemili.org.student.model.Student;
import com.yemili.org.student.service.StudentService;

@RestController
public class HtmlController {
	
	    @Autowired
	    private StudentService studentservice;

	    @GetMapping("/registrationform")
	    public ModelAndView showRegistrationForm() {
	        return new ModelAndView("registrationform");
	    }

	    @PostMapping("/register")
	    public String registerStudent(@RequestParam String name, @RequestParam String gender,@RequestParam String email,@RequestParam String mobilenumber,@RequestParam String password,@RequestParam Integer age) {
	        Student student = new Student();
	        student.setName(name);
	        student.setGender(gender);
	        student.setEmail(email);
	        student.setMobilenumber(mobilenumber);
	        student.setPassword(password);
	        student.setAge(age);
	        studentservice.addStudent(student);
	        return "Registration successful";
	    }
	}



