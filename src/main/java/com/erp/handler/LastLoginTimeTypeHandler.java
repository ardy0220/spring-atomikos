package com.erp.handler;

import com.erp.util.StringUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by wang_ on 2016-10-20.
 */
public class LastLoginTimeTypeHandler extends BaseTypeHandler<Date> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        java.sql.Date columnValue = resultSet.getDate(columnName);
        if (!StringUtil.isEmpty(columnValue)) {
            return new Date(columnValue.getTime());
        }
        return null;
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        java.sql.Date columnValue = resultSet.getDate(columnIndex);
        if (!StringUtil.isEmpty(columnValue)) {
            return new Date(columnValue.getTime());
        }
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        java.sql.Date columnValue = callableStatement.getDate(columnIndex);
        if (!StringUtil.isEmpty(columnValue)) {
            return new Date(columnValue.getTime());
        }
        return null;
    }
}
