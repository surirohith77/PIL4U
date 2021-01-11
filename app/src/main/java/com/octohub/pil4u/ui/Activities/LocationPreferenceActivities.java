package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.octohub.pil4u.Locationn.PlaceAutoSuggestAdapter;
import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.AccoutUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class LocationPreferenceActivities extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static String lat;
    private static String lng;
    RelativeLayout relativeSetLocation, relativePreviousLocation;
    TextView tvAddress1, tvAddress2;
    ImageView ivBack;
    CardView CardPreviousLocation;
    AutoCompleteTextView search_locations;
   // String lat, lng;


    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String OUT_JSON = "/json";
   // private static final String API_KEY = "AIzaSyAQtAA5jwBQlfkDjVHa7-cVmq_YJ7GyGDU";
    private static final String API_KEY = "AIzaSyCRXrfv5CD95ramaXxHkDKShaR2YCJEu3g";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_preference_activities);

        inialize();

        String subLocality = AccoutUtils.getSubLocality(this);
        String address = AccoutUtils.getAddress(this);

        if (!address.equals("")) {

            CardPreviousLocation.setVisibility(View.VISIBLE);
           /* tvTool2.setVisibility(View.VISIBLE);
            tvTool3.setVisibility(View.GONE);*/

            tvAddress1.setText(subLocality);
            tvAddress2.setText(address);

        }
        else {

            CardPreviousLocation.setVisibility(View.GONE);

        }

        relativeSetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LocationPreferenceActivities.this, PlacrPickerActivity.class));

            }
        });

        /*ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               *//* startActivity(new Intent(LocationPreferenceActivities.this, MainActivity3.class));
                finish();*//*

                Intent intent = new Intent(LocationPreferenceActivities.this,MainActivity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });*/

    }

    private void inialize() {

        relativeSetLocation = findViewById(R.id.relative_setLocationfromMap);
        relativePreviousLocation = findViewById(R.id.relative_previosLocation);
        CardPreviousLocation = findViewById(R.id.CardPreviousLocation);

      //  ivBack = findViewById(R.id.ivBackArrow);

        tvAddress1 = findViewById(R.id.tvAddress1);
        tvAddress2 = findViewById(R.id.tvAddress2);
       /* ImageView ivArrow = findViewById(R.id.ivArrow);

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        ivArrow.startAnimation(animation1);*/



        search_locations = (AutoCompleteTextView) findViewById(R.id.etSearch);

       /* search_locations.setAdapter(new GooglePlacesAutocompleteAdapter(this, R.layout.address_display));
        search_locations.setOnItemClickListener(this);*/

       // default textview
       // search_locations.setAdapter(new PlaceAutoSuggestAdapter(LocationPreferenceActivities.this,android.R.layout.simple_list_item_1));

        // customer textview
        search_locations.setAdapter(new PlaceAutoSuggestAdapter(LocationPreferenceActivities.this,R.layout.address_display));
        search_locations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Address : ",search_locations.getText().toString());
                LatLng latLng = getLatLngFromAddress(search_locations.getText().toString());
                if(latLng!=null) {
                    Log.d("Lat Lng : ", " " + latLng.latitude + " " + latLng.longitude);
                  //  Toast.makeText(LocationPreferenceActivities.this, " " + latLng.latitude + " " + latLng.longitude, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LocationPreferenceActivities.this,PlacrPickerActivity.class);
                    intent.putExtra("lat",latLng.latitude);
                    intent.putExtra("lng",latLng.longitude);
                    startActivity(intent);

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

    @Override
    public void onClick(View view) {

    }

   /* @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String str = (String) adapterView.getItemAtPosition(i);
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }*/

   /* public static ArrayList autocomplete(String input) {
        ArrayList resultList = null;

        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
            sb.append("?key=" + API_KEY);
            sb.append("&components=country:in");
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));

            URL url = new URL(sb.toString());
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            // Load the results into a StringBuilder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
//            Log.e(LOG_TAG, "Error processing Places API URL", e);
            return resultList;
        } catch (IOException e) {
//            Log.e(LOG_TAG, "Error connecting to Places API", e);
            return resultList;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        try {
            // Create a JSON object hierarchy from the results
            JSONObject jsonObj = new JSONObject(jsonResults.toString());
            JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

            // Extract the Place descriptions from the results
            resultList = new ArrayList(predsJsonArray.length());
            for (int i = 0; i < predsJsonArray.length(); i++) {
                System.out.println(predsJsonArray.getJSONObject(i).getString("description"));
                System.out.println("============================================================");
                resultList.add(predsJsonArray.getJSONObject(i).getString("description"));

      *//*    lat =      predsJsonArray.getJSONObject(i).getString("lat");
           lng =     predsJsonArray.getJSONObject(i).getString("lng");*//*
               *//* resultList.add(predsJsonArray.getJSONObject(i).getDouble("latitude"));
                resultList.add(predsJsonArray.getJSONObject(i).getDouble("longitude"));*//*
            }
        } catch (JSONException e) {
//            Log.e(LOG_TAG, "Cannot process JSON results", e);
        }

        return resultList;
    }

    class GooglePlacesAutocompleteAdapter extends ArrayAdapter implements Filterable {
        private ArrayList resultList;

        public GooglePlacesAutocompleteAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
        }

        @Override
        public int getCount() {
            return resultList.size();
        }

        @Override
        public String getItem(int index) {
            return String.valueOf(resultList.get(index));
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint != null) {
                        // Retrieve the autocomplete results.
                        resultList = autocomplete(constraint.toString());

                        // Assign the data to the FilterResults
                        filterResults.values = resultList;
                        filterResults.count = resultList.size();
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    if (results != null && results.count > 0) {
                        notifyDataSetChanged();
                    } else {
                        notifyDataSetInvalidated();
                    }
                }
            };
            return filter;
        }
    }*/


    private LatLng getLatLngFromAddress(String address){

        Geocoder geocoder=new Geocoder(LocationPreferenceActivities.this);
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

    private Address getAddressFromLatLng(LatLng latLng){
        Geocoder geocoder=new Geocoder(LocationPreferenceActivities.this);
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 5);
            if(addresses!=null){
                Address address=addresses.get(0);
                return address;
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}