package com.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;

import com.rays.proj4.bean.RoleBean;
import com.rays.proj4.model.RoleModel;

public class TestRoleModel {

	static RoleModel model = new RoleModel();

	public static void main(String[] args) throws Exception {
		testAdd();
	}

	public static void testAdd() throws Exception {

		RoleBean bean = new RoleBean();

		bean.setName("faculty");
		bean.setDescription("faculty");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		long id = model.add(bean);
		System.out.println("record inserted at: " + id);

	}

}
