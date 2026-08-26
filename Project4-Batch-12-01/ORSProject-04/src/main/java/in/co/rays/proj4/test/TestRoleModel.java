package in.co.rays.proj4.test;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) {
		testAdd();
//		testDelete();
//		testFindByPk();
//		testFindByName();
	}

	public static void testAdd() {

	}

	public static void testDelete() {
		RoleModel model = new RoleModel();

		model.delete(1);
	}

	public static void testFindByPk() {

		RoleModel model = new RoleModel();

		RoleBean bean = new RoleBean();

		bean = model.findByPK(2);

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());

	}
	
	public static void testFindByName() {

		RoleModel model = new RoleModel();

		RoleBean bean = new RoleBean();

		bean = model.findByName("Student");

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());

	}

}
