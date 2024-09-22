package com.yemili.org.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Table(name="student_accdemicdatails")
@Entity
public class Studentaccedamicdetails {
	
	  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id")
	  private int id;
	  
	  @Column(name = "student_id")
	  private int student_id;
	  
	  @Column(name = "exam_id")
	  private int exam_id; 
	  
	  @Column(name = "tamilmarks")
	  private int tamilmarks;
	  
	  @Column(name = "englishmarks")
	  private int englishmarks;
	  
	  @Column(name = "mathsmarks")
	  private int mathsmarks; 
	  
	  @Column(name = "sciencemarks")
	  private int sciencemarks;
	  
	  @Column(name = "socialmarks")
	  private int socialmarks;
	  
	  @Column(name = "total")
	  private int total;
	  
	  @Column(name = "average")
	  private double average;
	  
	  @ManyToOne
	    @JoinColumn(name = "student_id", nullable = false)
	    private Student student;

	    @ManyToOne
	    @JoinColumn(name = "exam_id", nullable = false)
	    private Examtype examType;
	    
	  public Studentaccedamicdetails() {
		  
	  }
	  
	  
	  public Studentaccedamicdetails(int id,int student_id,int exam_id,int tamilmarks,int englishmarks,int mathsmarks,int sciencemarks,int socialmarks,int total,double average){
		  
		  this.id=id;
		  this.student_id=student_id;
		  this.exam_id=exam_id;
		  this.tamilmarks=tamilmarks;
		  this.englishmarks=englishmarks;
		  this.average=average;
		  this.mathsmarks=mathsmarks;
		  this.sciencemarks=sciencemarks;
		  this.socialmarks=socialmarks;
		  this.total=total;
		  
	  }
	  
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double d) {
		this.average = d;
	}

	  public int getStudent_id() 
	  {
		  return student_id; 
	  }
	  public void setStudent_id(int student_id) 
	  {
		  this.student_id = student_id;
	  }
	  public int getExam_id()
	  {
		  return exam_id;
	  } 
	  public void setExam_id(int exam_id)
	  {
		  this.exam_id = exam_id;
	  } 
	  public int getTamilmarks()
	  { 
		  return tamilmarks;
	  
	  }
	  public void setTamilmarks(int tamilmarks) 
	  {
		  this.tamilmarks = tamilmarks;
	  }
	  public int getEnglishmarks() 
	  {
		  return englishmarks; 
	  }
	  public void setEnglishmarks(int englishmarks) 
	  { 
		  this.englishmarks = englishmarks;
	  }
	  public int getMathsmarks() 
	  {
		  return mathsmarks; 
	  }
	  public void setMathsmarks(int mathsmarks) 
	  {
		  this.mathsmarks = mathsmarks;
	  }
	  public int getSciencemarks() 
	  {
		  return sciencemarks; 
	  } 
	  public void setSciencemarks(int sciencemarks) 
	  {
		  this.sciencemarks = sciencemarks; 
	  }
	  public int getSocialmarks() 
	  {
		  return socialmarks;
	  } 
	  public void setSocialmarks(int socialmarks)
	  {
		  this.socialmarks = socialmarks;
	  }
	 
}
