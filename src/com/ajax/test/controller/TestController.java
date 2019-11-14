package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.AddressService;
import com.ajax.test.service.Impl.AddressServiceImpl;
import com.google.gson.Gson;

@WebServlet(name="/TestController",urlPatterns={"/test/*"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressService as = new AddressServiceImpl();
	private Gson gs = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		List<Map<String,String>>  adList = as.selectSidoList(null);
		pw.print(gs.toJson(adList));
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static void main(String[] args) {
		AddressService as = new AddressServiceImpl();
		Gson gs = new Gson();
		List<Map<String,String>>  adList = as.selectSidoList(null);
		System.out.println(gs.toJson(adList));
	}
	
}
