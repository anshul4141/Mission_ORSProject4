package com.sunilos.p4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.sunilos.p4.bean.RoleBean;
import com.sunilos.p4.exception.RecordNotFoundException;
import com.sunilos.p4.model.RoleModel;

public class TestRoleModel {

	public static void main(String[] args) {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testFindByName();
		testSearch();

	}

	private static void testAdd() {
		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		bean.setName("Admin");
		bean.setDescription("Admin");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.add(bean);
	}

	private static void testUpdate() {

		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		bean.setId(1);
		bean.setName("Admin");
		bean.setDescription("Admin role");
		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testDelete() {
		RoleModel model = new RoleModel();
		model.delete(5);
	}

	private static void testFindByPk() {

		RoleBean bean = new RoleBean();

		RoleModel model = new RoleModel();

		bean = model.findByPk(4l);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			throw new RecordNotFoundException("record not found");
		}

	}

	private static void testFindByName() {
		RoleBean bean = new RoleBean();

		RoleModel model = new RoleModel();

		bean = model.findByName("demo");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDatetime());
			System.out.println("\t" + bean.getModifiedDatetime());
		} else {
			throw new RecordNotFoundException("record not found");
		}

	}

	private static void testSearch() {

		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		bean.setName("Student");

		List<RoleBean> list = model.search(bean, 1, 2);

		Iterator<RoleBean> it = list.iterator();

		if (list.size() == 0) {
			System.out.println("record not found");
			return;
		}

		while (it.hasNext()) {
			bean = it.next();
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
