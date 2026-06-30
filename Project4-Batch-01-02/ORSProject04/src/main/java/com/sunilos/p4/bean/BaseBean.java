package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public abstract class BaseBean {

	protected long id;
	protected String createdBy;
	protected String modifiedBy;
	protected Timestamp createdDatetime;
	protected Timestamp modifiedDatetime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	public void setResultset(ResultSet rs) {
		try {
			this.setId(rs.getLong("ID"));
			this.setCreatedBy(rs.getString("CREATED_BY"));
			this.setModifiedBy(rs.getString("MODIFIED_BY"));
			this.setCreatedDatetime(rs.getTimestamp("CREATED_DATETIME"));
			this.setModifiedDatetime(rs.getTimestamp("MODIFIED_DATETIME"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}