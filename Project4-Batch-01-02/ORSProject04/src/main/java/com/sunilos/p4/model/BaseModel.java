package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sunilos.p4.bean.BaseBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DatabaseException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public abstract class BaseModel<T extends BaseBean> {

	public abstract long add(T bean) throws ApplicationException, DuplicateRecordException;

	public abstract void update(T bean) throws ApplicationException, DuplicateRecordException;

	public Integer nextPk() throws DatabaseException {

		int pk = 0;

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM " + getTable());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			throw new DatabaseException("Exception : Exception in getting PK");
		} finally {
			// conn.close();
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}

	public void delete(int id) {

	}

	public T findByPk(long pk) {
		return null;
	}

	public T findByUniqueColumn(String column, String value) {
		return null;
	}

	public List<T> search(T bean, int pageNo, int pageSize) {
		return null;
	}

	public List search(T bean) {
		return search(bean, 0, 0);
	}

	public List<T> list(int pageNo, int pageSize) {
		return null;
	}

	public List list() {
		return list(0, 0);
	}

	public abstract String getWhereClause(T bean);

	public abstract T getBean();

	public abstract String getTable();

}
