package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.user.NoSuchUserException;
import com.user.NoUserFound;
import com.user.dao.StudentDao;
import com.user.entity.Students;

@Service
public class CustomStudentServiceImpl implements CustomStudentService {

	@Autowired
	StudentDao dao;

//	StudentRepo
	@Override
	public Students getStudentById(int id) {
		// TODO Auto-generated method stub
		Students orElseThrow = dao.findById(id).orElseThrow(() -> new NoSuchUserException("user not found"));
		return orElseThrow;
	}

	@Override
	public Students createCustomUser(Students u) {

//		dao.findById(u.getId())
		ModelMap l;
//		l.m
		Students orElse = dao.findByName(u.getName()).orElse(null);

		if (orElse == null) {

			Students save = dao.save(u);

			return save;

		} else {
			throw new NoUserFound("user already exist");
		}

		// TODO Auto-generated method stub
//		return null;
	}

}
