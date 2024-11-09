package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentsRecords")
public record StudentsRecord(@Id int id,String name) {
	public StudentsRecord()
	{
		 this(Integer.MIN_VALUE,"");

	}

}
