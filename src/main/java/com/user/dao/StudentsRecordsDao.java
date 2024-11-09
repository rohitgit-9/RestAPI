package com.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.StudentsRecord;

@Repository
public interface StudentsRecordsDao extends JpaRepository<StudentsRecord, Integer> {

}
