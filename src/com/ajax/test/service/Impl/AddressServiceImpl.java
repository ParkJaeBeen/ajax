package com.ajax.test.service.Impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.dao.AddressDAO;
import com.ajax.test.dao.Impl.AddressDAOImpl;
import com.ajax.test.service.AddressService;

public class AddressServiceImpl implements AddressService {
	private AddressDAO ad  = new AddressDAOImpl();
	@Override
	public List<Map<String, String>> selectSidoList(List<Map<String, String>> sido) {
		return ad.selectSidoList(sido);
	}

	@Override
	public Map<String, String> selectSido(Map<String, String> sido) {
		return null;
	}
	
	public static void main(String[] args) {
		AddressService as = new AddressServiceImpl();
		System.out.println(as.selectSidoList(null));
	}
}
