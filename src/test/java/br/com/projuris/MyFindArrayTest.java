package br.com.projuris;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyFindArrayTest {

	@Test
	public void test() {
		int[] array1 = {4,9,3,7,8,3,7,1};
		int[] array2 = {3,7};
		
		FindArray finder = new MyFindArray();
		assertEquals(5, finder.findArray(array1, array2));
		
		array1 = new int[]{9,9,9,9,9};
		array2 = new int[]{9,9};
		assertEquals(3, finder.findArray(array1, array2));
	}

}
