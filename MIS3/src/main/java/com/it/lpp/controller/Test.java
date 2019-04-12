package com.it.lpp.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Test {
	private static int hours;
	private static int minutes;
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		String format = simpleDateFormat.format(date);
	
		System.out.println(format);
		String[][] zero = new String[][] { { " ", "-", "-", " " }, { "|", " ", " ", "|" }, { " ", " ", " ", " " },
				{ "|", " ", " ", "|" }, { " ", "-", "-", " " }, };
		String[][] one = new String[][] { { " ", " ", " ", " " }, { "|", " ", " ", " " }, { " ", " ", " ", " " },
				{ "|", " ", " ", " " }, { " ", " ", " ", " " }, };
		String[][] two = new String[][] { { " ", "-", "-", " " }, { " ", " ", " ", "|" }, { " ", "-", "-", " " },
				{ "|", " ", " ", " " }, { " ", "-", "-", " " }, };
		String[][] three = new String[][] { { " ", "-", "-", " " }, { " ", " ", " ", "|" }, { " ", "-", "-", " " },
				{ " ", " ", " ", "|" }, { " ", "-", "-", " " }, };
		String[][] four = new String[][] { { " ", " ", " ", " " }, { "|", " ", " ", "|" }, { " ", "-", "-", " " },
				{ " ", " ", " ", "|" }, { " ", " ", " ", " " }, };
		String[][] five = new String[][] { { " ", "-", "-", " " }, { "|", " ", " ", " " }, { " ", "-", "-", " " },
				{ " ", " ", " ", "|" }, { " ", "-", "-", " " }, };
		String[][] six = new String[][] { { " ", "-", "-", " " }, { "|", " ", " ", " " }, { " ", "-", "-", " " },
				{ "|", " ", " ", "|" }, { " ", "-", "-", " " }, };
		String[][] seven = new String[][] { { " ", "-", "-", " " }, { " ", " ", " ", "|" }, { " ", " ", " ", " " },
				{ " ", " ", " ", "|" }, { " ", " ", " ", " " }, };
		String[][] eight = new String[][] { { " ", "-", "-", " " }, { "|", " ", " ", "|" }, { " ", "-", "-", " " },
				{ "|", " ", " ", "|" }, { " ", "-", "-", " " }, };
		String[][] nine = new String[][] { { " ", "-", "-", " " }, { "|", " ", " ", "|" }, { " ", "-", "-", " " },
				{ " ", " ", " ", "|" }, { " ", "-", "-", " " }, };
		String[][] split = new String[][] { { " ", " ", " ", " " }, { " ", ".", " ", " " }, { " ", " ", " ", " " },
				{ " ", ".", " ", " " }, { " ", " ", " ", " " }, };
		Map<String, String[][]> list = new HashMap<>();
		list.put("0", zero);list.put("1", one);list.put("2", two);list.put("3", three);list.put("4", four);list.put("5", five);
		list.put("6", six);list.put("7", seven);list.put("8", eight);list.put("9", nine);list.put(":", split);
		boolean flag = false;
		// 循环5次 每次打印一行
		for (int time = 0; time < 5; time++) {
			// 取出当前时间的字符
			for (int i = 0; i < format.length(); i++) {
				// 取出第一个字符
				char charAt = format.charAt(i);
				String charat = String.valueOf(charAt);
				// 取出对应的库
				String[][] strings = list.get(charat);
				for (int j = 0; j < strings[time].length; j++) {
					System.out.print(strings[time][j]);
				}
			}
			System.out.println();
		}
	}
}
