package com.sapient.UseCaseBasedProblems.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UC08_Sort_HashMap_By_Values {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Abhi", 1);
		map.put("Malay", 6);
		map.put("Riteeka", 3);
		map.put("Chintan", 4);
		map.put("Ankit", 2);
		map.put("Rajvi", 7);
		map.put("Monika", 5);

		System.out.println(sortHashMapJava7(map));
		System.out.println("---------------");
		System.out.println(sortHashMapJava8(map));

	}

	public static String sortHashMapJava7(HashMap<String, Integer> map) {

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

				return o1.getValue().compareTo(o2.getValue());
			}

		});

		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> e : list) {
			sb.append(e.getKey() + "=" + e.getValue() + "\n");
		}
		return sb.toString();

	}

	public static String sortHashMapJava8(HashMap<String, Integer> map) {
		StringBuilder sb = new StringBuilder();
		map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue())
				.forEach(e -> sb.append(e.getKey() + "=" + e.getValue() + "\n"));

		return sb.toString();
	}
}
