package com.yemili.org.student.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.*;
import org.springframework.stereotype.Service;

import com.yemili.org.student.model.Examtype;
import com.yemili.org.student.model.Student;
import com.yemili.org.student.model.Studentaccedamicdetails;
import com.yemili.org.student.repository.ExamtypeRepository;
import com.yemili.org.student.repository.StudentRepository;
import com.yemili.org.student.repository.StudentaccedamicdetailsRepository;

import java.lang.String;
@Service
public class StudentService {
	
	public List <Student> studentlist=new ArrayList<>();
	
	public List <Studentaccedamicdetails> accedamiclist=new ArrayList<>();
	
	public List <Examtype> examtypelist=new ArrayList<>();
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentaccedamicdetailsRepository studentaccedamicRepository;
	
	@Autowired
	private ExamtypeRepository examtypeRepository;

	//private Integer nextId = 1;
	
	//get all students
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	
	//get student by id
	 public Optional<Student> getById(Long id) {
	        return studentRepository.findById(id);
	 }
	 
	 //add student
	public Student addStudent(Student student) {
		return studentRepository.save(student);
		
    }
	
	//delete student by id
	public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
	
	//update student
	public Optional<Student> updateStudentName(Long id, String name) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name); // Update the name
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
	}  
        
           
    
	//getting all accedamic details
	public List<Studentaccedamicdetails> getAllAcademicDetails() {
		// TODO Auto-generated method stub
		return studentaccedamicRepository.findAll();
	}
	//adding accedamic details
	public Studentaccedamicdetails addAcademicDetails(Studentaccedamicdetails academicDetails) {
		// TODO Auto-generated method stub
		return studentaccedamicRepository.save(academicDetails);
	}
	
	private void calculateTotalAndAverage(Studentaccedamicdetails academicDetails) {
        int total = academicDetails.getTamilmarks() +
                    academicDetails.getEnglishmarks() +
                    academicDetails.getMathsmarks() +
                    academicDetails.getSciencemarks() +
                    academicDetails.getSocialmarks();
        academicDetails.setTotal(total);
        academicDetails.setAverage(total / 5.0); // Assuming 5 subjects
    }
	 // Get all exam types
	public List<Examtype> getAllExamTypes() {
		// TODO Auto-generated method stub
		return examtypeRepository.findAll();
	}
	// Add new exam type
	public Examtype addExamType(Examtype examType) {

		return  examtypeRepository.save(examType);
	}
	// Get exam type by ID
	public Examtype getExamTypeById(Long id) {
		// TODO Auto-generated method stub
		return  examtypeRepository.findById(id).orElse(null);
	}
	 // Update exam type
	public Examtype updateExamType(Long id, Examtype updatedExamType) {
		Examtype existingExamType = getExamTypeById(id);
        if (existingExamType != null) {
            existingExamType.setName(updatedExamType.getName());
            existingExamType.setDate(updatedExamType.getDate());
            return examtypeRepository.save(existingExamType);
        }
        return null;
    }
	 // Delete exam type by ID
	public void deleteExamType(Long id) {
		// TODO Auto-generated method stub
		examtypeRepository.deleteById(id);
	}
	
}
        



	