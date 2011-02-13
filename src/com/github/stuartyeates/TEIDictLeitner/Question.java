package com.github.stuartyeates.TEIDictLeitner;

public class Question {
	public Question(int question, Word choice1, Word choice2, Word choice3) {
		if (question > 3)
			throw new Error("question too high");
		if (question < 1)
			throw new Error("question too low");
		if (choice1 == null)
			throw new Error("choice1 null");
		if (choice2 == null)
			throw new Error("choice2 null");
		if (choice3 == null)
			throw new Error("choice3 null");

		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
	}

	private int question;
	private Word choice1;
	private Word choice2;
	private Word choice3;

	public Word getQuestion() {
		switch (question) {
		case 1:
			return choice1;
		case 2:
			return choice2;
		case 3:
			return choice3;
		default:
			throw new Error();
		}
	};

	public boolean correct(int answer) {
		return (answer == question);
	}

	public int question() {
		return question;
	}

	public Word getChoice1() {
		return choice1;
	};

	public Word getChoice2() {
		return choice2;
	};

	public Word getChoice3() {
		return choice3;
	};
}
