package com.kshrd.registration.exception;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/** NOT USE */
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType)
            throws SQLException {
        preparedStatement.setString(i, StringUtils.join(strings, ","));
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return convert(resultSet.getString(s));
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return convert(resultSet.getString(i));
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return convert(callableStatement.getString(i));
    }

    /**
     * 将查询值转换为数组
     *
     * @param value 查询值, String
     * @return 转换结果, String[]
     */
    private String[] convert(String value) {
        return StringUtils.isEmpty(value) ? new String[0] : value.split(",");
    }

}

