package com.github.stuartyeates.TEIDictLeitner;

/*import android.app.Activity;*/
//import android.content.ComponentName;
//import android.content.Context;
//import android.os.RemoteException;
import android.os.Bundle;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;
 

public class Activity extends android.app.Activity {
	public Model model = new Model();
	public Question question = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // test
        model.addWord(new Word("kia ora","welcome"));
        model.addWord(new Word("kakariki","green"));
        model.addWord(new Word("whero","red"));
        model.addWord(new Word("pango","black"));
        model.addWord(new Word("ringa","hand"));
        
        setNewQuestion();
    }

    public void query(View v){
    	//
    }
    public void choice1(View v){
    	model.answerQuestion(question, 1);
    	//setNewQuestion();
    }
    public void choice2(View v){
    	model.answerQuestion(question, 2);
    	//setNewQuestion();
    }
     public void choice3(View v){
    	model.answerQuestion(question, 3);
    	//setNewQuestion();
    }
    
    public void setNewQuestion(){
    	//question = model.generateQuestion();
    	Button q = (Button) findViewById(R.id.query);
        //q.setText(question.getQuestion().getWord());
           
        Button c1 = (Button) findViewById(R.id.choice1);
        //c1.setText(question.getChoice1().getDefinition());
        
        Button c2 = (Button) findViewById(R.id.choice2);
        //c2.setText(question.getChoice2().getDefinition());
        
        Button c3 = (Button) findViewById(R.id.choice3);
        //c3.setText(question.getChoice3().getDefinition());
    }
}