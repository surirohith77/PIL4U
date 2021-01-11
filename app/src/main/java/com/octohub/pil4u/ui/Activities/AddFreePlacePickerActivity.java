package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.octohub.pil4u.Locationn.GPSTracker;
import com.octohub.pil4u.Locationn.PlaceAutoSuggestAdapter;
import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.ViewWeightAnimationWrapper;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddFreePlacePickerActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener, View.OnClickListener,  AdapterView.OnItemSelectedListener {

    private RelativeLayout mMapContainer;
    private LinearLayout mDataContainer;
    AutoCompleteTextView search_locations;
    GoogleMap mMap;
    LatLng place;
    String dlocation;
    Marker marker;
    GPSTracker gps;
    //TextView tvdis, tvdur;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    LatLng dloct;
    private String provider;
    private boolean started = false;
    MarkerOptions markerOptions;
    //TextView getdirection_btn;
    public static Double longitute;
    public static Double latitude;
    TextView getDone_btn;

    Integer pos=0;
    String classname="",final_amnt,final_qtty;
    LatLng currentLocationLATLNG;

    //  private final LatLng mDefaultLocation = new LatLng(-33.8523341, 151.2106085);
    private static final int DEFAULT_ZOOM = 15;

    // Keys for storing activity state.
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";
    // location retrieved by the Fused Location Provider.
    private Location mLastKnownLocation;
    private CameraPosition mCameraPosition;
    // The entry point to the Fused Location Provider.
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final int LOCATION_PERMISSION_CODE = 213;
    Double latitude2, longitude2;
    LatLng checkPositoin ;
    List<Address> addresses;
    TextView tapthemap;
    String address, area, state, subLocality;
    Double latAutoSearch, lngAutoSearch = null;

    private static final int MAP_LAYOUT_STATE_CONTRACTED = 0;
    private static final int MAP_LAYOUT_STATE_EXPANDED = 1;
    private int mMapLayoutState = 0;

    ImageButton btn_full_screen_map;
    AppCompatEditText etProjectName, etCountry, etState, etAddress, etLocality, etPincode, etCity;

    private String[] nearByRadius = { "Near By Radius"};
    private String[] nearByPlaces = { "Near By Places"};
    private String[] landMark = { "LandMark"};

    AppCompatSpinner spinnerNearByRadius, spinnerNearByPlaces, spinnerLandMark;
    Button btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_free_place_picker);

        init();
        initLocationSuggetions();

        if (savedInstanceState != null) {
            mLastKnownLocation = savedInstanceState.getParcelable(KEY_LOCATION);
            mCameraPosition = savedInstanceState.getParcelable(KEY_CAMERA_POSITION);
        }


        // Construct a FusedLocationProviderClient.
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getSupportFragmentManager()
                .findFragmentById(R.id.loc_maps);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);





        if (ContextCompat.checkSelfPermission(AddFreePlacePickerActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
          /*  Toast.makeText(PlacrPickerActivity.this, "You have already granted this permission!",
                    Toast.LENGTH_SHORT).show();*/
         getDeviceLocation();

        } else {
            requestLocationPermission();
        }

        initlizeSpinnerNearByRadius();
        initlizeSpinnerLandMark();
        initlizeSpinnerNearByPlaces();

    }


    public void initlizeSpinnerNearByRadius(){

        spinnerNearByRadius =  findViewById(R.id.spinnerNearByRadius);
        spinnerNearByRadius.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,nearByRadius);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerNearByRadius.setAdapter(aa);
    }

    public void initlizeSpinnerLandMark(){

        spinnerLandMark =  findViewById(R.id.spinnerLandMark);
        spinnerLandMark.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,landMark);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerLandMark.setAdapter(aa);
    }

    public void initlizeSpinnerNearByPlaces(){

        spinnerNearByPlaces =  findViewById(R.id.spinnerNearByPlaces);
        spinnerNearByPlaces.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,nearByPlaces);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerNearByPlaces.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

     /*   if (!spinnerTime.equals("Select Loan type")){
            leadtype = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();
        }*/

     String   NearByRadius = spinnerNearByRadius.getItemAtPosition(spinnerNearByRadius.getSelectedItemPosition()).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void initLocationSuggetions() {



        search_locations = (AutoCompleteTextView) findViewById(R.id.etSearch);

       /* search_locations.setAdapter(new GooglePlacesAutocompleteAdapter(this, R.layout.address_display));
        search_locations.setOnItemClickListener(this);*/

        // default textview
        // search_locations.setAdapter(new PlaceAutoSuggestAdapter(LocationPreferenceActivities.this,android.R.layout.simple_list_item_1));

        // customer textview
        search_locations.setAdapter(new PlaceAutoSuggestAdapter(AddFreePlacePickerActivity.this,R.layout.address_display));
        search_locations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Address : ",search_locations.getText().toString());
                LatLng latLng = getLatLngFromAddress(search_locations.getText().toString());
                if(latLng!=null) {
                    Log.d("Lat Lng : ", " " + latLng.latitude + " " + latLng.longitude);
                    //  Toast.makeText(LocationPreferenceActivities.this, " " + latLng.latitude + " " + latLng.longitude, Toast.LENGTH_SHORT).show();

                    latAutoSearch =  latLng.latitude;
                    lngAutoSearch = latLng.longitude;
                    getDeviceLocation();
                    getAddressDetails(latLng.latitude,latLng.longitude);
                   /* Intent intent = new Intent(AddFreePlacePickerActivity.this,PlacrPickerActivity.class);
                    intent.putExtra("lat",latLng.latitude);
                    intent.putExtra("lng",latLng.longitude);
                    startActivity(intent);*/

                    // if want addres from latlng can use below method;
                    /* Address address=getAddressFromLatLng(latLng);
                    if(address!=null) {
                        Log.d("Address : ", "" + address.toString());
                        Log.d("Address Line : ",""+address.getAddressLine(0));
                        Log.d("Phone : ",""+address.getPhone());
                        Log.d("Pin Code : ",""+address.getPostalCode());
                        Log.d("Feature : ",""+address.getFeatureName());
                        Log.d("More : ",""+address.getLocality());
                    }
                    else {
                        Log.d("Adddress","Address Not Found");
                    }*/
                }
                else {
                    Log.d("Lat Lng","Lat Lng Not Found");
                }

            }
        });
    }

    private void init() {

        mMapContainer = findViewById(R.id.map_container);
        mDataContainer = findViewById(R.id.mDataContainer);
        btn_full_screen_map = findViewById(R.id.btn_full_screen_map);
        btnContinue = findViewById(R.id.btnContinue);

        etProjectName = findViewById(R.id.etProjectName);
        etCountry = findViewById(R.id.etCountry);
        etState = findViewById(R.id.etState);
        etCity = findViewById(R.id.etCity);
        etAddress = findViewById(R.id.etAddress);
        etLocality = findViewById(R.id.etLocality);
        etPincode = findViewById(R.id.etPincode);

        btn_full_screen_map.setOnClickListener(this);
        btnContinue.setOnClickListener(this);

    }


    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // markerOptions = new MarkerOptions();
        gps = new GPSTracker(this);
        // place = new LatLng(PlaceDetails.lat, PlaceDetails.log);
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());


        String time = DateFormat.getTimeInstance().format(new Date());
        try {
            List<Address> list = geocoder.getFromLocation(gps.getLatitude(), gps.getLongitude(), 1);
            //    String caddress = list.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            // dlocation = caddress; //This is the complete address.
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* marker = mMap.addMarker(new MarkerOptions().position(place)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_address))
                .anchor(0.5f, 0.5f)
                .flat(true)
                .snippet(dlocation)
                .title(PlaceDetails.plname)
                .draggable(true)
                .visible(true));
       */
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(new LatLng(gps.getLatitude(), gps.getLongitude()))
//                .target(new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude()))
                .zoom(12)
                .bearing(0)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                2000, null);



        //LatLng currentLocation = gps.getLatitude(), gps.getLongitude();


        if (ActivityCompat.checkSelfPermission(this
                , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //LatLng currentLocation = new LatLng(gps.getLatitude(), gps.getLongitude());
        // marker =  mMap.addMarker(new MarkerOptions().position(currentLocationLATLNG).title("Current location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).draggable(true).visible(true));//enter code here


//     mMap.addMarker(new MarkerOptions().position(currentLocationLATLNG));
        //   marker =  mMap.addMarker(new MarkerOptions().position(currentLocationLATLNG).title("Custom location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).draggable(true).visible(true));

        //  mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng position) {

                if (marker != null) {
                    marker.remove();
                }
                marker =  mMap.addMarker(new MarkerOptions().position(position).title("Custom location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).draggable(true).visible(true));//enter code here


                //getDone_btn.setVisibility(View.VISIBLE);

                double latitude = position.latitude;
                double longitude = position.longitude;
/*
                StoredObjects.shop_lat=Double.toString(latitude);
                StoredObjects.shop_long =Double.toString(longitude);

                StoredObjects.latitude=Double.toString(latitude);
                StoredObjects.longitude =Double.toString(longitude);


                StoredObjects.LogMethod("","shop_loc:--"+StoredObjects.shop_lat+"**"+StoredObjects.shop_long+"**"+position+"**"+gps.Addressconverstion(getActivity(),latitude,longitude));*/
                Toast.makeText(getApplicationContext(),"latlag:-- "+position,Toast.LENGTH_LONG).show();

                checkPositoin = position;

                getAddressDetails(latitude, longitude);



            }

        });
    }


    private void getAddressDetails(double latitude, double longitude){

        Geocoder geocoder = new Geocoder(AddFreePlacePickerActivity.this, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);

            // getAddressLine means full address
            address = addresses.get(0).getAddressLine(0);

            // getFeatureName means door number
            String featureName = addresses.get(0).getFeatureName();

            // getSubAdminArea means district Name
            String subAdminArea =  addresses.get(0).getSubAdminArea();

            // getSubLocality means area Name
            subLocality = addresses.get(0).getSubLocality();

            // getLocality means city name
            String city = addresses.get(0).getLocality();

            //getAdminArea means state name
            String state = addresses.get(0).getAdminArea();

            //getPostalCode means pincode or postal code of area
            String zip = addresses.get(0).getPostalCode();

            //getCountryName means country name
            String country = addresses.get(0).getCountryName();

            etCountry.setText(country);
            etState.setText(state);
            etCity.setText(city);
            etAddress.setText(address);
            etLocality.setText(subAdminArea);
            etPincode.setText(zip);

            // Toast.makeText(MainActivity.this, ""+city+state+"\n"+zip+"\n"+country, Toast.LENGTH_LONG).show();
            Toast.makeText(AddFreePlacePickerActivity.this, ""+address, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void onLocationChanged(Location location) {

        if (marker != null) {
            marker.remove();

        }

        // TextView tvLocation = (TextView) findViewById(R.id.tv_location);

        // Getting latitude of the current location
        double latitude = location.getLatitude();

        // Getting longitude of the current location
        double longitude = location.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);
        //   marker =  mMap.addMarker(new MarkerOptions().position(position).title("Custom location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).draggable(true).visible(true));//enter code here

        //  marker = mMap.addMarker(new MarkerOptions().position(new LatLng(gps.getLatitude(), gps.getLongitude())).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).draggable(true).visible(true));
        marker = mMap.addMarker(new MarkerOptions().position(new LatLng(gps.getLatitude(), gps.getLongitude())));
        // Showing the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onPause() {
        super.onPause();


    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }













    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("We need this permission to show maps to you")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(AddFreePlacePickerActivity.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_CODE);

                            getDeviceLocation();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();

                getDeviceLocation();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getDeviceLocation() {
        /*
         * Get the best and most recent location of the device, which may be null in rare
         * cases when a location is not available.
         */
        try {
            /*    if (mLocationPermissionGranted) {*/
            Task<Location> locationResult = mFusedLocationProviderClient.getLastLocation();
            locationResult.addOnCompleteListener(this, new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful()) {
                        // Set the map's camera position to the current location of the device.

                        if (AddFreePlacePickerActivity.this.latAutoSearch != null && AddFreePlacePickerActivity.this.lngAutoSearch != null){

                            currentLocationLATLNG = new LatLng(AddFreePlacePickerActivity.this.latAutoSearch, AddFreePlacePickerActivity.this.lngAutoSearch);
                            marker =  mMap.addMarker(new MarkerOptions().position(currentLocationLATLNG).title("Custom location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).draggable(true).visible(true));

                            latitude2 = AddFreePlacePickerActivity.this.latAutoSearch;
                            longitude2 = AddFreePlacePickerActivity.this.lngAutoSearch;

                            if (currentLocationLATLNG != null) {
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                        new LatLng(AddFreePlacePickerActivity.this.latAutoSearch,
                                                AddFreePlacePickerActivity.this.lngAutoSearch), DEFAULT_ZOOM));

                                //Toast.makeText(PlacrPickerActivity.this, ""+mLastKnownLocation.getLatitude()+"\n"+mLastKnownLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            mLastKnownLocation = task.getResult();
                            currentLocationLATLNG = new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude());
                            marker = mMap.addMarker(new MarkerOptions().position(currentLocationLATLNG).title("Custom location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).draggable(true).visible(true));

                            getAddressDetails(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude());
                            //   marker = mMap.addMarker(new MarkerOptions().position(currentLocationLATLNG).title("Custom location").icon(BitmapDescriptorFactory.fromResource(R.drawable.pil_map_pin)).draggable(true).visible(true));

                           /* Geocoder geocoder = new Geocoder(AddFreePlacePickerActivity.this, Locale.getDefault());
                            try {
                                addresses = geocoder.getFromLocation(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude(), 1);
                                // getAddressLine means full address
                                address = addresses.get(0).getAddressLine(0);

                                // getFeatureName means door number
                                String featureName = addresses.get(0).getFeatureName();

                                // getSubAdminArea means district Name
                                String subAdminArea =  addresses.get(0).getSubAdminArea();

                                // getSubLocality means area Name
                                subLocality = addresses.get(0).getSubLocality();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }*/

                            latitude2 =   mLastKnownLocation.getLatitude();
                            longitude2 =    mLastKnownLocation.getLongitude();


                            if (mLastKnownLocation != null) {
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                        new LatLng(mLastKnownLocation.getLatitude(),
                                                mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));

                                //Toast.makeText(PlacrPickerActivity.this, ""+mLastKnownLocation.getLatitude()+"\n"+mLastKnownLocation.getLongitude(), Toast.LENGTH_SHORT).show();
                            }
                        }



                    } else {
                          /*  Log.d(TAG, "Current location is null. Using defaults.");
                            Log.e(TAG, "Exception: %s", task.getException());*/
                        LatLng mDefaultLocation = new LatLng(latitude2, longitude2);
                        mMap.moveCamera(CameraUpdateFactory
                                .newLatLngZoom(mDefaultLocation, DEFAULT_ZOOM));
                        mMap.getUiSettings().setMyLocationButtonEnabled(false);
                    }
                }
            });
            //  }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_full_screen_map: {

                if (mMapLayoutState == MAP_LAYOUT_STATE_CONTRACTED) {
                    mMapLayoutState = MAP_LAYOUT_STATE_EXPANDED;
                    expandMapAnimation();
                } else if (mMapLayoutState == MAP_LAYOUT_STATE_EXPANDED) {
                    mMapLayoutState = MAP_LAYOUT_STATE_CONTRACTED;
                    contractMapAnimation();
                }
                break;
            }

            case R.id.btnContinue:
                startActivity(new Intent(this,AddFreeImagesPickrActivity.class));

        }
    }

    private void expandMapAnimation(){
        ViewWeightAnimationWrapper mapAnimationWrapper = new ViewWeightAnimationWrapper(mMapContainer);
        ObjectAnimator mapAnimation = ObjectAnimator.ofFloat(mapAnimationWrapper,
                "weight",
                50,
                100);
        mapAnimation.setDuration(800);

        ViewWeightAnimationWrapper recyclerAnimationWrapper = new ViewWeightAnimationWrapper(mDataContainer);
        ObjectAnimator recyclerAnimation = ObjectAnimator.ofFloat(recyclerAnimationWrapper,
                "weight",
                50,
                0);
        recyclerAnimation.setDuration(800);

        recyclerAnimation.start();
        mapAnimation.start();
    }

    private void contractMapAnimation(){
        ViewWeightAnimationWrapper mapAnimationWrapper = new ViewWeightAnimationWrapper(mMapContainer);
        ObjectAnimator mapAnimation = ObjectAnimator.ofFloat(mapAnimationWrapper,
                "weight",
                100,
                50);
        mapAnimation.setDuration(800);

        ViewWeightAnimationWrapper recyclerAnimationWrapper = new ViewWeightAnimationWrapper(mDataContainer);
        ObjectAnimator recyclerAnimation = ObjectAnimator.ofFloat(recyclerAnimationWrapper,
                "weight",
                0,
                50);
        recyclerAnimation.setDuration(800);

        recyclerAnimation.start();
        mapAnimation.start();
    }

    private LatLng getLatLngFromAddress(String address){

        Geocoder geocoder=new Geocoder(AddFreePlacePickerActivity.this);
        List<Address> addressList;

        try {
            addressList = geocoder.getFromLocationName(address, 1);
            if(addressList!=null){
                Address singleaddress=addressList.get(0);
                LatLng latLng=new LatLng(singleaddress.getLatitude(),singleaddress.getLongitude());
                return latLng;
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


}