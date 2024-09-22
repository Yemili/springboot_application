package com.yemili.org.student.model;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "exam_type")
public class Examtype {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idexam_type")
	private int idexam_type;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date")
	private String date;
	
	@OneToMany(mappedBy = "examType", cascade = CascadeType.ALL)
    private Collection<Studentaccedamicdetails> academicDetails;

	
	public Examtype() {
		
	}
	
	public Examtype(int idexam_type,String name,String date)
	{
		this.date=date;
		this.idexam_type=idexam_type;
		this.name=name;
	}
	
	public int getIdexam_type() {
		return idexam_type;
	}

	public void setIdexam_type(int idexam_type) {
		this.idexam_type = idexam_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}
