////package edu.colby.ontrack.ontrack;
////
////import android.support.v7.app.ActionBarActivity;
////import android.os.Bundle;
////import android.util.Log;
////import android.view.Menu;
////import android.view.MenuItem;
////import android.view.View;
////import android.widget.Button;
////import android.widget.EditText;
////import android.widget.TextView;
////import android.widget.Toast;
////
////import com.parse.FindCallback;
////import com.parse.GetCallback;
////import com.parse.ParseException;
////import com.parse.ParseObject;
////import com.parse.ParseQuery;
////
////import java.util.List;
////
////
////public class LeadActivity extends ActionBarActivity {
////    private static String TAG = "LeadActivity";
////    private EditText mUniqueId;
////    private Button mBroadcast;
////    private Button mCancelBroadcast;
////    private boolean misIDUnique;
////    private String muserID;
////    private ParseObject muser;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_lead);
////
////        muserID = getIntent().getStringExtra("userID");
////
////        mUniqueId = (EditText)findViewById(R.id.uniqueID_edittext);
////        mBroadcast = (Button)findViewById(R.id.buttonBroadcast);
////        initializeBroadcastButtons();
//////        mBroadcast.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View v) {
//////                //check editText
//////                String id = mUniqueId.getText().toString().trim();
//////                if(id.equals("")){
//////                    Toast.makeText(LeadActivity.this, "Please Enter a Valid ID", Toast.LENGTH_SHORT).show();
//////                }else{
//////                    //Check ID
//////                    try {
//////                        if(isIDUnique(id)){
//////                            makeSession(id);
////////                            Log.d(TAG, "Making the session");
//////                        }else{
//////                            Toast.makeText(LeadActivity.this, "ID is taken, try a different one!", Toast.LENGTH_SHORT).show();
//////                        }
//////                    } catch (ParseException e) {
//////                        e.printStackTrace();
//////                    }
//////                }
//////            }
//////        });
////
////        mCancelBroadcast = (Button)findViewById(R.id.buttonCancelBroadcast);
////        mCancelBroadcast.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                onBackPressed();
////            }
////        });
////    }
////
////    public void initializeBroadcastButtons(){
////        mBroadcast.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                //check editText
////                String id = mUniqueId.getText().toString().trim();
////                if(id.equals("")){
////                    Toast.makeText(LeadActivity.this, "Please Enter a Valid ID", Toast.LENGTH_SHORT).show();
////                }else{
////                    //Check ID
////                    isIDUnique(id);
////
////                    try {
////                        if(isIDUnique(id)){
////                            makeSession(id);
//////                            Log.d(TAG, "Making the session");
////                        }else{
////                            Toast.makeText(LeadActivity.this, "ID is taken, try a different one!", Toast.LENGTH_SHORT).show();
////                        }
////                    } catch (ParseException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }
////        });
////
////    }
////
////
////    private void makeSession(String id) {
////        ParseObject session = new ParseObject("Session");
////        session.put("Title", id);
////
////        //setting the leader
////        try {
////            session.put("Leader", getUser(muserID));
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
////        session.saveInBackground();
////    }
////
////    public void isIDUnique(final String id) throws ParseException {
////        ParseQuery<ParseObject> query = ParseQuery.getQuery("Session");
////        query.whereEqualTo("Title", id);
////        query.findInBackground(new FindCallback<ParseObject>() {
////            @Override
////            public void done(List<ParseObject> parseObjects, ParseException e) {
////                misIDUnique = parseObjects.isEmpty();
////                if(misIDUnique){
////                    makeSession(id);
////                }else{
////                    Toast.makeText(LeadActivity.this, "ID is taken, try a different one!", Toast.LENGTH_SHORT).show();
////                }
//////                Log.d(TAG, "before isUnique: " + misIDUnique);
////            }
////        });
////    }
////
//////    public boolean isIDUnique(String id) throws ParseException {
//////        ParseQuery<ParseObject> query = ParseQuery.getQuery("Session");
//////        query.whereEqualTo("Title", id);
//////        List<ParseObject> results = query.find();
////////
////////        query.findInBackground(new FindCallback<ParseObject>() {
////////            @Override
////////            public void done(List<ParseObject> parseObjects, ParseException e) {
////////                misIDUnique = parseObjects.isEmpty();
////////                Log.d(TAG, "before isUnique: " + misIDUnique);
////////            }
////////        });
////////        Log.d(TAG, "after isUnique: " + misIDUnique);
//////        return results.isEmpty();
//////    }
////
////    public ParseObject getUser(String id) throws ParseException {
////        ParseQuery<ParseObject> query = ParseQuery.getQuery("customUser");
////        query.whereEqualTo("objectId", id);
////        ParseObject obj = query.getFirst();
////
//////        query.getInBackground(id, new GetCallback<ParseObject>() {
//////            @Override
//////            public void done(ParseObject parseObject, ParseException e) {
//////                muser = parseObject;
//////                Log.d(TAG, "before getUser");
//////            }
//////        });
//////        Log.d(TAG, "after getUser");
////        Log.d(TAG, "obj " + obj);
////        return obj;
////    }
//////    @Override
//////    public boolean onCreateOptionsMenu(Menu menu) {
//////        // Inflate the menu; this adds items to the action bar if it is present.
//////        getMenuInflater().inflate(R.menu.menu_lead, menu);
//////        return true;
//////    }
//////
//////    @Override
//////    public boolean onOptionsItemSelected(MenuItem item) {
//////        // Handle action bar item clicks here. The action bar will
//////        // automatically handle clicks on the Home/Up button, so long
//////        // as you specify a parent activity in AndroidManifest.xml.
//////        int id = item.getItemId();
//////
//////        //noinspection SimplifiableIfStatement
//////        if (id == R.id.action_settings) {
//////            return true;
//////        }
//////
//////        return super.onOptionsItemSelected(item);
//////    }
////}
//
//package edu.colby.ontrack.ontrack;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.Toast;
//
//import com.parse.FindCallback;
//import com.parse.ParseException;
//import com.parse.ParseObject;
//import com.parse.ParseQuery;
//
//import java.util.List;
//
//
//public class LeadActivity extends ActionBarActivity {
//    private static String TAG = "LeadActivity";
//    private EditText mUniqueID;
//    private ImageButton mBroadcast;
//    private ImageButton mCancelBroadcast;
//    private boolean misIDUnique;
//    private String muserID;
//    private Integer d;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lead);
//
//
//        mUniqueID = (EditText) findViewById(R.id.uniqueID_edittext);
//        mBroadcast = (ImageButton) findViewById(R.id.buttonBroadcast);
////        muserID = getIntent().getStringExtra("userID");
//        muserID = LaunchActivity.getUser().getObjectId().toString();
//        mCancelBroadcast = (ImageButton) findViewById(R.id.buttonCancelBroadcast);
//        mCancelBroadcast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        mBroadcast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //check if the user has input anything
//                String id = mUniqueID.getText().toString().trim();
//                Log.d("before_checking", ""+ id.equals("")) ;
//
//                if(id.equals("")) {
//                    Log.d("after_checking", ""+ id.equals("")) ;
//
//                    Toast.makeText(LeadActivity.this, "Please enter a valid ID", Toast.LENGTH_SHORT).show();
//
//                }else{
//                    try {
//                        if (isIDunique(id)){
//                            makeSession(id);
//                            Intent i = new Intent(LeadActivity.this, LeaderMapActivity.class);
//                            startActivity(i);
//                        } else {
//                            //                       Toast.makeText(this, "ID is taken, try a different one! ", Toast.LENGTH_SHORT);
//                            Toast.makeText(LeadActivity.this, "ID is taken, try a different one!", Toast.LENGTH_SHORT).show();
//
//                        }
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//
//                    //check if ID is unique
//
//                }
//            }
//
//        });
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_lead, menu);
//        return true;
//    }
//
//    public boolean isIDunique(String id) throws ParseException {
//
//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Session");
//        query.whereEqualTo("Title", id);
//        List<ParseObject> results = query.find( );
//
//
//        boolean unique = results.isEmpty();
//        Log.i ("unique test", ""+ unique);
//        return unique;
//    }
//
//    public void makeSession(String id){
//        ParseObject currentUser = LaunchActivity.getUser();
//        Log.d(TAG, "currentUser: " + currentUser.getObjectId() );
//        ParseObject session = new ParseObject("Session");
////        ParseObject user = LaunchActivity.getInstance().
//
//        session.put("Title",id);
//        session.put("Leader", currentUser);
//        session.put("Active", true);
////        session.put("")
//        session.saveInBackground();
//        currentUser.put("session", session);
//        currentUser.saveInBackground();
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
//
//
//


package edu.colby.ontrack.ontrack;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class LeadActivity extends ActionBarActivity {
    private EditText mUniqueID;
    private ImageButton mBroadcast;
    private ImageButton mCancelBroadcast;
    private boolean misIDUnique;
    private String muserID;
    private Integer d;



    private static ParseObject mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        mUniqueID = (EditText) findViewById(R.id.uniqueID_edittext);
        mBroadcast = (ImageButton) findViewById(R.id.buttonBroadcast);
//        muserID = getIntent().getStringExtra("userID");
        muserID = LaunchActivity.getUser().getObjectId().toString();
        mCancelBroadcast = (ImageButton) findViewById(R.id.buttonCancelBroadcast);
        mCancelBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the user has input anything
                String id = mUniqueID.getText().toString().trim();
                Log.d("before_checking", ""+ id.equals("")) ;

                if(id.equals("")) {
                    Log.d("after_checking", ""+ id.equals("")) ;

                    Toast.makeText(LeadActivity.this, "Please enter a valid ID", Toast.LENGTH_SHORT).show();

                }else{
                    try {
                        if (isIDunique(id)){
                            makeSession(id);
                            Intent i = new Intent(LeadActivity.this, LeaderMapActivity.class);
                            startActivity(i);
//                           i.putExtra("Latitude",  )

                        } else {
                            //                       Toast.makeText(this, "ID is taken, try a different one! ", Toast.LENGTH_SHORT);
                            Toast.makeText(LeadActivity.this, "ID is taken, try a different one!", Toast.LENGTH_SHORT).show();

                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    //check if ID is unique




                }
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lead, menu);
        return true;
    }

    public boolean isIDunique(String id) throws ParseException {


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Session");
        query.whereEqualTo("Title", id);
        List<ParseObject> results = query.find( );
//        if
        if (results.isEmpty()){
            return true;

        } else if (!((boolean)results.get(0).get("Active"))){
            return true;
        }
        else{
            return false;
        }
//        boolean unique = results.isEmpty();
//
//        Log.i ("unique test", ""+ unique);
//        return unique;
//        return true;
    }

    public void makeSession(String id){
        ParseObject currentUser = LaunchActivity.getUser();
        mSession = new ParseObject("Session");
//        ParseObject user = LaunchActivity.getInstance().

        mSession.put("Title",id);
        mSession.put("Leader", currentUser);
        mSession.put("Active", true);
//        session.put("")
        mSession.saveInBackground();
        currentUser.put("session",  mSession);
        currentUser.saveInBackground();


    }


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
    public static ParseObject getmSession() {
        return mSession;
    }



}

