package com.ajax.test.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.common.DBCon;
import com.ajax.test.dao.ColorDAO;

public class ColorDAOImpl implements ColorDAO {

	@Override
	public List<String> selectColorList(List<String> color) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from color ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<String> cList = new ArrayList<>();
			while(rs.next()) {
				cList.add(rs.getString("c_color"));
			}
			return cList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return null;		
	}

}
