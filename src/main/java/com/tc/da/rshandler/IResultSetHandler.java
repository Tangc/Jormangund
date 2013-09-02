package com.tc.da.rshandler;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {

	public T handle(ResultSet rs);
}
