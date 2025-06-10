package in.co.rays.proj4.test;

import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) {
		testNextPk();
	}

	private static void testNextPk() {

		RoleModel model = new RoleModel();
		int id = model.nextPk();
		System.out.println("next pk: " + id);

	}

}
