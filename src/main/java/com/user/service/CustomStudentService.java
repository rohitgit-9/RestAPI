package com.user.service;

import com.user.entity.Students;

public interface CustomStudentService {
	Students getStudentById(int id);

	
	Students createCustomUser(Students u);
}
