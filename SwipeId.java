package com.jmiller.mentorcount;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SwipeId extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.jmiller.mentorcount.MESSAGE";

    TextView idTextView;
    EditText studentId;
    Intent goToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_id);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //sets the intent to MainActivity. Called later to go there
        goToMainActivity = new Intent(this, MainActivity.class);



        //The actual place the new id is shown
        idTextView = findViewById(R.id.idTextView);

        //the password input
        studentId = findViewById(R.id.idInputPassword);

        //A button might be needed if the ID is swiped incorrectly.
        //
 //       Button button = (Button) findViewById(R.id.button);

//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                ConvertId idString = new ConvertId();
//                //String idRaw = studentId.getText().toString();
//                idTextView.setText("ID:" + idString.convert(studentId.getText().toString()));
//            }
//        });

        studentId.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (KeyEvent.KEYCODE_ENTER == keyCode){

                    // idString is type ConvertedId
                    ConvertId idString = new ConvertId();

                    //take some kind of action with id input
                    //set the text
                    idTextView.setText("ID:" + idString.convert(studentId.getText().toString()));

                    //go to MainActivity
                    goToMainActivity.putExtra(EXTRA_MESSAGE, idString.convert(studentId.getText().toString()));
                    startActivity(goToMainActivity);

                    return true;
                }
                return false;
            }
        });



    }//end onCreate

}
