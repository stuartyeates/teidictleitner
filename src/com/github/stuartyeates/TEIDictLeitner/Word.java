package com.github.stuartyeates.TEIDictLeitner;

import java.util.Date;

public class Word implements Comparable<Word> {
	
	private String word;
	private String definition;
	private Date date;
	private int count = 0;
	
	public String getWord(){return word;};
	public String getDefinition(){return definition;};
	public Date getDate(){return date;};
	public int getCount(){return count;};
	public void incrementCount(){count++;};
	public void resetCount(){count=0;};
	
	public Word(String word,String definition, Date date){
		this.word = word;
		this.definition = definition;
		this.date = date;
	}
	
	public Word(String word,String definition){
		this.word = word;
		this.definition = definition;
		this.date = new Date();
	}
	
	  public int compareTo (Word o) {
		  if (o == null) {
			  System.err.println("comparing to null");
			  throw new IllegalArgumentException ("...");  
		  }	
		  if (this == o){
			  System.err.println("comparing to self");
			  return 0;
		  }	
		  Word other = (Word) o;
		  if (this.getDate().getTime() != other.getDate().getTime()){
			  if (this.getDate().getTime() > other.getDate().getTime())
				  return 1;
			  else
				  return -1;
		  }
		  if (this.hashCode() > other.hashCode())
			  return 1;
		  if (this.hashCode() < other.hashCode())
			  return -1;
		  return 0;
	  } 
	
}
