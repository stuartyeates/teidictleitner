package com.github.stuartyeates.TEIDictLeitner;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Random;

public class Model {

	private final int POOL_SIZE = 20;
	private final int MIN_SIZE = 3;
	// milliseconds in 5 hours
	private final long POOL_GAP_1 = 1000 * 60 * 60 * 6;
	// milliseconds in 23 hours
	private final long POOL_GAP_2 = 1000 * 60 * 60 * 24;
	// milliseconds in 3 days
	private final long POOL_GAP_3 = 1000 * 60 * 60 * 24 * 3;
	// milliseconds in 7 days
	private final long POOL_GAP_4 = 1000 * 60 * 60 * 24 * 7;
	// milliseconds in 19 days
	private final long POOL_GAP_5 = 1000 * 60 * 60 * 24 * 19;

	private Set<Word> deck0 = new TreeSet<Word>();
	private ArrayList<Word> deck1 = new ArrayList<Word>();
	private Set<Word> deck2 = new TreeSet<Word>();
	private Set<Word> deck3 = new TreeSet<Word>();
	private Set<Word> deck4 = new TreeSet<Word>();
	private Set<Word> deck5 = new TreeSet<Word>();
	private Set<Word> deck6 = new TreeSet<Word>();

	private Random random = new Random(new Date().getTime());

	public boolean answerQuestion(Question question, int answer) {
		Word word = question.getQuestion();
		if (question.correct(answer)) {
			word.incrementCount();
			deck1.remove(word);
			switch (word.getCount()) {
			case 1:
				deck2.add(word);
				break;
			case 2:
				deck3.add(word);
				break;
			case 3:
				deck4.add(word);
				break;
			case 4:
				deck5.add(word);
				break;
			case 5:
			default:
				deck6.add(word);
				break;
			}
			return true;
		} else {
			word.resetCount();
			return false;
		}
	}

	public Question generateQuestion() {
		if (deck1.size() < MIN_SIZE) {
			maintain();
		}
		if (deck1.size() < MIN_SIZE) {
			return null;
		}
		Word choice1 = deck1.get(random.nextInt(deck1.size()));
		Word choice2 = null;
		Word choice3 = null;
		while (choice2 == null || choice2 == choice1)
			choice2 = deck1.get(random.nextInt(deck1.size()));
		while (choice3 == null || choice3 == choice1 || choice3 == choice2)
			choice3 = deck1.get(random.nextInt(deck1.size()));

		return new Question(random.nextInt(2) + 1, choice1, choice2, choice3);
	}

	public boolean addWord(Word word) {
		deck0.add(word);
		return true;
	}

	public void maintain() {
		Date now = new Date();
		if (this.deck1.size() < this.POOL_SIZE) {
			Iterator<Word> words = new TreeSet<Word>(this.deck2).iterator();
			Date cutoff = new Date(now.getTime() + POOL_GAP_1);
			while (words.hasNext()) {
				Word word = words.next();
				if (word.getDate().getTime() < cutoff.getTime()) {
					this.deck2.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		if (this.deck1.size() < this.POOL_SIZE) {
			Iterator<Word> words = new TreeSet<Word>(this.deck3).iterator();
			Date cutoff = new Date(now.getTime() + POOL_GAP_2);
			while (words != null && words.hasNext()) {
				Word word = words.next();
				if (word.getDate().getTime() < cutoff.getTime()) {
					this.deck3.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		if (this.deck1.size() < this.POOL_SIZE) {
			Iterator<Word> words = new TreeSet<Word>(this.deck4).iterator();
			Date cutoff = new Date(now.getTime() + POOL_GAP_3);
			while (words != null && words.hasNext()) {
				Word word = words.next();
				if (word.getDate().getTime() < cutoff.getTime()) {
					this.deck4.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		if (this.deck1.size() < this.POOL_SIZE) {
			Iterator<Word> words = new TreeSet<Word>(this.deck5).iterator();
			Date cutoff = new Date(now.getTime() + POOL_GAP_4);
			while (words != null && words.hasNext()) {
				Word word = words.next();
				if (word.getDate().getTime() < cutoff.getTime()) {
					this.deck5.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		if (this.deck1.size() < this.POOL_SIZE) {
			Iterator<Word> words = new TreeSet<Word>(this.deck6).iterator();
			Date cutoff = new Date(now.getTime() + POOL_GAP_5);
			while (words != null && words.hasNext()) {
				Word word = words.next();
				if (word.getDate().getTime() < cutoff.getTime()) {
					this.deck6.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		while (this.deck1.size() < this.POOL_SIZE && this.deck0.size() > 0) {
			Word word = deck0.iterator().next();
			this.deck0.remove(word);
			this.deck1.add(word);
		}
	}
	
	static void addWords(Model model){
		
		// particles
		model.addWord(new Word("te", "definite particle, singular"));
		model.addWord(new Word("ngā", "definite particle, plural"));
		model.addWord(new Word("ngāti", "definite particle, people"));
		
		// numbers 
		model.addWord(new Word("tahi", "one"));
		model.addWord(new Word("rua", "two"));
		model.addWord(new Word("toru", "three"));
		model.addWord(new Word("whā", "four"));
		model.addWord(new Word("rima", "five"));
		model.addWord(new Word("ono", "six"));
		model.addWord(new Word("whitu", "seven"));
		model.addWord(new Word("waru", "eight"));
		model.addWord(new Word("iwa", "nine"));
		model.addWord(new Word("tekau", "ten")); 
		model.addWord(new Word("tekau ma tahi", "eleven"));
		model.addWord(new Word("tekau ma rua", "twelve"));
		model.addWord(new Word("tekau ma toru", "thirteen"));
		model.addWord(new Word("tekau ma whā", "fourteen"));
		model.addWord(new Word("tekau ma rima", "fifteen"));
		model.addWord(new Word("tekau ma ono", "sixteen"));
		model.addWord(new Word("tekau ma whitu", "seventeen"));
		model.addWord(new Word("tekau ma waru", "eighteen"));
		model.addWord(new Word("tekau ma iwa", "ninteen"));
		model.addWord(new Word("rua tekau", "twenty"));
		model.addWord(new Word("rua tekau ma tahi", "twenty one"));
		model.addWord(new Word("rua tekau ma rua", "twenty two"));
		model.addWord(new Word("rua tekau ma toru", "twenty three"));
		model.addWord(new Word("rua tekau ma whā", "twenty four"));
		model.addWord(new Word("rua tekau ma rima", "twenty five"));
		model.addWord(new Word("rua tekau ma ono", "twenty six"));
		model.addWord(new Word("rua tekau ma whitu", "twenty seven"));
		model.addWord(new Word("rua tekau ma waru", "twenty eight"));
		model.addWord(new Word("rua tekau ma iwa", "twenty nine"));
		model.addWord(new Word("toru tekau", "thrity"));

		// pronouns
		model.addWord(new Word("au", "first person singular pronoun"));
		model.addWord(new Word("ahau", "first person singular pronoun"));
		model.addWord(new Word("koe", "second person singular pronoun"));
		model.addWord(new Word("ia", "third person singular pronoun"));

		// verbs
		model.addWord(new Word("kai", "to eat (verb)"));
		//model.addWord(new Word("", ""));

		// nouns
		model.addWord(new Word("tangata", "person"));
		model.addWord(new Word("kurī", "dog"));
		model.addWord(new Word("ngeru", "cat"));
		model.addWord(new Word("rākau", "tree, stick, branch"));
		model.addWord(new Word("whare", "house"));
		model.addWord(new Word("kahu", "cloak"));
		//model.addWord(new Word("", ""));
		
		// colours
		model.addWord(new Word("", ""));
		//model.addWord(new Word("", ""));

		// birds
		model.addWord(new Word("rakiraki", "duck"));
		model.addWord(new Word("kererū", "wood pigeon"));
		model.addWord(new Word("tūī", "tui"));
		model.addWord(new Word("karoro", "black backed gull"));
		model.addWord(new Word("tiu", "sparrow"));
		model.addWord(new Word("kiwi", "kiwi"));
		model.addWord(new Word("korimako", "bellbird"));
		model.addWord(new Word("kea", "kea"));
		model.addWord(new Word("kaka", "kaka"));
		//model.addWord(new Word("", ""));
			
	}

}
