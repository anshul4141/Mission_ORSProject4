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

	// common methods =====>

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

	public void delete(int id) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM " + getTable() + " WHERE ID = ?");

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			conn.commit(); // End transaction
			System.out.println("data delete successfully");
			pstmt.close();

		} catch (SQLException e) {
			JDBCDataSource.rollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public T findByPk(long pk) throws ApplicationException {

		Connection conn = null;
		T bean = null;

		try {

			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + getTable() + " WHERE id = ?");
			pstmt.setLong(1, pk);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = getBean();
				bean.setResultset(rs);
			}

		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in getting User by pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
	}

	public T findByUniqueColumn(String column, String value) {
		Connection conn = null;
		T bean = null;

		try {

			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT * FROM " + getTable() + " WHERE " + column + "  = ?");
			pstmt.setString(1, value);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = getBean();
				bean.setResultset(rs);
			}

		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in getting User by pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
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

	// abstract methods =======>

	public abstract long add(T bean) throws ApplicationException, DuplicateRecordException;

	public abstract void update(T bean) throws ApplicationException, DuplicateRecordException;

	public abstract String getWhereClause(T bean);

	public abstract T getBean();

	public abstract String getTable();

}
