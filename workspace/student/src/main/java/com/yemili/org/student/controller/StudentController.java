package com.yemili.org.student.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yemili.org.student.model.Student;
import com.yemili.org.student.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	/*
	 * @GetMapping("/show") public List<Student> getStudent() { return
	 * studentservice.getAllStudents(); }
	 */
	
	@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentservice.getAllStudents());
        return "index"; // This will render index.html
    }
	
	@PostMapping("/students")
    public String addStudent(@ModelAttribute Student student) {
        studentservice.addStudent(student);
        return "redirect:/"; // Redirect to the home page
    }
	
	
	/*
	 * @GetMapping("/{id}") public Optional<Student> getStudentById(@PathVariable
	 * Long id) { return studentservice.getById(id); }
	 */

	/*
	 * @PostMapping("/addstudents") public Student addstudent(@RequestBody Student
	 * student) { // logger.info("Received student: {}", student); return
	 * studentservice.addStudent(student);
	 * 
	 * }
	 */
	/*
	 * @DeleteMapping("/{id}") public void deleteStudentById(@PathVariable Long id)
	 * { studentservice.deleteStudentById(id); }
	 * 
	 * @PutMapping("/{id}/name") public Optional<Student>
	 * updateStudentName(@PathVariable Long id, @RequestParam String name) { return
	 * studentservice.updateStudentName(id, name); }
	 */

}
