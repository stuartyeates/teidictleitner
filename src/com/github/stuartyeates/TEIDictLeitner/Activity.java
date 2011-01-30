package com.github.stuartyeates.TEIDictLeitner;

/*import android.app.Activity;*/
import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Activity extends android.app.Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    
}