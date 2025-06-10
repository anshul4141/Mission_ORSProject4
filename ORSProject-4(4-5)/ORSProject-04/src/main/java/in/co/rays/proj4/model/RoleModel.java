package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.proj4.util.JDBCDataSource;

public class RoleModel {

	public int nextPk() {

		int pk = 0;

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
				System.out.println("max id: " + pk);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return pk + 1;

	}

}
