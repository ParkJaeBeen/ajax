package com.ajax.test.service.Impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.DAO.BoardDAO;
import com.ajax.test.DAO.Impl.BoardDAOImpl;
import com.ajax.test.service.BoardService;

public class BoardServiceImpl implements BoardService {

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		return null;
	}

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		BoardDAO bd = new BoardDAOImpl();
		return bd.selectBoardList(board);
	}

	@Override
	public Map<String, String> insertBoard(Map<String, String> board) {
		return null;
	}

	@Override
	public Map<String, String> updateBoard(Map<String, String> board) {
		return null;
	}

	@Override
	public Map<String, String> deleteBoard(Map<String, String> board) {
		return null;
	}

}
