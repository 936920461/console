package com.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class Main3 {

	public static void main(String[] args) {

		// String[] arr = new String[12];
		// String[] arr1 = { "1" };
		// List<String> list1 = Arrays.asList(arr1);
		// Arrays.asList转为数组的时候，并不是真正转为list，内部还是数组的，执行下面方法报错
		// list1.add("2");
		// List<String> list = new ArrayList<String>();
		// arr = (String[]) list.toArray();
		// int i=10;
		// for(int j=list.size();i<10;i++){
		//
		// }
		// list.forEach(x -> {
		//
		// });
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		// 不要在foreach循环里进行元素的remove/add操作
		// for (String temp : a) {
		// if ("2".equals(temp)) {
		// a.remove(temp);
		// }
		// }
		Iterator<String> iterator = a.iterator();
		while (iterator.hasNext()) {
			// iterator.next()返回值并指向下个元素
			String temp = iterator.next();
			if ("2".equals(temp)) {
				iterator.remove();
			}
		}
		a.forEach(l -> {
			System.out.println(l);
		});
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		HashSet<String> hSet = new HashSet<String>();
	
	}

}
