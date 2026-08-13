package in.co.rays.proj4.model;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.exception.DuplicateRecordException;

public abstract class BaseModel<T extends BaseBean> {

	public abstract int add() throws DuplicateRecordException;

	public abstract void update() throws DuplicateRecordException;

	public abstract BaseBean findByUniqueColumn();

	public abstract String getWhereClouse();

	public abstract T getBean();

}
