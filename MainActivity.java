package com.jmiller.mentorcount;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.jmiller.mentorcount.MESSAGE";

    private Date currentTime;
    private Time now;
    private int[] count; // = new int[12];
    private String[] courses;

    Intent goToIdActivity;
    SharedPreferences sharedPreferences;

    TextView EE100;
    TextView EE112;
    TextView EE200;
    TextView EE212;
    TextView EE230;
    TextView EE240;
    TextView EE320;
    TextView EE325;
    TextView EE340;
    TextView EE317;
    TextView STEM;
    TextView OTHER;
    TextView aggieId;
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.reset:
                //reset alert
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Reset Count")
                        .setMessage("Reset Count?")
                        .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //reset everything

                                for (int i = 0; i<courses.length; i++){
                                    count[i] = 0;
                                    updateCount(courses[i], count[i]);
                                }
                                startActivity(goToIdActivity);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //null
                            }
                        })
                        .show();

                return true;
            default:
                return false;
        }
    }

    public void updateCount(String course, int updateCount){
        //sharedPreferences.edit().putString(course, count).apply();
        sharedPreferences.edit().putInt(course, updateCount).apply();
        //textView.setText(course + "\n" + count);

        EE100.setText("EE100: " + count[0]);
        EE112.setText("EE112: " + count[1]);
        EE200.setText("EE200: " + count[2]);
        EE212.setText("EE212: " + count[3]);
        EE230.setText("EE230: " + count[4]);
        EE240.setText("EE240: " + count[5]);
        EE320.setText("EE320: " + count[6]);
        EE325.setText("EE325: " + count[7]);
        EE340.setText("EE340: " + count[8]);
        EE317.setText("EE317: " + count[9]);
        STEM.setText("STEM: " + count[10]);
        OTHER.setText("OTHER: " + count[11]);


    }

//    public void count(String course, int count){
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //receive the ID, then post it at the top
        Intent receiveID = getIntent();
        aggieId = findViewById(R.id.idTextView);
        aggieId.setText(receiveID.getStringExtra(SwipeId.EXTRA_MESSAGE));

        //constructor to go back to swipe ID
        goToIdActivity = new Intent(this, SwipeId.class);


        count = new int[12];
        courses = new String[] {
                "EE100",
                "EE112",
                "EE200",
                "EE212",
                "EE230",
                "EE240",
                "EE320",
                "EE325",
                "EE340",
                "EE317",
                "STEM",
                "OTHER"
        };
        //sharedPreferences
        sharedPreferences = this.getSharedPreferences("com.jmiller.mentorcount", Context.MODE_PRIVATE);

        String[] courseCount = new String[12];



        //texView points to location in main_activity.xml
        EE100 = findViewById(R.id.EE100TextView);
        EE112 = findViewById(R.id.EE112TextView);
        EE200 = findViewById(R.id.EE200TextView);
        EE212 = findViewById(R.id.EE212TextView);
        EE230 = findViewById(R.id.EE230TextView);
        EE240 = findViewById(R.id.EE240TextView);
        EE320 = findViewById(R.id.EE320TextView);
        EE325 = findViewById(R.id.EE325TextView);
        EE340 = findViewById(R.id.EE340TextView);
        EE317 = findViewById(R.id.EE317TextView);
        STEM = findViewById(R.id.stemTextView);
        OTHER = findViewById(R.id.otherTextView);


        //courses is an array of strings => course names
        //count is an array of ints with same index as courses
        //this loops looks at the sharedpreferences dictionary with index course
        //if the index does not exist, set the index
        //otherwise print the current value, which should equal zero


        count[0] = sharedPreferences.getInt(courses[0], count[0]);
        count[1] = sharedPreferences.getInt(courses[1], count[1]);
        count[2] = sharedPreferences.getInt(courses[2], count[2]);
        count[3] = sharedPreferences.getInt(courses[3], count[3]);
        count[4] = sharedPreferences.getInt(courses[4], count[4]);
        count[5] = sharedPreferences.getInt(courses[5], count[5]);
        count[6] = sharedPreferences.getInt(courses[6], count[6]);
        count[7] = sharedPreferences.getInt(courses[7], count[7]);
        count[8] = sharedPreferences.getInt(courses[8], count[8]);
        count[9] = sharedPreferences.getInt(courses[9], count[9]);
        count[10] = sharedPreferences.getInt(courses[10], count[10]);
        count[11] = sharedPreferences.getInt(courses[11], count[11]);
        updateCount(courses[0], count[0]);
        updateCount(courses[1], count[1]);
        updateCount(courses[2], count[2]);
        updateCount(courses[3], count[3]);
        updateCount(courses[4], count[4]);
        updateCount(courses[5], count[5]);
        updateCount(courses[6], count[6]);
        updateCount(courses[7], count[7]);
        updateCount(courses[8], count[8]);
        updateCount(courses[9], count[9]);
        updateCount(courses[10], count[10]);
        updateCount(courses[11], count[11]);




    }

    public void click(View view){
        int id = view.getId();
        String buttonId = "";

        //button ID string
        buttonId = view.getResources().getResourceEntryName(id);

        //prints buttonId in the logs
        Log.i("Button Clicked", buttonId);

        switch (buttonId){
            case "EE100" :
                count[0] += 1;
                updateCount(courses[0], count[0]);
                currentTime = Calendar.getInstance().getTime();
                //currentTime = Calendar.getInstance(Locale.US
                System.out.println(courses[0] + "\t" + currentTime);
                //System.out.println("EE100 " + now);
                //EE100.setText("EE100: " + count[0]);
                //Log.println(1,);
                startActivity(goToIdActivity);
                break;
            case "EE112" :
                count[1] += 1;
                updateCount(courses[1], count[1]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[1] + "\t" + currentTime);
                //EE112.setText("EE112: " + count[1]);
                startActivity(goToIdActivity);
                break;
            case "EE200" :
                count[2] += 1;
                updateCount(courses[2], count[2]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[2] + "\t" + currentTime);
                //EE200.setText("EE200: " + count[2]);
                startActivity(goToIdActivity);
                break;
            case "EE212" :
                count[3] += 1;
                updateCount(courses[3], count[3]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[3] + "\t" + currentTime);
                //EE212.setText("EE212: " + count[3]);
                startActivity(goToIdActivity);
                break;
            case "EE230" :
                count[4] += 1;
                updateCount(courses[4], count[4]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[4] + "\t" + currentTime);
                //EE230.setText("EE230: " + count[4]);
                startActivity(goToIdActivity);
                break;
            case "EE240" :
                count[5] += 1;
                updateCount(courses[5], count[5]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[5] + "\t" + currentTime);
                //EE240.setText("EE240: " + count[5]);
                startActivity(goToIdActivity);
                break;
            case "EE320" :
                count[6] += 1;
                updateCount(courses[6], count[6]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[6] + "\t" + currentTime);
                //EE320.setText("EE320: " + count[6]);
                startActivity(goToIdActivity);
                break;
            case "EE325" :
                count[7] += 1;
                updateCount(courses[7], count[7]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[7] + "\t" + currentTime);
                //EE325.setText("EE325: " + count[7]);
                startActivity(goToIdActivity);
                break;
            case "EE340" :
                count[8] += 1;
                updateCount(courses[8], count[8]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[8] + "\t" + currentTime);
                //EE340.setText("EE340: " + count[8]);
                startActivity(goToIdActivity);
                break;
            case "EE317" :
                count[9] += 1;
                updateCount(courses[9], count[9]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[9] + "\t" + currentTime);
                //EE317.setText("EE317: " + count[9]);
                startActivity(goToIdActivity);
                break;
            case "STEM"  :
                count[10] += 1;
                updateCount(courses[10], count[10]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[10] + "\t" + currentTime);
                //STEM.setText("STEM: " + count[10]);
                startActivity(goToIdActivity);
                break;
            case "OTHER" :
                count[11] += 1;
                updateCount(courses[11], count[11]);
                currentTime = Calendar.getInstance().getTime();
                System.out.println(courses[11] + "\t" + currentTime);
                //OTHER.setText("Other: " + count[11]);
                startActivity(goToIdActivity);
                break;
        }
    }
}

