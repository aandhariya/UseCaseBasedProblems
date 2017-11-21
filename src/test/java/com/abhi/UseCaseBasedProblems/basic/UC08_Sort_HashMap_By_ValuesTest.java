package com.abhi.UseCaseBasedProblems.basic;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import com.abhi.UseCaseBasedProblems.basic.UC08_Sort_HashMap_By_Values;

public class UC08_Sort_HashMap_By_ValuesTest {

	@Test
	public void sortHashMapJava7Test() {

		HashMap<String, Integer> map = new HashMap<>();
		map.put("Abhi", 1);
		map.put("Malay", 6);
		map.put("Riteeka", 3);
		map.put("Chintan", 4);
		map.put("Ankit", 2);
		map.put("Rajvi", 7);
		map.put("Monika", 5);

		assertEquals(
				"Abhi=1\n" + "Ankit=2\n" + "Riteeka=3\n" + "Chintan=4\n" + "Monika=5\n" + "Malay=6\n" + "Rajvi=7\n",
				UC08_Sort_HashMap_By_Values.sortHashMapJava7(map));
	}

	@Test
	public void sortHashMapJava8Test() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Abhi", 1);
		map.put("Malay", 6);
		map.put("Riteeka", 3);
		map.put("Chintan", 4);
		map.put("Ankit", 2);
		map.put("Rajvi", 7);
		map.put("Monika", 5);

		assertEquals(
				"Abhi=1\n" + "Ankit=2\n" + "Riteeka=3\n" + "Chintan=4\n" + "Monika=5\n" + "Malay=6\n" + "Rajvi=7\n",
				UC08_Sort_HashMap_By_Values.sortHashMapJava8(map));
	}

}
