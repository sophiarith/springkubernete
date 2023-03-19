package com.kshrd.registration.exception;

import com.alibaba.fastjson2.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@MappedTypes({Object.class})
public class JsonObjectTypeHandler<T extends Object> extends BaseTypeHandler<T> {

    private Class<T>  clazz;

    public JsonObjectTypeHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    public JsonObjectTypeHandler() {
    }

    private static final PGobject jsonObject = new PGobject();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if(ps != null){
            jsonObject.setType("json");
            jsonObject.setValue(JSON.toJSONString(parameter));
            ps.setObject(i, jsonObject);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return JSON.parseObject(rs.getString(columnName), clazz);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return JSON.parseObject(rs.getString(columnIndex), clazz);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return JSON.parseObject(cs.getString(columnIndex), clazz);
    }
}
