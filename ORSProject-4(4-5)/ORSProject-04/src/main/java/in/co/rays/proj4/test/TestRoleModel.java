package in.co.rays.proj4.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;

public class TestRoleModel {

	public static void main(String[] args) throws SQLException, DuplicateRecordException {
//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
//		testFindByPk();
//		testFindByName();
	}

	private static void testFindByName() {
		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		bean = model.findByName("faculty");
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getName());
		System.out.print("\t" + bean.getDescription());
		System.out.print("\t" + bean.getCreatedBy());
		System.out.print("\t" + bean.getModifiedBy());
		System.out.print("\t" + bean.getCreatedDatetime());
		System.out.println("\t" + bean.getModifiedDatetime());
	}

	private static void testFindByPk() {

		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		bean = model.findByPk(2);
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getName());
		System.out.print("\t" + bean.getDescription());
		System.out.print("\t" + bean.getCreatedBy());
		System.out.print("\t" + bean.getModifiedBy());
		System.out.print("\t" + bean.getCreatedDatetime());
		System.out.println("\t" + bean.getModifiedDatetime());

	}

	private static void testSearch() {

		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();
		// bean.setName("admin");
		List list = model.search(bean, 3, 2);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (RoleBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		}

	}

	private static void testDelete() throws SQLException {
		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		bean.setId(1);
		model.delete(bean);

	}

	private static void testUpdate() throws SQLException {
		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		bean.setId(2);
		bean.setName("student");
		bean.setDescription("student");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);

	}

	private static void testAdd() throws SQLException, DuplicateRecordException {

		RoleModel model = new RoleModel();

		RoleBean bean = new RoleBean();
		bean.setName("kiosk");
		bean.setDescription("kiosk");
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
