package com.it.lpp.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	static List<Integer> list = new LinkedList<>();

	public static void main(String[] args) {

		int a[] = { 2, 2, 1, 4, 3, 4, 5 };
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		list.sort(null);
		Collections.reverse(list);

		for (int i : list) {
			System.out.println(i);
		}
	}

	public static void addElement(int element) {
		int i = 0;
		for (; i < list.size(); i++) {
			if (element <= list.get(i)) {
				break;
			}
		}
		list.add(i, element);
	}

}
