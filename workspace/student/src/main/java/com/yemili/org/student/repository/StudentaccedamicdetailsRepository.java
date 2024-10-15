package com.yemili.org.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yemili.org.student.model.Student;
import com.yemili.org.student.model.Studentaccedamicdetails;

@Repository
public interface StudentaccedamicdetailsRepository extends JpaRepository<Studentaccedamicdetails,Long>{
	
	 List<Studentaccedamicdetails> findByUserIdAndExamType(Integer userId, String examType);

}
