package in.co.rays.proj4.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;

public class TestUserModel {

	public static void main(String[] args) {
		testSearch();
	}

	public static void testSearch() {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		bean.setFirstName("virat");

		List<UserBean> list = model.search(bean, 1, 5);

		Iterator<UserBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println("----------------");
		}

	}

}
