//package edu.colby.ontrack.ontrack;
//
//import android.content.Context;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.os.Bundle;
//import android.util.Log;
//
//import com.parse.ParseObject;
//
///**
// * Created by erfi on 4/11/15.
// */
//public class AppStatus {
//    private Context mcontext;
//    private boolean hasNetwork;
//    private boolean hasGPS;
//    private static String TAG = "AppStatus";
//    public AppStatus(Context context){
//        mcontext = context;
//        checkConnection();
//        checkGPS();
//    }
//
////=====================================================================
////============================CHECKING APP STATUS======================
////=====================================================================
//    public void checkConnection(){
//        ConnectivityManager cm =(ConnectivityManager)mcontext.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        hasNetwork = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
//    }
//
//    public void checkGPS() {
//        LocationManager locationManager = (LocationManager)mcontext.getSystemService(Context.LOCATION_SERVICE);
//        hasGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//    }
//
//    public boolean[] getAppStatus(){
//        boolean[] status = {hasNetwork, hasGPS};
////        Log.d(TAG, "hasNetwork: " + hasNetwork + " hasGPS: " + hasGPS );
//        return status;
//    }
//
//    public Location getLocation(){
//        LocationManager locationManager = (LocationManager)mcontext.getSystemService(Context.LOCATION_SERVICE);
//        LocationListener locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//                LeaderMapActivity lma = new LeaderMapActivity();
//                lma.setUpMap();
//                addGPS(location);
//            }
//
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//        };
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
//        String locationProvider1 = LocationManager.NETWORK_PROVIDER;
//        String locationProvider2 = LocationManager.GPS_PROVIDER;
//
//        Location l1 = locationManager.getLastKnownLocation(locationProvider1);
//        Location l2 = locationManager.getLastKnownLocation(locationProvider2);
//
//        if(l2 != null){//GPS
//            return l1;
//        }else if(l1 != null){//Network
//            return l1;
//        }else{ //return null
//            return null;
//        }
//    }
//
//    public void addGPS(Location loc){
//        ParseObject currentUser = LaunchActivity.getUser();
//
//        ParseObject gps = new ParseObject("GPSObject");
//        gps.put("Latitude", loc.getLatitude());
//        gps.put("Longitude", loc.getLongitude());
//        gps.put("user", currentUser);
//        Log.d(TAG, "Long: " + loc.getLongitude() + " Lat: " + loc.getLatitude());
//        gps.saveInBackground();
//
//        currentUser.put("GPSObject", gps);
//
////        ParseRelation relation = currentUser.getRelation("GPSObject");
////        relation.add(gps);
//        currentUser.saveInBackground();
//    }
//}


package edu.colby.ontrack.ontrack;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseObject;


//
//import android.content.Context;
//import android.location.LocationManager;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.widget.Toast;
//
///**
// * Created by vivek on 4/11/15.
// */
public class AppStatus {


    //Network Connectivity

    private Context mcontext;
    private boolean hasNetwork;
    private boolean hasGPS;

    public AppStatus(Context context) {
        mcontext = context;
        checkConnection();
        checkGPS();
    }



    public void checkConnection(){
        ConnectivityManager cm =
                (ConnectivityManager)mcontext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        hasNetwork = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }

    public void checkGPS(){
        LocationManager locationManager = (LocationManager) mcontext.getSystemService(Context.LOCATION_SERVICE);
        hasGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

    }




//    public Location getLocation(){
//        LocationManager locationManager = (LocationManager)mcontext.getSystemService(Context.LOCATION_SERVICE);
//        LocationListener locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
////                LeaderMapActivity lma = new LeaderMapActivity();
////                lma.setUpMap();
//                addGPS(location);
//
//            }
//
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//        };
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
//        String locationProvider1 = LocationManager.NETWORK_PROVIDER;
//        String locationProvider2 = LocationManager.GPS_PROVIDER;
//
//        Location l1 = locationManager.getLastKnownLocation(locationProvider1);
//        Location l2 = locationManager.getLastKnownLocation(locationProvider2);
//
//        if(l2 != null){//GPS
//            return l1;
//        }else if(l1 != null){//Network
//            return l1;
//        }else{ //return null
//            return null;
//        }
//    }

    public boolean[] getAppStatus(){
        boolean[] status = {hasNetwork, hasGPS};
        return status;

    }
//    public void addGPS(Location loc){
//        ParseObject currentUser = LaunchActivity.getUser();
//
//        ParseObject gps = new ParseObject("GPSObject");
//        gps.put("Latitude", loc.getLatitude());
//        gps.put("Longitude", loc.getLongitude());
//        gps.put("user", currentUser);
//        Log.d("Logitude", "Long: " + loc.getLongitude() + " Lat: " + loc.getLatitude());
//        gps.saveInBackground();
//
//        currentUser.put("GPSObject", gps);
//
////        ParseRelation relation = currentUser.getRelation("GPSObject");
////        relation.add(gps);
//        currentUser.saveInBackground();
//    }
}
