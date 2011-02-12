package com.github.stuartyeates.TEIDictLeitner;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(QuestionTest.class);
		suite.addTestSuite(WordTest.class);
		suite.addTestSuite(ModelTest.class);
		//$JUnit-END$
		return suite;
	}

}
