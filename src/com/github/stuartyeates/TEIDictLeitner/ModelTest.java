package com.github.stuartyeates.TEIDictLeitner;

import junit.framework.TestCase;

public class ModelTest extends TestCase {

	public ModelTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testModelCreation()
	{
		Model model = new Model();
		 assertTrue( (model!=null) );
	}

	public void testWordCreation()
	{
		Word word = new Word("kia ora","welcome");
		 assertTrue( (word!=null) );
	}

	public void testWordDef()
	{
		Word word = new Word("kia ora","welcome");
		 assertTrue( (word.getDefinition().compareTo("welcome") == 0) );
	}

	public void testWordWord()
	{
		Word word = new Word("kia ora","welcome");
		 assertTrue( (word.getWord().compareTo("kia ora") == 0) );
	}

	public void testWordWord2()
	{
		Word word = new Word("kia ora","welcome");
		 assertTrue( (word.getWord().compareToIgnoreCase("kia ora") == 0) );
	}

	public void testWordDate()
	{
		Word word = new Word("kia ora","welcome");
		 assertTrue( (word.getDate() != null) );
	}
	

	public void testAddition()
	{

		Model model = new Model();
		 assertTrue( (model!=null) );

	        // test
	        model.addWord(new Word("kia ora","welcome"));
	
	}

	public void testAddition2()
	{

		Model model = new Model();
		 assertTrue( (model!=null) );

	        // test
	        model.addWord(new Word("kia ora","welcome"));
	        model.addWord(new Word("kia ora","welcome"));
	
	}
	public void testAdd()
	{

		Model model = new Model();
		 assertTrue( (model!=null) );

	        // test
	        model.addWord(new Word("kia ora","welcome"));
	        model.addWord(new Word("kakariki","green"));
	        model.addWord(new Word("whero","red"));
	        model.addWord(new Word("pango","black"));
	        model.addWord(new Word("ringa","hand"));
	}
	public void testMaintain()
	{

		Model model = new Model();
		 assertTrue( (model!=null) );

	        // test
	        model.maintain();
	}
	public void testAddMaintain()
	{

		Model model = new Model();
		 assertTrue( (model!=null) );

	        // test
	        model.addWord(new Word("kia ora","welcome"));
	        model.addWord(new Word("kakariki","green"));
	        model.addWord(new Word("whero","red"));
	        model.addWord(new Word("pango","black"));
	        model.addWord(new Word("ringa","hand"));
	        model.maintain();
	}
	public void testAddMaintain2()
	{

		Model model = new Model();
		 assertTrue( (model!=null) );

	        // test
	        model.addWord(new Word("kia ora","welcome"));
	        model.addWord(new Word("kakariki","green"));
	        model.addWord(new Word("whero","red"));
	        model.addWord(new Word("pango","black"));
	        model.addWord(new Word("ringa","hand"));
	        model.maintain();
	        model.maintain();
			 assertTrue( (model!=null) );
	}

	public void testCreateQuestionMM()
	{

		Model model = new Model();
		 assertTrue( (model!=null) );

	        // test
	        model.addWord(new Word("kia ora","welcome"));
	        model.addWord(new Word("kakariki","green"));
	        model.addWord(new Word("whero","red"));
	        model.addWord(new Word("pango","black"));
	        model.addWord(new Word("ringa","hand"));
	        model.maintain();
	        model.maintain();
	        
	        Question question = model.generateQuestion();
	        assertTrue(question != null);
	    	
	}
	public void testCreateQuestionMMA()
	{

		Model model = new Model();
		 assertTrue( (model!=null) );

	        // test
	        model.addWord(new Word("kia ora","welcome"));
	        model.addWord(new Word("kakariki","green"));
	        model.addWord(new Word("whero","red"));
	        model.addWord(new Word("pango","black"));
	        model.addWord(new Word("ringa","hand"));
	        model.maintain();
	        model.maintain();
	        
	        Question question = model.generateQuestion();
	        assert(question != null);
	        int answer = 0;
	        if (question.getQuestion() == question.getChoice1())
	        	answer = 1;
	        else	
	        	if (question.getQuestion() == question.getChoice2())
	        		answer = 2;
		        else
			        if (question.getQuestion() == question.getChoice3())
			        	answer = 3;
			        else
			        	assert(false);	
        	
	        boolean a = model.answerQuestion(question, answer);
	        assertTrue(a);
	        a = model.answerQuestion(question, 1);
	        assert((a) == question.correct(1));
	        a = model.answerQuestion(question, 2);
	        assert((a) == question.correct(2));
	        a = model.answerQuestion(question, 3);
	        assert((a) == question.correct(3));
	}
}
