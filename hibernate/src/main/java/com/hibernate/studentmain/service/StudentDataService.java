package com.hibernate.studentmain.service;

import java.util.List;



import com.hibernate.model.StudentRequest;
import com.hibernate.model.StudentResponse;
import com.hibernate.studentmain.entity.StudentEntity;

public interface StudentDataService {
	
	public StudentResponse addDetails(StudentRequest request);
	
	public List<StudentEntity> getAllDetails();
	
	public StudentEntity getOneRecord(StudentRequest studentRequest);
	
	public StudentResponse updateDetails(StudentRequest studentRequest);
	
	public StudentResponse deleteDetails(StudentRequest studentRequest);

}
