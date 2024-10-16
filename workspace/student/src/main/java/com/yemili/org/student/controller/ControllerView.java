package com.yemili.org.student.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yemili.org.student.model.Examtype;
import com.yemili.org.student.model.Student;
import com.yemili.org.student.model.Studentaccedamicdetails;
import com.yemili.org.student.repository.StudentRepository;
import com.yemili.org.student.service.StudentService;

@Controller
@RequestMapping("/view")
public class ControllerView {

	@Autowired
	private StudentService studentservice;

	@Autowired
	private StudentRepository studentRepository;

	
//	@Autowired private BCryptPasswordEncoder passwordEncoder;
	 
	public ControllerView(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		// System.out.println("****************************************************8");
		model.addAttribute("student", new Student());

		return "registrationform"; // Returns the Thymeleaf template name
	}

	@PostMapping("/registration")
	public String addRegistrationForm(@ModelAttribute Student student) {
		studentservice.addStudent(student);
		return "registrationform";

	}

	@GetMapping("/login") public String showLoginForm(Model model) { //
		 // System.out.println("****************************************************8");
		  model.addAttribute("student", new Student());
		  
		  return "index"; 
		  }// Returns the Thymeleaf template name } }
		 


	@PostMapping("/loginForm")
	public String loginForm(String name, String password, Model model) {
		Optional<Student> students = studentRepository.findByname(name);
		 if (students.isPresent()) {
			System.out.println(students.get()); 
			model.addAttribute("student", students.get());
			return "redirect:/view/welcome?name=" + name;		
					
		}
		 else{model.addAttribute("error", "Invalid name or password");
		return "index";}

	}
	
	@GetMapping("/welcome")
	public String showWlcome(@RequestParam String name,Model model) { 
		 model.addAttribute("name", name);
			
		 Optional<Student> students = studentRepository.findByname(name);
		 if(students.isPresent()) {
		  
		  model.addAttribute("name", name); }
			return "welcomepage";
		 
		  }// Returns the Thymeleaf template name
	
		 
	

	@GetMapping("/register")
	public String registerStudent(Student student, Model model) {
//        studentservice.addStudent(student);
		model.addAttribute("message", "Registration Successful!");
		return "registrationsuccess";
	}
	
	
	@GetMapping("/viewDetails")
	public String viewDetails(@RequestParam String name, Model model) {
        // Fetch user details from the database
		Optional<Student> students = studentRepository.findByname(name);
		 if (students.isPresent()) {
			System.out.println(students.get()); 
			model.addAttribute("student", students.get());
				
					
		}
		else{model.addAttribute("error", "Invalid name ");
		
		}
		 // Thymeleaf template for displaying details
		 return "detailsPage";	
	}
	

	
	
		
	

	@GetMapping("/studentlist")
	public String getStudentList(Model model) {
		List<Student> students = studentservice.getAllStudents();
		model.addAttribute("students", students);
		return "studentdetails";
	}

	@GetMapping("/{id}")
	public String getStudentById(@PathVariable Long id, Model model) {
		Optional<Student> student = studentservice.getById(id);
		if (student.isPresent()) {
			System.out.println(student.get().getName());
			System.out.println(student.get().getGender());
			System.out.println(student.get().getMobilenumber());
			System.out.println(student.get().getPassword());
			System.out.println(student.get().getAge());

			// Student student1 = student.get();
			// System.out.println("Student Name: " + student1.getName());
			model.addAttribute("student", student.get());

		} else {
			model.addAttribute("message", "student not found");
		}
		return "studentdetails";
	}

	@GetMapping("/studentexamlist")
	public String getStudentsExamList(Model model) {
		List<Examtype> exams = studentservice.getAllExamTypes();
		// List<Student> students = studentservice.getAllStudents();
		model.addAttribute("exams", exams);
		return "studentexamdetails";
	}

	@GetMapping("/studentaccdemiclist")
	public String getStudentsAccdemicList(Model model) {
		List<Studentaccedamicdetails> details = studentservice.getAllAcademicDetails();

		model.addAttribute("details", details);
		return "studentaccdemicdetails";
	}

}
