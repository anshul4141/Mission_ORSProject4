package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;

//1 = admin
//2 = student
//3 = faculty
//4 = college
//5 = KIOSK
public class TestRoleModel {

	public static RoleModel model = new RoleModel();

	public static void main(String[] args) {
//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
		testSearch();
	}

	private static void testAdd() {
		RoleBean bean = new RoleBean();

		bean.setName("admin");
		bean.setDescription("admin role");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testUpdate() {

		RoleBean bean = new RoleBean();

		bean.setId(1);
		bean.setName("admin");
		bean.setDescription("admin role");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testDelete() {

		model.delete(1);

	}

	private static void testFindByPk() {

		RoleBean bean = model.findByPk(1);

		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());

	}

	private static void testSearch() {

		RoleBean bean = new RoleBean();

//		bean.setName("student");

		List<RoleBean> list = model.search(bean, 1, 5);

		Iterator<RoleBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			System.out.println("--------------------");
		}

	}

}
