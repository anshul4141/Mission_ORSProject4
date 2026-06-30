package com.sunilos.p4.test;

import java.sql.Timestamp;
import java.util.Date;

import com.sunilos.p4.bean.RoleBean;
import com.sunilos.p4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) {

		add();

	}

	private static void add() {
		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		bean.setName("demo");
		bean.setDescription("demo");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

}
