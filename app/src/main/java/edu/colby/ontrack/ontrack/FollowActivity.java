////package edu.colby.ontrack.ontrack;
////
////import android.support.v7.app.ActionBarActivity;
////import android.os.Bundle;
////import android.view.Menu;
////import android.view.MenuItem;
////
////
////public class FollowActivity extends ActionBarActivity {
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_follow);
////    }
////
////
//////    @Override
//////    public boolean onCreateOptionsMenu(Menu menu) {
//////        // Inflate the menu; this adds items to the action bar if it is present.
//////        getMenuInflater().inflate(R.menu.menu_follow, menu);
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
//import com.parse.ParseRelation;
//
//import java.util.List;
//
//
//public class FollowActivity extends ActionBarActivity {
//    private EditText mUniqueID;
//    private ImageButton mFollow;
//    private ImageButton mCancelFollow;
//    private boolean misIDUnique;
//    private String muserID;
//    private ParseObject mcurrentSession;
//    private static ParseObject mLeader;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_follow);
//        mUniqueID = (EditText) findViewById(R.id.follower_uniqueID_edittext);
//        mFollow = (ImageButton) findViewById(R.id.button_follow);
////        muserID = getIntent().getStringExtra("userID");
//        muserID = LaunchActivity.getUser().getObjectId().toString();
//        mCancelFollow = (ImageButton) findViewById(R.id.button_cancel_follow);
//        mCancelFollow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        mFollow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //check if the user has input anything
//                String id = mUniqueID.getText().toString().trim();
////                Log.d("before_checking", ""+ id.equals("")) ;
//
//                if(id.equals("")) {
////                    Log.d("after_checking", ""+ id.equals("")) ;
//
//                    Toast.makeText(FollowActivity.this, "Please enter a valid ID", Toast.LENGTH_SHORT).show();
//
//                }else{
//                    try {
//                        if (doesIDexist(id)){
//                            enterSession(id);
//                            Intent i = new Intent(FollowActivity.this, FollowerMapsActivity.class);
//                            startActivity(i);
//
//                        } else {
//                            //                       Toast.makeText(this, "ID is taken, try a different one! ", Toast.LENGTH_SHORT);
//                            Toast.makeText(FollowActivity.this, "ID does not exist, try again!", Toast.LENGTH_SHORT).show();
//
//                        }
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//
//                    //check if ID is unique
//
//
//
//
//                }
//            }
//
//
//
//
//        });
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_follow, menu);
//        return true;
//    }
//
//
//    public static ParseObject getmLeader() {
//        return mLeader;
//    }
//
//    public boolean doesIDexist(String id) throws ParseException {
//
//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Session");
//        query.whereEqualTo("Title", id);
//        List<ParseObject> results = query.find( );
//
//
////        boolean unique = !results.isEmpty();
////        Log.i ("unique test", ""+ unique);
////        return unique;
////        return true;
//        mcurrentSession = results.get(0);
//        mLeader = (ParseObject)mcurrentSession.get("Leader");
//        return !results.isEmpty();
//    }
//
//    public void enterSession(String id){
//        ParseObject currentUser = LaunchActivity.getUser();
////        ParseObject session = new ParseObject("Session");
////        ParseObject user = LaunchActivity.getInstance().
//
////        session.put("Followers",currentUser);
//        ParseRelation relation = mcurrentSession.getRelation("Followers");
//        relation.add(currentUser);
////        session.saveInBackground();
////        session.put("Leader", LaunchActivity.getUser());
////        session.put("")
//        mcurrentSession.saveInBackground();
//        currentUser.put("session", mcurrentSession);
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
//        return super.onOptionsItemSelected(item);
//    }
//}
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
import com.parse.ParseRelation;

import java.util.List;


public class FollowActivity extends ActionBarActivity {
    private EditText mUniqueID;
    private ImageButton mFollow;
    private ImageButton mCancelFollow;
    private boolean misIDUnique;
    private String muserID;



    private static ParseObject  mLeader;
    private ParseObject mcurrentSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        mUniqueID = (EditText) findViewById(R.id.follower_uniqueID_edittext);
        mFollow = (ImageButton) findViewById(R.id.button_follow);
//        muserID = getIntent().getStringExtra("userID");
        muserID = LaunchActivity.getUser().getObjectId().toString();
        mCancelFollow = (ImageButton) findViewById(R.id.button_cancel_follow);
        mCancelFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the user has input anything
                String id = mUniqueID.getText().toString().trim();
//                Log.d("before_checking", ""+ id.equals("")) ;

                if(id.equals("")) {
//                    Log.d("after_checking", ""+ id.equals("")) ;

                    Toast.makeText(FollowActivity.this, "Please enter a valid ID", Toast.LENGTH_SHORT).show();

                }else{
                    try {
                        if (doesIDexist(id)){
                            enterSession(id);
                            Intent i = new Intent(FollowActivity.this, FollowerMapsActivity.class);
                            startActivity(i);

                        } else {
                            //                       Toast.makeText(this, "ID is taken, try a different one! ", Toast.LENGTH_SHORT);
                            Toast.makeText(FollowActivity.this, "ID does not exist, try again!", Toast.LENGTH_SHORT).show();

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
        getMenuInflater().inflate(R.menu.menu_follow, menu);
        return true;
    }

    public boolean doesIDexist(String id) throws ParseException {


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Session");
        query.whereEqualTo("Title", id);
        List<ParseObject> results = query.find( );


//        boolean unique = !results.isEmpty();
//        Log.i ("unique test", ""+ unique);
//        return unique;
//        return true;
        if (results.isEmpty()){
            return false;
        } else if (!((boolean)results.get(0).get("Active"))){
            return false;
        } else {
            mcurrentSession = results.get(0);
            mLeader = (ParseObject) mcurrentSession.get("Leader");
//        setLeader();
            return true;
        }
    }

//    private void setLeader() {
//        ParseObject sessionId =
//
//
//    }

    public void enterSession(String id){
        ParseObject currentUser = LaunchActivity.getUser();
//        ParseObject session = new ParseObject("Session");
//        ParseObject user = LaunchActivity.getInstance().

//        session.put("Followers",currentUser);

        ParseRelation relation = mcurrentSession.getRelation("Followers");
        relation.add(currentUser);
//        session.saveInBackground();
//        session.put("Leader", LaunchActivity.getUser());
//        session.put("")
        mcurrentSession.saveInBackground();
        currentUser.put("session", mcurrentSession);
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
    public static ParseObject getmLeader() {
        return mLeader;
    }

}
