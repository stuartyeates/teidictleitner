package com.github.stuartyeates.TEIDictLeitner;

import junit.framework.TestCase;

public class QuestionTest extends TestCase {
	
	public void testBasic(){
		Question question = new Question(
				1,
				new Word("a","b"),
				new Word("c", "d"),
				new Word("e", "f")
		);
		assertNotNull(question);
	}

}
