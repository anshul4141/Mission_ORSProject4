package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class FacultyModel extends BaseModel<FacultyBean> {

	@Override
	public long add(FacultyBean bean) throws ApplicationException, DuplicateRecordException {

		int pk = 0;

		Connection conn = null;
		FacultyBean existBean = findByEmail(bean.getEmail());

		if (existBean != null) {
			throw new DuplicateRecordException("faculty already exist");
		}
		try {
			pk = nextPK();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO ST_FACULTY(ID,COLLEGE_ID,COLLEGE_NAME,FIRST_NAME,LAST_NAME,EMAIL,MOBILE_NO,ADDRESS,GENDER,DATE_OF_BIRTH,CREATED_BY,MODIFIED_BY,CREATED_DATETIME,MODIFIED_DATETIME)"
							+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,NOW(),NOW())");
			pstmt.setInt(1, pk);
			pstmt.setLong(2, bean.getCollegeId());
			pstmt.setString(3, bean.getCollegeName());
			pstmt.setString(4, bean.getFirstName());
			pstmt.setString(5, bean.getLastName());
			pstmt.setString(6, bean.getEmail());
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setString(8, bean.getAddress());
			pstmt.setString(9, bean.getGender());
			pstmt.setDate(10, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(11, bean.getCreatedBy());
			pstmt.setString(12, bean.getModifiedBy());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			JDBCDataSource.trnRollBack(conn);
			throw new ApplicationException("Exception in add Faculty");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	@Override
	public void update(FacultyBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		FacultyBean existBean = findByEmail(bean.getEmail());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("faculty already exist");
		}
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_FACULTY SET COLLEGE_ID=?,COLLEGE_NAME=?,FIRST_NAME=?,LAST_NAME=?,EMAIL=?,MOBILE_NO=?,ADDRESS=?,GENDER=?,DATE_OF_BIRTH=? WHERE ID=?");
			pstmt.setLong(1, bean.getCollegeId());
			pstmt.setString(2, bean.getCollegeName());
			pstmt.setString(3, bean.getFirstName());
			pstmt.setString(4, bean.getLastName());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setString(7, bean.getAddress());
			pstmt.setString(8, bean.getGender());
			pstmt.setDate(9, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setLong(10, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			JDBCDataSource.trnRollBack(conn);
			throw new ApplicationException("Exception in update Faculty");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public FacultyBean findByEmail(String email) throws ApplicationException {
		FacultyBean bean = findByUniqueColumn("EMAIL", email);
		return bean;
	}

	@Override
	public String getWhereClause(FacultyBean bean) {
		return null;
	}

	@Override
	public String getTable() {
		return "ST_FACULTY";
	}

	@Override
	public FacultyBean getBean() {
		return new FacultyBean();
	}
}
