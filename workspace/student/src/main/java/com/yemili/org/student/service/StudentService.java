package com.yemili.org.student.service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;
import com.yemili.org.student.model.Student;
import com.yemili.org.student.repository.StudentRepository;
import java.lang.String;
@Service
public class StudentService {
	
	public List <Student> studentlist=new ArrayList<>();
	
	@Autowired
	private StudentRepository studentRepository;

	//private Integer nextId = 1;
	public StudentService()
	 {
			/*
			 * studentlist.add(new Student(1, "John Doe", "")); studentlist.add(new
			 * Student(2, "Jane Smith", "")); studentlist.add(new Student(3, "yemili", ""));
			 * studentlist.add(new Student(4, "yamuna", "")); studentlist.add( new
			 * Student(6,"hemabushan", ""))
			 */;
	 }
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	 public Optional<Student> getById(Long id) {
	        return studentRepository.findById(id);
	 }
	public Student addStudent(Student student) {
		return studentRepository.save(student);
		
    }
	
	
	public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
	public Optional<Student> updateStudentName(Long id, String name) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name); // Update the name
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
            
	}		            
}
        



	