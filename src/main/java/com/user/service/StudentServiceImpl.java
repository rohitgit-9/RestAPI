package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.StudentDao;
import com.user.entity.Students;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;

	@Override
	public void saveStudent(Students u) {
		// TODO Auto-generated method stub

		dao.save(u);

	}

	@Override
	public Optional<Students> GetStudentByID(int id) {
		// TODO Auto-generated method stub

		Optional<Students> byId = dao.findById(id);

		Students s = null;
		if (byId.isPresent()) {
			s = byId.get();
			return Optional.ofNullable(s);
		} else {
			return Optional.ofNullable(new Students());

		}

	}

	@Override
	public List<Students> getAllStudents() {
		// TODO Auto-generated method stub
		List<Students> all = new ArrayList<>();
		try {
			all = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public void DeleteById(int id) {
		// TODO Auto-generated method stub

		try {
			dao.deleteById(id);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void UpdateUser(Students student) {
		// TODO Auto-generated method stub

		try {
			dao.save(student);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
