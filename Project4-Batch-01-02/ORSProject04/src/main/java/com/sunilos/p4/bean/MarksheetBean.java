package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksheetBean extends BaseBean {

	private String rollNo;
	private long studentId;
	private String name;
	private Integer physics;
	private Integer chemistry;
	private Integer maths;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Override
	public void setResultset(ResultSet rs) {

		try {
			super.setResultset(rs);
			this.setRollNo(rs.getString(2));
			this.setStudentId(rs.getLong(3));
			this.setName(rs.getString(4));
			this.setPhysics(rs.getInt(5));
			this.setChemistry(rs.getInt(6));
			this.setMaths(rs.getInt(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
