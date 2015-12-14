//package edu.colby.ontrack.ontrack;
//
//import android.content.Intent;
//import android.location.LocationManager;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.parse.GetCallback;
//import com.parse.Parse;
//import com.parse.ParseException;
//import com.parse.ParseObject;
//import com.parse.ParseQuery;
//
//
//public class LaunchActivity extends ActionBarActivity {
//    private boolean[] mAppStatus;
//    private Button mLeadButton;
//    private Button mFollowButton;
//    private static final String TAG = "LaunchActivity";
//    private ParseObject mUser;
//    private String mUserID;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_launch);
//
//        //Parse
//        registerUser();
//
//        mLeadButton = (Button)findViewById(R.id.buttonLead);
//        mFollowButton = (Button)findViewById(R.id.buttonFollow);
//
//        AppStatus as = new AppStatus(this);
//        mAppStatus = as.getAppStatus();
//        if(!mAppStatus[0]){
//            Log.d(TAG, "Network Not Working :(");
//            Intent i = new Intent(this, ErrorActivity.class);
//            i.putExtra("ErrorScreen", 1);
//            startActivity(i);
//        }else if(!mAppStatus[1]){
//            Log.d(TAG, "GPS Not Working :(");
//            Intent i = new Intent(this, ErrorActivity.class);
//            i.putExtra("ErrorScreen", 2);
//            startActivity(i);
//        }else{//all is well set the functionality for the lEAD and FOLLOW buttons
//            mLeadButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(LaunchActivity.this, LeadActivity.class);
//                    i.putExtra("userID", mUserID);
//                    startActivity(i);
//                }
//            });
//
//            mFollowButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(LaunchActivity.this, FollowActivity.class);
//                    startActivity(i);
//                }
//            });
//        }
//    }
//
//
//    public void registerUser(){
//        mUser = null;
//        //try to recieve
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("customUser");
//        query.fromLocalDatastore();
//        query.getFirstInBackground(new GetCallback<ParseObject>() {
//            @Override
//            public void done(ParseObject parseObject, ParseException e) {
//                mUser = parseObject;
//                if(mUser == null) {
//                    Log.d(TAG, "It was NOT in the local data store!");
//                    mUser = new ParseObject("customUser");
////                    mUser.put("Type", "blabla");
//                    mUser.saveInBackground();
//                    mUser.pinInBackground();
//                    mUserID = mUser.getObjectId().toString();
//                }else{
//                    Log.d(TAG, "It was in the local data store!");
////                    mUser.put("Type", "notnotnot");
//                    mUser.saveInBackground();
//                    mUserID = mUser.getObjectId().toString();
//                }
//
//            }
//        });
//
//    }
//
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.menu_launch, menu);
////        return true;
////    }
////
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        // Handle action bar item clicks here. The action bar will
////        // automatically handle clicks on the Home/Up button, so long
////        // as you specify a parent activity in AndroidManifest.xml.
////        int id = item.getItemId();
////
////        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
////        return super.onOptionsItemSelected(item);
////    }
//}



package edu.colby.ontrack.ontrack;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;


public class LaunchActivity extends ActionBarActivity {
    private static final String TAG = "launchActivity";
    private boolean[] mAppStatus;
    private ImageButton mLeadButton;
    private ImageButton mFollowButton;
    private  String userId;



    private static  ParseObject mUser;

    private String mUserID;
//    private static LaunchActivity instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        getWindow().getDecorView().setBackgroundColor(Color.rgb(50, 97, 176));
//        Parse.enableLocalDatastore(this);
//        Parse.initialize(this, );
//        instance = this;
        registerUser();

        mLeadButton = (ImageButton) findViewById(R.id.buttonLead);
        mFollowButton = (ImageButton) findViewById(R.id.buttonFollow);

        AppStatus as = new AppStatus(this);
        mAppStatus = as.getAppStatus();
        mAppStatus = as.getAppStatus();

        if (!mAppStatus[0]) {
            Log.d(TAG, "Network Not Working :(");
            mLeadButton.setEnabled(false);
            mFollowButton.setEnabled(false);
            Intent i = new Intent(this, ErrorActivity.class);
            i.putExtra("ErrorScreen", 1);
            startActivity(i);
        } else if (!mAppStatus[1]) {
            Log.d(TAG, "GPS Not Working :(");
            Intent i = new Intent(this, ErrorActivity.class);
            i.putExtra("ErrorScreen", 2);
            startActivity(i);
        } else { //all is well, set the functionality for mLeadbutton
            mLeadButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(LaunchActivity.this, LeadActivity.class);
                    i.putExtra("userID", mUserID);
                    startActivity(i);
                }
            });
            mFollowButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(LaunchActivity.this, FollowActivity.class);
                    startActivity(i);

                }
            });


        }


    }




    public void registerUser(){
//        mUser = null;
        //try to recieve
        ParseQuery<ParseObject> query = ParseQuery.getQuery("customUser");
        query.fromLocalDatastore();
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, com.parse.ParseException e) {
                mUser = parseObject;
                if(mUser == null) {
                    Log.d(TAG, "It was NOT in the local data store!");
                    mUser = new ParseObject("customUser");
//                    mUser.put("Type", "blabla");
                    mUser.saveInBackground();
                    mUser.pinInBackground();
//                    mUserID = mUser.getObjectId().toString();
                }else{
                    Log.d(TAG, "It was in the local data store!");
//                    mUser.put("Type", "notnotnot");
//                    mUserID = mUser.getObjectId().toString();
                    mUser.saveInBackground();
                }
            }
        });


    }

    public static ParseObject  getUser() {
        return mUser;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_launch, menu);
        return true;
    }

//    public LaunchActivity getInstance(){
//        return instance;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
}



