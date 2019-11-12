package com.ajax.test.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.DAO.BoardDAO;
import com.ajax.test.common.DBCon;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBCon.getCon();
			String sql = "select * from board_table bt,USER_TABLE ut ";
			sql += " where bt.ut_num = ut.ut_num ";
			sql += " and bt_num=?";
			sql += " order by bt_num desc";
			ps = con.prepareStatement(sql);
			ps.setString(1,board.get("bt_num"));
			rs = ps.executeQuery();
			if(rs.next()) 
			{
				Map<String, String> b = new HashMap<>();
				b.put("bt_num", rs.getString("bt_num"));
				b.put("bt_title",rs.getString("bt_title"));
				b.put("bt_content",rs.getString("bt_content"));
				b.put("ut_num",rs.getString("ut_num"));
				b.put("ut_name",rs.getString("ut_name"));
				b.put("credat",rs.getString("credat"));
				b.put("cretim",rs.getString("cretim"));
				b.put("moddat",rs.getString("moddat"));
				b.put("modtim",rs.getString("modtim"));
				return b;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBCon.getCon();
			String sql = "select * from Board_table order by bt_num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String, String>> bList = new ArrayList<>();
			while(rs.next()) 
			{
				Map<String, String> b = new HashMap<>();
				b.put("bt_num", rs.getString("bt_num"));
				b.put("bt_title",rs.getString("bt_title"));
				b.put("credat",rs.getString("credat"));
				b.put("cretim",rs.getString("cretim"));
				bList.add(b);
			}
			return bList;
		} catch (SQLException e) {

		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int insertBoard(Map<String, String> board) {
		Connection con = null;
		PreparedStatement ps = null;
	
		try {
			con = DBCon.getCon();
			String sql = "insert into Board_table(bt_num,bt_title,bt_content,ut_num,credat,cretim,moddat,modtim)";
			sql += "values(seq_bt_num.nextval,?,?,?,to_char(sysdate,'YYYY-MM-DD'),to_char(sysdate,'HH24:MI:SS'),to_char(sysdate,'YYYY-MM-DD'),to_char(sysdate,'HH24:MI:SS'))";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("bt_title"));
			ps.setString(2, board.get("bt_content"));
			ps.setString(3, board.get("ut_num"));
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int updateBoard(Map<String, String> board) {
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String> board) {
		return 0;
	}
	
	public static void main(String[] args) 
	{
		BoardDAO bd = new BoardDAOImpl();
		System.out.println(bd.selectBoardList(null));
	}

}
