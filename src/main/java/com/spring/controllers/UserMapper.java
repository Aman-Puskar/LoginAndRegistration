package com.spring.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserDetailMapper> {

	@Override
	public UserDetailMapper mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetailMapper udm = new UserDetailMapper();
		udm.setName(rs.getString("name"));
		udm.setEmail(rs.getString("email"));
		udm.setCity(rs.getString("city"));
		return udm;
	}
}
