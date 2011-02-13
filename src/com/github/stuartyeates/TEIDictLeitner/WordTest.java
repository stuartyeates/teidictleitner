package com.github.stuartyeates.TEIDictLeitner;

import junit.framework.TestCase;
import java.util.Date;

public class WordTest extends TestCase {

	public void testWord1() {
		Word word = new Word("", "");
		assertNotNull(word);
	}

	public void testWord2() {
		Word word = new Word("a", "");
		assertNotNull(word);
	}

	public void testWord3() {
		Word word = new Word("", "a");
		assertNotNull(word);
	}

	public void testWord4() {
		Word word = new Word("b", "a");
		assertNotNull(word);
	}

	public void testWord5() {
		Word word = new Word("b", "a", new Date());
		assertNotNull(word);
	}

	public void testWord6() {
		Word word = new Word("b", "a", new Date());
		assertNotNull(word);
	}

	public void testComparison() {
		Word a = new Word("a", "A");
		Word b = new Word("a", "A");
		assertTrue(a.compareTo(b) == 0);
	}

	public void testComparison2() {
		Word a = new Word("a", "A");
		Word b = new Word("b", "B");
		assert (a.compareTo(b) == -1);
		assertTrue(a.compareTo(b) == -1);
		assertTrue(a.compareTo(b) == 1);
	}

}
