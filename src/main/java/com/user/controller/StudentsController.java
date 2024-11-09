package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.dao.StudentsRecordsDao;
import com.user.entity.Students;
import com.user.entity.StudentsRecord;
import com.user.service.CustomStudentService;
import com.user.service.StudentService;

@RestController
public class StudentsController {

	@Autowired
	StudentService service;

	@Autowired
	StudentsRecordsDao daos;

	@Autowired
	CustomStudentService cservice;

	@PostMapping("/saveuser")
	public ResponseEntity<HttpStatus> SaveUser(@RequestBody Students s) {

		service.saveStudent(s);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PutMapping("/updateUser")
	public ResponseEntity<HttpStatus> UpdateUser(@RequestBody Students s) {

		service.UpdateUser(s);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {

//		service.saveStudent(s);

		service.DeleteById(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/liststudentd")
	public ResponseEntity<List<Students>> students() {

		List<Students> allStudents = service.getAllStudents();

		return new ResponseEntity<List<Students>>(allStudents, HttpStatus.OK);
	}

	@GetMapping("/liststudentd/{id}")
	public ResponseEntity<Optional<Students>> getStudent(@PathVariable("id") int id) {

//		List<Students> allStudents = service();
		Optional<Students> getStudentByID = service.GetStudentByID(id);
//		return new ResponseEntity<List<Students>>(allStudents, HttpStatus.OK);

		return new ResponseEntity<Optional<Students>>(getStudentByID, HttpStatus.OK);
	}

	@GetMapping("/liststudentd1/{id}")
	public ResponseEntity<Students> getStudentById(@PathVariable("id") int id) {

//		List<Students> allStudents = service();
//		Optional<Students> getStudentByID = service.GetStudentByID(id);
//		return new ResponseEntity<List<Students>>(allStudents, HttpStatus.OK);

//		return new ResponseEntity<Optional<Students>>(getStudentByID, HttpStatus.OK);

		return new ResponseEntity<Students>(cservice.getStudentById(id), HttpStatus.OK);
	}

	@PostMapping("/saveusernew")
	public ResponseEntity<Students> saveUsernew(@RequestBody Students s) {

		return new ResponseEntity<Students>(cservice.createCustomUser(s), HttpStatus.OK);
	}

	@PostMapping("/saveStudent")
	@ResponseStatus(HttpStatus.CREATED)
	public StudentsRecord saveStudent(@RequestBody StudentsRecord s) {
//		

		StudentsRecord s1 = new StudentsRecord(s.id(), s.name());
		daos.save(s1);
		return s;
	}
}
