package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {

//		testNextPk();
//		testAdd();
//		testDelete();
//		testUpdate();
//		testFindByPk();
//		testFindByName();
		testSearch();

	}

	private static void testNextPk() {

		RoleModel model = new RoleModel();

		int i = model.nextPk();

		System.out.println("nexPk is: " + i);

	}

	public static void testAdd() throws Exception {

		RoleBean bean = new RoleBean();
		bean.setName("kiosk");
		bean.setDescription("kiosk");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		RoleBean bean = new RoleBean();
		bean.setId(2);
		bean.setName("student");
		bean.setDescription("student");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();

		model.update(bean);
	}

	public static void testDelete() throws Exception {
		RoleModel model = new RoleModel();
		model.delete(1);
	}

	public static void testFindByPk() throws Exception {

		RoleModel model = new RoleModel();

		RoleBean bean = model.findByPk(1);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("id not found");
		}
	}

	public static void testFindByName() throws Exception {

		RoleModel model = new RoleModel();

		RoleBean bean = model.findByName("admin");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			System.out.println("name not found");
		}
	}

	public static void testSearch() throws Exception {

		RoleBean bean = new RoleBean();

		RoleModel model = new RoleModel();

		List list = model.search(bean, 1, 10);

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

}
