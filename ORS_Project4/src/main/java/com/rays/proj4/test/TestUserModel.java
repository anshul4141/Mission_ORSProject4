package com.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rays.proj4.bean.UserBean;
import com.rays.proj4.model.UserModel;

public class TestUserModel {

	static UserModel model = new UserModel();

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Kapil");
		bean.setLastName("Malviya");
		bean.setLogin("kmalviya30@gmail.com");
		bean.setPassword("kapil@123");
		bean.setDob(sdf.parse("05-07-1997"));
		bean.setRoleId(1L);
		bean.setGender("Male");
		bean.setMobileNo("9407411301");
		bean.setConfirmPassword("kapil@123");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		UserModel model = new UserModel();

		model.add(bean);

	}

}
