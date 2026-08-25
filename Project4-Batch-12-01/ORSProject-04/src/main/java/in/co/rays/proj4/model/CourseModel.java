package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class CourseModel extends BaseModel<CourseBean> {

	@Override
	public long add(CourseBean bean) throws ApplicationException, DuplicateRecordException {

		String colums = "ID,NAME, DESCRIPTION, DURATION";
		String values = "?,?,?,?";

		StringBuffer sql = new StringBuffer("INSERT INTO " + getTable());
		sql.append("(CREATED_DATETIME,MODIFIED_DATETIME,CREATED_BY,MODIFIED_BY, " + colums + ")");
		sql.append(" VALUES(NOW(),NOW(),'root@sunilos.com','root@sunilos.com'," + values + " )");

		Connection conn = null;

		int pk = 0;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction

			pk = nextPK();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getDuration());
			pstmt.executeUpdate();

			conn.commit(); // End transaction
			pstmt.close();

		} catch (SQLException e) {
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	@Override
	public void update(CourseBean bean) throws ApplicationException, DuplicateRecordException {

		String sql = "UPDATE " + getTable() + " SET NAME=?,DESCRIPTION=?,DURATION=? WHERE ID=?";

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDescription());
			pstmt.setString(3, bean.getDuration());
			pstmt.setLong(4, bean.getId());
			pstmt.executeUpdate();

			conn.commit(); // End transaction
			pstmt.close();

		} catch (SQLException e) {
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	@Override
	public String getWhereClause(CourseBean bean) {
		return null;
	}

	@Override
	public String getTable() {
		return "ST_COURSE";
	}

	@Override
	public CourseBean getBean() {
		return new CourseBean();
	}
}
