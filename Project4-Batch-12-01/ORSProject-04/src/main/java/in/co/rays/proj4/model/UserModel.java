package in.co.rays.proj4.model;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;

public class UserModel extends BaseModel<UserBean> {

	@Override
	public long add(UserBean bean) throws ApplicationException, DuplicateRecordException {
		return 0;
	}

	@Override
	public void update(UserBean bean) throws ApplicationException, DuplicateRecordException {
		
	}

	@Override
	public String getWhereClause(UserBean bean) {
		return null;
	}

	@Override
	public String getTable() {
		return null;
	}

	@Override
	public UserBean getBean() {
		return null;
	}

}
