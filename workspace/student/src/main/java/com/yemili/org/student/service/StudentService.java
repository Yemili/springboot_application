package com.yemili.org.student.service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import org.springframework.stereotype.Service;

import com.yemili.org.student.controller.AcademicDetail;
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
		//Optional<Student> studentOpt = studentRepository.findById(studentId);
        
        System.out.println("student id:"+academicDetails.getId());
        System.out.println("student exam id:"+academicDetails.getExam_id());
        System.out.println("student tamil marks:"+academicDetails.getTamil_marks());
        System.out.println("student english marks:"+academicDetails.getEnglish_marks());
        System.out.println("student maths marks:"+academicDetails.getMaths_marks());
        System.out.println("student science marks:"+academicDetails.getScience_marks());
        System.out.println("student social:"+academicDetails.getSocial_marks());
        System.out.println("student total:"+calculateTotalAndAverage(academicDetails).getTotal());
        System.out.println("student average:"+calculateTotalAndAverage(academicDetails).getAverage());
        System.out.println("student id from student:"+academicDetails.getStudent_id());
        
        
		//System.out.println(calculateTotalAndAverage(academicDetails));
		return studentaccedamicRepository.save(academicDetails);
        }
		//else {
        //    throw new IllegalArgumentException("Invalid student ID"); // Handle case where student is not found
      //  }
	//}
	
	private Studentaccedamicdetails calculateTotalAndAverage(Studentaccedamicdetails academicDetails) {
        int total = academicDetails.getTamil_marks() +
                    academicDetails.getEnglish_marks() +
                    academicDetails.getMaths_marks() +
                    academicDetails.getScience_marks() +
                    academicDetails.getSocial_marks();
        academicDetails.setTotal(total);
        academicDetails.setAverage(total / 5.0); // Assuming 5 subjects
		return academicDetails;
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
            existingExamType.setExam_name(updatedExamType.getExam_name());
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
	
	
	private List<Studentaccedamicdetails> fetchAcademicDetails(String name, String examType) {
		
		// Step 1: Retrieve the user by their name
	    Optional<Student> student = studentRepository.findByname(name);
	    if (student.isPresent()) {
	        Integer userId = student.get().getId(); // Now you can call getId()
	    } else {
	        throw new IllegalArgumentException("User not found with name: " + name);
	    }
	    
	    // Step 2: Fetch academic details based on the user's ID and the selected exam type
	    List<Studentaccedamicdetails> academicDetails = studentaccedamicRepository.findByUserIdAndExamType(userId, examType);
	    
	    // Check if there are academic details for the selected exam type
	    if (academicDetails.isEmpty()) {
	        throw new IllegalArgumentException("No academic details found for exam type: " + examType);
	    }
	    
	    return academicDetails; // Return the retrieved academic details

	}
	
	
}
        



	