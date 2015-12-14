package edu.colby.ontrack.ontrack;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ErrorActivity extends ActionBarActivity {
    private Bundle mscreenExtras;
    private TextView merrorTextView;
    private int screenErrorNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        merrorTextView = (TextView)findViewById(R.id.error_textview);

        mscreenExtras = getIntent().getExtras();
        screenErrorNum = mscreenExtras.getInt("ErrorScreen");
        if(screenErrorNum == 1){ //network Problem
            merrorTextView.setText("Check Your Network Connection!");
        }else if(screenErrorNum == 2){ //GPS problem
            merrorTextView.setText("Check if your GPS is enabled!");
        }
        //disable the back button
        View v = getWindow().getDecorView();
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //check if the issue is resolved
//        updatePage();
    }

//    public void updatePage(){
//        AppStatus as = new AppStatus(this);
//        boolean[] status = as.getAppStatus();
//        if(status[0] && status[1]){
//            Intent i = new Intent(this, LaunchActivity.class);
//            startActivity(i);
//        }
//    }



    @Override
    public void onBackPressed(){
        AppStatus as = new AppStatus(this);
        boolean[] status = as.getAppStatus();
        if(status[0] && status[1]){
            super.onBackPressed();
        }else {
            if (screenErrorNum == 1) {
                Toast.makeText(this, "You dont have network Connection!", Toast.LENGTH_SHORT).show();
            } else if (screenErrorNum == 2) {
                Toast.makeText(this, "Your GPS is not enabled!", Toast.LENGTH_SHORT).show();
            }
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_error, menu);
//        return true;
//    }
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


}
