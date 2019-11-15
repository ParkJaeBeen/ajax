package com.ajax.test.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest 
{
	public static void main(String[] args)
	{
		List<String> strList = new ArrayList<>();
		strList.add("가나다");
		strList.add("나다");
		strList.add("가다");
		strList.add("오라");
//		List<String> ml = new ArrayList<>();
		String search = "가";
		
		for(int i=0;i<strList.size();i++)
		{
			if(strList.get(i).indexOf(search)==-1)
			{
				strList.remove(i);
			}
		}
		
		System.out.println(strList);
	}
}
