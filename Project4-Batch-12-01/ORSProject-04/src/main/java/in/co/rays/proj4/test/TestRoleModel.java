package in.co.rays.proj4.test;

import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) {
//		testAdd();
		testDelete();
	}

	public static void testAdd() {

	}

	public static void testDelete() {
		RoleModel model = new RoleModel();

		model.delete(1);
	}

}
