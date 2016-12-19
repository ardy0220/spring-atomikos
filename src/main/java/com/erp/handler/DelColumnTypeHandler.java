package com.erp.handler;

import com.erp.util.StringUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wang_ on 2016-10-19.
 */
public class DelColumnTypeHandler extends BaseTypeHandler<Boolean> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        ps.setString(1, aBoolean.booleanValue() ? "1" : "0");
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        String columnValue = resultSet.getString(columnName);
        if (!StringUtil.isEmpty(columnValue)) {
            return "1".equals(columnValue) ? true : false;
        }
        return false;
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String columnValue = resultSet.getString(columnIndex);
        if (!StringUtil.isEmpty(columnValue)) {
            return "1".equals(columnValue) ? true : false;
        }
        return false;
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        String columnValue = callableStatement.getString(columnIndex);
        if (!StringUtil.isEmpty(columnValue)) {
            return "1".equals(columnValue) ? true : false;
        }
        return false;
    }
}
