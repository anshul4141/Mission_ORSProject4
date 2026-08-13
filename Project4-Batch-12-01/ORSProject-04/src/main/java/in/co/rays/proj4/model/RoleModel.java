package in.co.rays.proj4.model;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.DuplicateRecordException;

public class RoleModel extends BaseModel<RoleBean> {

	@Override
	public int add() throws DuplicateRecordException {
		return 0;
	}

	@Override
	public void update() throws DuplicateRecordException {

	}

	@Override
	public BaseBean findByUniqueColumn() {
		return null;
	}

	@Override
	public String getWhereClouse() {
		return null;
	}

	@Override
	public RoleBean getBean() {
		return null;
	}

}
