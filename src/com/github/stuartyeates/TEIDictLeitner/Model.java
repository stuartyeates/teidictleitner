package com.github.stuartyeates.TEIDictLeitner;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Random;

public class Model {
	
	private final int POOL_SIZE = 20;
	// milliseconds in 5 hours
	private final long POOL_GAP_1 = 1000*60*60*6;
	// milliseconds in 23 hours
	private final long POOL_GAP_2 = 1000*60*60*24;
	// milliseconds in 3 days
	private final long POOL_GAP_3 = 1000*60*60*24*3;
	// milliseconds in 7 days
	private final long POOL_GAP_4 = 1000*60*60*24*7;
	// milliseconds in 19 days
	private final long POOL_GAP_5 = 1000*60*60*24*19;

	private Set<Word> deck0 = new TreeSet<Word>();
	private ArrayList<Word> deck1 = new ArrayList<Word>();
	private Set<Word> deck2 = new TreeSet<Word>();
	private Set<Word> deck3 = new TreeSet<Word>();
	private Set<Word> deck4 = new TreeSet<Word>();
	private Set<Word> deck5 = new TreeSet<Word>();
	private Set<Word> deck6 = new TreeSet<Word>();
	
	private Random random = new Random(new Date().getTime());
	
	public boolean answerQuestion(Question question, int answer){
			Word word = question.getQuestion();
			if (question.correct(answer)){
				word.incrementCount();
				deck1.remove(word);
				switch (word.getCount()){
				case 1: deck2.add(word); break;		
				case 2: deck3.add(word); break;		
				case 3: deck4.add(word); break;		
				case 4: deck5.add(word); break;		
				case 5: default: deck6.add(word); break;		
				}
				return true;
			} else {
			 word.resetCount();
			 return false;
			}
	}
	
	public Question generateQuestion(){
		Word choice1 = deck1.get(random.nextInt(deck1.size()-1));
		Word choice2 = null;
		Word choice3 = null;
		while (choice2 == null || choice2 == choice1)
			choice2 = deck1.get(random.nextInt(deck1.size()-1));
		while (choice3 == null || choice3 == choice1 || choice3 == choice2)
			choice3 = deck1.get(random.nextInt(deck1.size()-1));
		
		return new Question(
				random.nextInt(2)+1,
				choice1,choice2,choice3);
	}
	
	public boolean addWord(Word word){
		deck0.add(word);
		return true;
	}
	
	public void maintain(){
		Date now = new Date();
		if (this.deck1.size() < this.POOL_SIZE){
			Iterator<Word> words = this.deck2.iterator();
			Date cutoff = new Date(now.getTime()+POOL_GAP_1);
			while (words.hasNext()){
				Word word = words.next();
				if (word.getDate() .getTime() < cutoff.getTime()){
					this.deck2.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		if (this.deck1.size() < this.POOL_SIZE){
			Iterator<Word> words = this.deck3.iterator();
			Date cutoff = new Date(now.getTime()+POOL_GAP_2);
			while (words != null && words.hasNext()){
				Word word = words.next();
				if (word.getDate() .getTime() < cutoff.getTime()){
					this.deck3.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		if (this.deck1.size() < this.POOL_SIZE){
			Iterator<Word> words = this.deck4.iterator();
			Date cutoff = new Date(now.getTime()+POOL_GAP_3);
			while (words != null && words.hasNext()){
				Word word = words.next();
				if (word.getDate() .getTime() < cutoff.getTime()){
					this.deck4.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		if (this.deck1.size() < this.POOL_SIZE){
			Iterator<Word> words = this.deck5.iterator();
			Date cutoff = new Date(now.getTime()+POOL_GAP_4);
			while (words != null && words.hasNext()){
				Word word = words.next();
				if (word.getDate() .getTime() < cutoff.getTime()){
					this.deck5.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		if (this.deck1.size() < this.POOL_SIZE){
			Iterator<Word> words = this.deck6.iterator();
			Date cutoff = new Date(now.getTime()+POOL_GAP_5);
			while (words != null && words.hasNext()){
				Word word = words.next();
				if (word.getDate() .getTime() < cutoff.getTime()){
					this.deck6.remove(word);
					this.deck1.add(word);
				} else {
					words = null;
				}
			}
		}
		while (this.deck1.size() < this.POOL_SIZE && 
				this.deck0.size() > 0){
				Word word = deck0.iterator().next();
				this.deck0.remove(word);
				this.deck1.add(word);
		}
	}
	

}
