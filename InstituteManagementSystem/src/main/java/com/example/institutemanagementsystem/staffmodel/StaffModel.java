package com.example.institutemanagementsystem.staffmodel;

import com.example.institutemanagementsystem.statff.StaffType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class StaffModel {

	private Long id;
	@Enumerated(EnumType.STRING)
	private StaffType staffType;
	private String name;
	private Long age;
	private Long phone;
	private String course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StaffType getStaffType() {
		return staffType;
	}

	public void setStaffType(StaffType staffType) {
		this.staffType = staffType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "StafEntity [id=" + id + ", staffType=" + staffType + ", name=" + name + ", age=" + age + ", phone="
				+ phone + ", course=" + course + "]";
	}

}
