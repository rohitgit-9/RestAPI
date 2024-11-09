package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.entity.Students;

public interface StudentService {

	public void saveStudent(Students u);

	public Optional<Students> GetStudentByID(int id);

	public List<Students> getAllStudents();
	
	public void DeleteById(int id);
	
	public void UpdateUser(Students student);
}
