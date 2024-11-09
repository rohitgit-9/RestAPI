package com.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.Students;

@Repository
public interface StudentDao extends JpaRepository<Students, Integer> {

	Optional<Students>  findByName(String name);
}
