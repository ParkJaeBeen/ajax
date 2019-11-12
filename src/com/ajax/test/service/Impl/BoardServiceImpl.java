package com.ajax.test.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.DAO.BoardDAO;
import com.ajax.test.DAO.Impl.BoardDAOImpl;
import com.ajax.test.service.BoardService;

public class BoardServiceImpl implements BoardService {
	public BoardDAO bd = new BoardDAOImpl();
	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		return bd.selectBoard(board);
	}

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		return bd.selectBoardList(board);
	}

	@Override
	public Map<String, String> insertBoard(Map<String, String> board) {
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg", "저장 실패!");
		if(bd.insertBoard(board)==1) 
		{
			rMap.put("msg", "저장 성공!");
			rMap.put("url", "/views/ajax/list");
		}
		return rMap;
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
