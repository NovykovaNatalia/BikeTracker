package com.example.biketracker.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.location.Location;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

import java.util.List;

import com.example.biketracker.R;

public class ProfileFragment extends Fragment /**implements OnMapReadyCallback,
        GoogleApiClient.OnConnectionFailedListener, RoutingListener **/{

    //google map object
    private GoogleMap mMap;

    //current and destination location objects
    Location myLocation = null;
    Location destinationLocation = null;
    protected LatLng start = null;
    protected LatLng end = null;

    //to get location permissions.
    private final static int LOCATION_REQUEST_CODE = 23;
    boolean locationPermission = false;

    //polyline object
    private List<Polyline> polylines = null;


    public View onCreateView(@NonNull LayoutInflater inflater,

                             ViewGroup container, Bundle savedInstanceState) {
        View fragmentProfil = inflater.inflate(R.layout.fragment_profile, container, false);
        //request location permission.
//        requestPermision();
        return fragmentProfil;
    }
//
//    private void requestPermision() {
//        if (ContextCompat.checkSelfPermission(getContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions((Activity) getContext(),
//                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
//                    LOCATION_REQUEST_CODE);
//        } else {
//            locationPermission = true;
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        switch (requestCode) {
//            case LOCATION_REQUEST_CODE: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //if permission granted.
//                    locationPermission = true;
//                    getMyLocation();
//
//                } else {
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                }
//                return;
//            }
//        }
//    }
//
//    //to get user location
//    private void getMyLocation() {
//        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        mMap.setMyLocationEnabled(true);
//        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
//            @Override
//            public void onMyLocationChange(Location location) {
//
//                myLocation=location;
//                LatLng ltlng=new LatLng(location.getLatitude(),location.getLongitude());
//                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
//                        ltlng, 16f);
//                mMap.animateCamera(cameraUpdate);
//            }
//        });
//
//        //get destination location when user click on map
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//
//                end=latLng;
//
//                mMap.clear();
//
//                start=new LatLng(myLocation.getLatitude(),myLocation.getLongitude());
//                //start route finding
//                Findroutes(start,end);
//            }
//        });
//
//    }
//
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        if(locationPermission) {
//            getMyLocation();
//        }
//
//    }
//
//
//    // function to find Routes.
//    public void Findroutes(LatLng Start, LatLng End)
//    {
//        if(Start==null || End==null) {
//            Toast.makeText(getContext(),"Unable to get location", Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//
//            Routing routing = new Routing.Builder()
//                    .travelMode(AbstractRouting.TravelMode.DRIVING)
//                    .withListener(this)
//                    .alternativeRoutes(true)
//                    .waypoints(Start, End)
//                    .key("AIzaSyD4uStbluZBnwKADWRtCPalZoddDXdNQbs")  //also define your api key here.
//                    .build();
//            routing.execute();
//        }
//    }
//
//    //Routing call back functions.
//    @Override
//    public void onRoutingFailure(RouteException e) {
//        View parentLayout = findViewById(android.R.id.content);
//        Snackbar snackbar= Snackbar.make(parentLayout, e.toString(), Snackbar.LENGTH_LONG);
//        snackbar.show();
////        Findroutes(start,end);
//    }
//
//    @Override
//    public void onRoutingStart() {
//        Toast.makeText(getContext(),"Finding Route...",Toast.LENGTH_LONG).show();
//    }
//
//    //If Route finding success..
//    @Override
//    public void onRoutingSuccess(ArrayList<Route> route, int shortestRouteIndex) {
//
//        CameraUpdate center = CameraUpdateFactory.newLatLng(start);
//        CameraUpdate zoom = CameraUpdateFactory.zoomTo(16);
//        if(polylines!=null) {
//            polylines.clear();
//        }
//        PolylineOptions polyOptions = new PolylineOptions();
//        LatLng polylineStartLatLng=null;
//        LatLng polylineEndLatLng=null;
//
//
//        polylines = new ArrayList<>();
//        //add route(s) to the map using polyline
//        for (int i = 0; i <route.size(); i++) {
//
//            if(i==shortestRouteIndex)
//            {
//                polyOptions.color(getResources().getColor(R.color.colorPrimary));
//                polyOptions.width(7);
//                polyOptions.addAll(route.get(shortestRouteIndex).getPoints());
//                Polyline polyline = mMap.addPolyline(polyOptions);
//                polylineStartLatLng=polyline.getPoints().get(0);
//                int k=polyline.getPoints().size();
//                polylineEndLatLng=polyline.getPoints().get(k-1);
//                polylines.add(polyline);
//
//            }
//            else {
//
//            }
//
//        }
//
//        //Add Marker on route starting position
//        MarkerOptions startMarker = new MarkerOptions();
//        startMarker.position(polylineStartLatLng);
//        startMarker.title("My Location");
//        mMap.addMarker(startMarker);
//
//        //Add Marker on route ending position
//        MarkerOptions endMarker = new MarkerOptions();
//        endMarker.position(polylineEndLatLng);
//        endMarker.title("Destination");
//        mMap.addMarker(endMarker);
//    }
//
//    @Override
//    public void onRoutingCancelled() {
//        Findroutes(start,end);
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//        Findroutes(start,end);
//
//    }
}