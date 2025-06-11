package in.co.rays.proj4.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws SQLException {
		// testNextPk();
		testAdd();
	}

	private static void testAdd() throws SQLException {

		RoleModel model = new RoleModel();

		RoleBean bean = new RoleBean();
		bean.setName("admin");
		bean.setDescription("admin has full access of application");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testNextPk() {

		RoleModel model = new RoleModel();
		int id = model.nextPk();
		System.out.println("next pk: " + id);

	}

}
