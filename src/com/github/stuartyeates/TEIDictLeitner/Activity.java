package com.github.stuartyeates.TEIDictLeitner;

/*import android.app.Activity;*/
//import android.content.ComponentName;
//import android.content.Context;
//import android.os.RemoteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 

public class Activity extends android.app.Activity implements OnClickListener  {
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
      	System.err.println("clicked: 0");
      	
      	question = model.generateQuestion();
      	
       	System.err.println("clicked: 1");
       	
       	//setNewQuestion();
       	
        Button button = (Button)findViewById(R.id.query);
        button.setOnClickListener(this);
        button = (Button)findViewById(R.id.choice1);
        button.setOnClickListener(this);
        button = (Button)findViewById(R.id.choice2);
        button.setOnClickListener(this);
        button = (Button)findViewById(R.id.choice3);
        button.setOnClickListener(this);

       	System.err.println("clicked 2");
       	
    }
    
    public void onClick(View v) {
       	// do something when the button is clicked
    	System.err.println("clicked");
    	Button clicked = (Button) findViewById(v.getId());
    	
    	Button q = (Button) findViewById(R.id.query);           
        Button c1 = (Button) findViewById(R.id.choice1);        
        Button c2 = (Button) findViewById(R.id.choice2);        
        Button c3 = (Button) findViewById(R.id.choice3);
 
    	if (clicked == c1){
        	System.err.println("clicked 1 ");
   		model.answerQuestion(question, 1);
    	} else {
        	if (clicked == c2){
            	System.err.println("clicked 2 ");
      		model.answerQuestion(question, 2);
        	} else {
            	if (clicked == c3){
                	System.err.println("clicked 3 ");
        		model.answerQuestion(question, 3);
            	} else {
                	System.err.println("clicked title");

            	}
        	}
    	}
    	setNewQuestion();
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