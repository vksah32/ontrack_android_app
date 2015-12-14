package edu.colby.ontrack.ontrack;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by erfi on 4/11/15.
 */
public class App extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this,"QCny2q33pKDkhmWZWpp59QTeGyCvnZcbFpzfqklk", "DPqG1gPk8iSbOBpeiHKQeaMSvxNPgzl5NhTfjBdB");
    }
}
