package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.AddressService;
import com.ajax.test.service.ColorService;
import com.ajax.test.service.Impl.AddressServiceImpl;
import com.ajax.test.service.Impl.ColorServiceImpl;
import com.google.gson.Gson;

@WebServlet(name="/ListController",urlPatterns= {"/list/*"})
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gs = new Gson();
	private ColorService cs = new ColorServiceImpl();
	private AddressService as = new AddressServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		List<String>  csList = cs.selectColorList(null);
		
		List<String> tmpList = new ArrayList<>();
		String id = request.getParameter("id");
		if(id==null) {
			pw.print(gs.toJson(csList));
			return;
		}
		
		for(int i=0;i<csList.size();i++) {
			if(csList.get(i).indexOf(id)!=-1)
			{ 
				tmpList.add(csList.get(i));
			}
		}
		pw.print(gs.toJson(tmpList));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
