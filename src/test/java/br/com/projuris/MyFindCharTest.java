package br.com.projuris;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyFindCharTest {

	@Test
	public void test() {
		FindCharachter finder = new MyFindChar();
		String test = "stress";
		assertEquals('t', finder.findChar(test));
		
		test = "reembolsar";
		assertEquals('m', finder.findChar(test));
		
		test = "aaaaaaaaaa";
		assertEquals(' ', finder.findChar(test));
		
		test = "";
		assertEquals(' ', finder.findChar(test));
	}

}
