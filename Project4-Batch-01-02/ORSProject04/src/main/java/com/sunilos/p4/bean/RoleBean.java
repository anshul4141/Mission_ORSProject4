package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleBean extends BaseBean {

	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		try {
			this.setName(rs.getString("NAME"));
			this.setDescription(rs.getString("DESCRIPTION"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
