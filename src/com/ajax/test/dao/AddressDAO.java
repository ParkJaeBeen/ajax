package com.ajax.test.dao;

import java.util.List;
import java.util.Map;

public interface AddressDAO 
{
	public List<Map<String,String>> selectSidoList(List<Map<String,String>> sido);
	public Map<String,String> selectSido(Map<String,String> sido);
}
