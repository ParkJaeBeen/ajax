package com.ajax.test.service.Impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.dao.ColorDAO;
import com.ajax.test.service.ColorService;

public class ColorServiceImpl implements ColorService {
	private ColorDAO cd = new ColorDAOImpl();
	@Override
	public List<String> selectColorList(List<String> color) {
		return cd.selectColorList(color);
	}

}
