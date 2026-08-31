package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class SubjectModel extends BaseModel<SubjectBean> {

	@Override
	public long add(SubjectBean bean) throws ApplicationException, DuplicateRecordException {

		String colums = "ID,NAME, DESCRIPTION, COURSE_ID";
		String values = "?,?,?,?";

		StringBuffer sql = new StringBuffer("INSERT INTO " + getTable());
		sql.append("(CREATED_DATETIME,MODIFIED_DATETIME,CREATED_BY,MODIFIED_BY, " + colums + ")");
		sql.append(" VALUES(NOW(),NOW(),'root@sunilos.com','root@sunilos.com'," + values + " )");

		Connection conn = null;
		int pk = 0;
		SubjectBean existBean = findByName(bean.getName());

		if (existBean != null) {
			throw new DuplicateRecordException("subject already exist");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction

			pk = nextPK();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setLong(4, bean.getCourseId());
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
	public void update(SubjectBean bean) throws ApplicationException, DuplicateRecordException {

		String sql = "UPDATE " + getTable() + " SET NAME=?,DESCRIPTION=?,COURSE_ID=? WHERE ID=?";
		Connection conn = null;
		SubjectBean existBean = findByName(bean.getName());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("subject already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDescription());
			pstmt.setLong(3, bean.getCourseId());
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

	public SubjectBean findByName(String name) throws ApplicationException {
		SubjectBean bean = findByUniqueColumn("NAME", name);
		return bean;
	}

	@Override
	public String getWhereClause(SubjectBean bean) {
		return null;
	}

	@Override
	public String getTable() {
		return "ST_SUBJECT";
	}

	@Override
	public SubjectBean getBean() {
		return new SubjectBean();
	}
}
