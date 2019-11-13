package com.ajax.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.BoardService;
import com.ajax.test.service.Impl.BoardServiceImpl;
import com.google.gson.Gson;


@WebServlet(name="BoardController", urlPatterns= {"/ajax/board/*","/jsp/board/*"},loadOnStartup = 1)
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
	private Gson gs = new Gson();
    
//	public BoardController()  
//	{
//		System.out.println("1.보드컨트롤러의 생성자");
//	}
//	public void init()
//	{
//		System.out.println("2.생성자 호출 뒤에 반드시 실행");
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3.get방식이 일어날 때마다 호출");
		String kind = request.getRequestURI().substring(1,4);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		System.out.println(kind);
		if("aja".equals(kind))
		{
			String cmd = request.getParameter("cmd");
			if("list".equals(cmd))
			{
				List<Map<String,String>> bl = bs.selectBoardList(null);
				pw.print(gs.toJson(bl));
			}
			else if("content".equals(cmd))
			{
				System.out.println(cmd);
				Map<String,String> nm = new HashMap<>();
				nm.put("bt_num", request.getParameter("bt_num"));
				Map<String,String> bm = bs.selectBoard(nm);
				pw.print(gs.toJson(bm));
			}
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
		String str = null;
		String json = "";
		while((str=br.readLine())!=null)
		{
			System.out.println(str);
			json += str;
		}
		Map<String,String> param = gs.fromJson(json, Map.class);
		response.setContentType("application/json;charset=utf-8");
		json = gs.toJson(bs.insertBoard(param));
		response.getWriter().print(json);
		System.out.println(param);
	}
 
}
