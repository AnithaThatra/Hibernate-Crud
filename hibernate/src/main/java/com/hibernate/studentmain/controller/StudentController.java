package com.hibernate.studentmain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.model.StudentRequest;
import com.hibernate.model.StudentResponse;
import com.hibernate.studentmain.entity.StudentEntity;
import com.hibernate.studentmain.service.StudentDataService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StudentController {

	@Autowired
	StudentDataService studentDataService;

	@PostMapping("/addData")
	public StudentResponse createRecord(@RequestBody StudentRequest request) {
		System.out.println("StudentName:"+request.getStdname());
		StudentResponse response = studentDataService.addDetails(request);
		return response;

	}

	@GetMapping("/getAllData")
	public List<StudentEntity> getAllDetails() {
		List<StudentEntity> list = studentDataService.getAllDetails();
		return list;

	}

	@GetMapping("/getSingleData")
	public StudentEntity getOneRecord(@RequestBody StudentRequest studentRequest) {
		StudentEntity studentEntity = studentDataService.getOneRecord(studentRequest);
		return studentEntity;

	}

	@PutMapping("/updateData")
	public StudentResponse updateDetails(@RequestBody StudentRequest studentRequest) {
		StudentResponse studentResponse = studentDataService.updateDetails(studentRequest);
		return studentResponse;

	}

	@DeleteMapping("/deleteData")
	public StudentResponse deleteDetails(@RequestBody StudentRequest studentRequest) {
		StudentResponse studentResponse = studentDataService.deleteDetails(studentRequest);
		return studentResponse;

	}

}
