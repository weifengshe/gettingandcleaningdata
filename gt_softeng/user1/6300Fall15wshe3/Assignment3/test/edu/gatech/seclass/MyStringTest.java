package edu.gatech.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStringTest {

	private MyStringInterface mystring;

	@Before
	public void setUp() throws Exception {
		mystring = new MyString();
	}

	@After
	public void tearDown() throws Exception {
		mystring = null;
	}

	@Test
	public void testGetConsonants1() {
		mystring.setString("I like vowels better than consonants");
		assertEquals("lkvwlsbttrthncnsnnts", mystring.getConsonants());
	}

	@Test
	public void testGetConsonants2() {
		mystring.setString("aba");
		assertEquals("b", mystring.getConsonants());
	}

	@Test
	public void testGetConsonants3() {
		mystring.setString("aaa");
		assertEquals("", mystring.getConsonants());
	}

	@Test
	public void testGetConsonants4() {
        fail("Not yet implemented");
	}

	@Test
	public void testNumberOfConsonants1() {
		mystring.setString("I like vowels better than consonants");
		assertEquals(20, mystring.numberOfConsonants());
	}

	@Test
	public void testNumberOfConsonants2() {
		mystring.setString("aba");
		assertEquals(1, mystring.numberOfConsonants());
	}

	@Test
	public void testNumberOfConsonants3() {
		mystring.setString("aaa");
		assertEquals(0, mystring.numberOfConsonants());
	}

	@Test
	public void testNumberOfConsonants4() {
        fail("Not yet implemented");
	}

	@Test
	public void testGetCharacter1() {
		mystring.setString("I like vowels better than consonants");
		assertEquals('e', mystring.getCharacter(16));
	}

	@Test
	public void testGetCharacter2() {
       mystring.setString("I like vowels better than consonants");
		assertEquals(' ', mystring.getCharacter(14));
	}

	@Test
	public void testGetCharacter3() {
        fail("Not yet implemented");
	}

	@Test
	public void testGetCharacter4() {
        fail("Not yet implemented");
	}

	@Test
	public void testFlipCaseInSubstring1() {
		mystring.setString("I Like Vowels Better Than Consonants");
		mystring.flipCaseInSubstring(7, 21);
		assertEquals("I Like vOWELS bETTER Than Consonants", mystring.getString());	
	}

	@Test
	public void testFlipCaseInSubstring2() {
        fail("Not yet implemented");
	}

	@Test
	public void testFlipCaseInSubstring3() {
        fail("Not yet implemented");
	}

	@Test
	public void testFlipCaseInSubstring4() {
	    fail("Not yet implemented");
	}
}
