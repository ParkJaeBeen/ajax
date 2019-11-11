package com.ajax.test.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.BoardService;
import com.ajax.test.service.Impl.BoardServiceImpl;
import com.google.gson.Gson;


@WebServlet(name="/BoardController", urlPatterns= {"/ajax/board/*","/jsp/board/*"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
	private Gson gs = new Gson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getRequestURI().substring(1,4);
		List<Map<String,String>> bl = bs.selectBoardList(null);
		System.out.println(kind);
		if("aja".equals(kind))
		{
			response.setContentType("text/html;charset=utf-8");
			String json = gs.toJson(bl);
			response.getWriter().print(json);
			return;
		}
		else if("jsp".equals(kind))
		{
			request.setAttribute("list", bl);
			String path = "/views/jsp/list";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
 
}
