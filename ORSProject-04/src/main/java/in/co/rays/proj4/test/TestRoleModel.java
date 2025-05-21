package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testFindByName();
//		testSearch();

	}

	private static void testNextPk() {

		RoleModel model = new RoleModel();

		int i = model.nextPk();

		System.out.println("nexPk is: " + i);

	}

	public static void testAdd() throws Exception {

		RoleBean bean = new RoleBean();
		bean.setName("student");
		bean.setDescription("student");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();

		model.add(bean);

	}

	private static void testUpdate() throws Exception {

		RoleBean bean = new RoleBean();
		bean.setId(1l);
		bean.setName("admin");
		bean.setDescription("admin has full access of application");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();

		model.update(bean);

	}

	private static void testDelete() throws Exception {

		RoleModel model = new RoleModel();

		model.delete(5l);

	}

	private static void testFindByPk() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean = model.findByPk(3l);

		if (bean != null) {

			System.out.print(bean.getName());
			System.out.println("\t" + bean.getDescription());

		}

	}

	private static void testFindByName() throws Exception {

		RoleBean bean = new RoleBean();
		RoleModel model = new RoleModel();

		bean = model.findByName("student");

		if (bean != null) {

			System.out.print(bean.getName());
			System.out.println("\t" + bean.getDescription());

		}

	}

//	private static void testSearch() throws Exception {
//
//		RoleModel model = new RoleModel();
//		RoleBean bean = new RoleBean();
//		
//		//bean.setName("student");
//		bean.setModifiedBy("root");
//
//		List list = model.search(bean);
//
//		Iterator it = list.iterator();
//
//		while (it.hasNext()) {
//
//			bean = (RoleBean) it.next();
//			System.out.print(bean.getId());
//			System.out.print("\t" + bean.getName());
//			System.out.print("\t" + bean.getDescription());
//			System.out.print("\t" + bean.getModifiedBy());
//			System.out.print("\t" + bean.getCreatedBy());
//			System.out.print("\t" + bean.getCreatedDatetime());
//			System.out.println(bean.getModifiedDatetime());
//
//		}
//
//	}

}
