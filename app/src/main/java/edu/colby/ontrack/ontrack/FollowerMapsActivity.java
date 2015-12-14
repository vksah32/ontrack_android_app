//package edu.colby.ontrack.ontrack;
//
//import android.location.Location;
//import android.support.v4.app.FragmentActivity;
//import android.os.Bundle;
//import android.util.Log;
//
//import com.google.android.gms.maps.CameraUpdate;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.CameraPosition;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.parse.FindCallback;
//import com.parse.ParseException;
//import com.parse.ParseObject;
//import com.parse.ParseQuery;
//
//import java.util.List;
//
//public class FollowerMapsActivity extends FragmentActivity {
//    private static String TAG = "FollowerMapsActivity";
//
//    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_follower_maps);
//        setUpMapIfNeeded();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        setUpMapIfNeeded();
//    }
//
//    /**
//     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
//     * installed) and the map has not already been instantiated.. This will ensure that we only ever
//     * call {@link #setUpMap()} once when {@link #mMap} is not null.
//     * <p/>
//     * If it isn't installed {@link SupportMapFragment} (and
//     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
//     * install/update the Google Play services APK on their device.
//     * <p/>
//     * A user can return to this FragmentActivity after following the prompt and correctly
//     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
//     * have been completely destroyed during this process (it is likely that it would only be
//     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
//     * method in {@link #onResume()} to guarantee that it will be called.
//     */
//    private void setUpMapIfNeeded() {
//        // Do a null check to confirm that we have not already instantiated the map.
//        if (mMap == null) {
//            // Try to obtain the map from the SupportMapFragment.
//            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
//                    .getMap();
//            // Check if we were successful in obtaining the map.
//            if (mMap != null) {
//                setUpMap();
//            }
//        }
//    }
//
//    /**
//     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
//     * just add a marker near Africa.
//     * <p/>
//     * This should only be called once and when we are sure that {@link #mMap} is not null.
//     */
//    private void setUpMap() {
//        AppStatus as = new AppStatus(this);
//        Location loc = as.getLocation();
//        as.addGPS(loc);
//        mMap.addMarker(new MarkerOptions().position(new LatLng(loc.getLatitude(), loc.getLongitude())).title("You"));
//
//
//        CameraPosition camPos = new CameraPosition.Builder()
//                .target(new LatLng(loc.getLatitude(), loc.getLongitude()))
//                .zoom(18)
//                .bearing(loc.getBearing())
//                .tilt(70)
//                .build();
//        CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
//        mMap.animateCamera(camUpd3);
//
//        ParseObject leader = FollowActivity.getmLeader();
//        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("GPSObject");
//        query.whereEqualTo("user", leader );
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> parseObjects, ParseException e) {
//                mMap.addMarker(new MarkerOptions().position(new LatLng((double) parseObjects.get(0).get("Latitude"), (double) parseObjects.get(0).get("Longitude"))).title("Leader"));
//            }
//        });
////        ParseObject gpsLeader = (ParseObject) leader.get("GPSObject");
////        Log.d(TAG, "Leader " + leader.getObjectId());
//
////        mMap.addMarker(new MarkerOptions().position(new LatLng((double) gpsLeader.get("Latitude"), (double) gpsLeader.get("Longitude"))).title("Leader"));
//
//    }
//}


package edu.colby.ontrack.ontrack;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class FollowerMapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                Location loc = getLocation();
                setUpMap(loc);
            }
        }
    }

    private void setUpMap(Location loc) {
//        AppStatus as = new AppStatus(this);
//        Location loc = as.getLocation();
        addGPS(loc);

//
//
        CameraPosition camPos = new CameraPosition.Builder()
                .target(new LatLng(loc.getLatitude(), loc.getLongitude()))
                .zoom(18)
                .bearing(loc.getBearing())
                .tilt(70)
                .build();
        CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
        mMap.animateCamera(camUpd3);
        mMap.addMarker(new MarkerOptions().position(new LatLng(loc.getLatitude(), loc.getLongitude())).title("You").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_follow_sheep)));

        ParseObject leader = FollowActivity.getmLeader();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("GPSObject");
        query.whereEqualTo("user", leader );
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                mMap.addMarker(new MarkerOptions().position(new LatLng((double) parseObjects.get(0).get("Latitude"), (double) parseObjects.get(0).get("Longitude"))).title("Leader").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_lead_sheep)));
            }
        });
//        ParseObject gpsLeader = (ParseObject) leader.get("GPSObject");
//        Log.d(TAG, "Leader " + leader.getObjectId());

//        mMap.addMarker(new MarkerOptions().position(new LatLng((double) gpsLeader.get("Latitude"), (double) gpsLeader.get("Longitude"))).title("Leader"));

    }



    public Location getLocation(){
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
//                LeaderMapActivity lma = new LeaderMapActivity();
//                lma.setUpMap();
                addGPS(location);
                mMap.clear();
                setUpMap(location);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        String locationProvider1 = LocationManager.NETWORK_PROVIDER;
        String locationProvider2 = LocationManager.GPS_PROVIDER;

        Location l1 = locationManager.getLastKnownLocation(locationProvider1);
        Location l2 = locationManager.getLastKnownLocation(locationProvider2);

        if(l2 != null){//GPS
            return l1;
        }else if(l1 != null){//Network
            return l1;
        }else{ //return null
            return null;
        }
    }

    public void addGPS(Location loc){
        ParseObject currentUser = LaunchActivity.getUser();

        ParseObject gps = new ParseObject("GPSObject");
        gps.put("Latitude", loc.getLatitude());
        gps.put("Longitude", loc.getLongitude());
        gps.put("user", currentUser);
        Log.d("Logitude", "Long: " + loc.getLongitude() + " Lat: " + loc.getLatitude());
        gps.saveInBackground();

        currentUser.put("GPSObject", gps);

//        ParseRelation relation = currentUser.getRelation("GPSObject");
//        relation.add(gps);
        currentUser.saveInBackground();
    }

}
