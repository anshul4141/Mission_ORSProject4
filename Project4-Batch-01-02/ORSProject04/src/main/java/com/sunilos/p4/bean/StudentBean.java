package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StudentBean extends BaseBean {

	public StudentBean() {
	}

	private String firstName;
	private String lastName;
	private Date dob;
	private String mobileNo;
	private String email;
	private long collegeId;
	private String collegeName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setCollegeId(rs.getLong(2));
			this.setCollegeName(rs.getString(3));
			this.setFirstName(rs.getString(4));
			this.setLastName(rs.getString(5));
			this.setDob(rs.getDate(6));
			this.setMobileNo(rs.getString(7));
			this.setEmail(rs.getString(8));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
