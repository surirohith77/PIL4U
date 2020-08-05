package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.octohub.pil4u.R;
import com.octohub.pil4u.ui.Fragments.HomeFragment;
import com.octohub.pil4u.ui.Fragments.MyPropertiesFragment;
import com.octohub.pil4u.ui.Fragments.MyaddsFragment;
import com.octohub.pil4u.utils.AccoutUtils;
import com.octohub.pil4u.utils.ErrorSnackBar;
import com.octohub.pil4u.utils.shared_prefernece;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int LOCATION_PERMISSION_CODE = 213;
    NavigationView navigationView;
    private DrawerLayout drawer;

    private long backPressed;
    private static final long TIME_DELAY = 2000;

    String latitude, longitude;
    LocationManager locationManager;

    TextView tvTool1, tvTool2, tvTool3;
    RelativeLayout relativeToolbar;
    Location location_details;

    ResultReceiver resultReceiver;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      // resultReceiver = new AddressResultReceiver(new Handler());


        initializeToolbar();

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        //  IvIConAnimation();
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
            navigationView.setItemIconTintList(null);
        }

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorAccent));

        //getLocation();


       /* if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            *//*Toast.makeText(MainActivity.this, "You have already granted this permission!",
                    Toast.LENGTH_SHORT).show();*//*
            getCurrentLocation();

        } else {
            requestStoragePermission();
        }*/
    }

    private void initializeToolbar() {



      toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        relativeToolbar = findViewById(R.id.relative_toolbar);

        ImageView ivHeart = findViewById(R.id.ic_heart);


        tvTool1 = findViewById(R.id.tvTool1);
        tvTool2 = findViewById(R.id.tvTool2);
        tvTool3 = findViewById(R.id.tvTool3);
        String subLocality = AccoutUtils.getSubLocality(this);
        String address = AccoutUtils.getAddress(this);

        if (!address.equals("")) {

            tvTool1.setVisibility(View.VISIBLE);
            tvTool2.setVisibility(View.VISIBLE);
            tvTool3.setVisibility(View.GONE);

            tvTool1.setText(subLocality);
            tvTool2.setText(address);

        }
        else {

         //   tvTool1.setText("Click here to set address");
            tvTool1.setVisibility(View.GONE);
            tvTool2.setVisibility(View.GONE);

            tvTool3.setVisibility(View.VISIBLE);


     }

        relativeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, PlacrPickerActivity.class));
            }
        });

        ivHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.home:

                //  Toast.makeText(this, "Purchase", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new HomeFragment()).commit();
                break;

            case R.id.properties:

                //  Toast.makeText(this, "Purchase", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyPropertiesFragment()).commit();
                break;

            case R.id.advertise:

                //  Toast.makeText(this, "PurchaseFragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyaddsFragment()).commit();
                break;

           /* case R.id.nav_statement:

               // Toast.makeText(this, "Statement", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new StatementDFragment()).commit();
                break;*/

           /* case R.id.action:
                // Toast.makeText(this, "StockFragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyActionFragment()).commit();
                break;

            case R.id.notification:
                // Toast.makeText(this, "OrderFragment", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers,
                        new MyNotificationFragment()).commit();
                break;*/

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        if (backPressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            ErrorSnackBar.onBackExit(this, navigationView);
        }

        backPressed = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.setItemIconTintList(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     /*   if (item.getItemId() == R.id.ic_heart) {
            startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
        }*/

       /* if (item.getItemId() == R.id.ic_add) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }*/
      /*  if (item.getItemId() == R.id.ic_about) {
            startActivity(new Intent(getApplicationContext(),about_mine.class));

        }*/
        return super.onOptionsItemSelected(item);
    }

    // from menu
    public void Logout(MenuItem item) {


        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.cone)
                .setTitle("Signing out")
                .setMessage("Are you sure , All your settings will be erased ? ")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "Data cleared", Toast.LENGTH_LONG).show();

                        FirebaseAuth.getInstance().signOut();

                        AccoutUtils.clearActiveUserDetails(MainActivity.this);

                        shared_prefernece shared_prefernece = new shared_prefernece(MainActivity.this);
                        shared_prefernece.writeloginstatus(false);

                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        }).create().show();
    }


    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("We need this permission to show near by Houses and properties")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_CODE);

                            getCurrentLocation();
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

                getCurrentLocation();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getCurrentLocation() {

        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.getFusedLocationProviderClient(MainActivity.this)
                .requestLocationUpdates(locationRequest, new LocationCallback() {

                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(MainActivity.this)
                                .removeLocationUpdates(this);

                        if (locationRequest != null && locationResult.getLocations().size() > 0) {

                            int latestlocationIndex = locationResult.getLocations().size() - 1;
                            double latitude = locationResult.getLocations().get(latestlocationIndex).getLatitude();
                            double longitude = locationResult.getLocations().get(latestlocationIndex).getLongitude();

                            Toast.makeText(MainActivity.this, "" + latitude + "\n" + longitude, Toast.LENGTH_SHORT).show();

                            Location location = new Location("provideNA");
                            location.setLatitude(latitude);
                            location.setLongitude(longitude);


                            tvTool1.setText( "Lat " + latitude);
                            tvTool2.setText("Lng " +longitude);

                           /* LocationAddress locationAddress = new LocationAddress();
                            locationAddress.getAddressFromLocation(latitude , longitude , getApplicationContext(), new GeocoderHandler());*/



                         //   fetchAddressFromLatLng(location);
                        } else {

                            // Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, Looper.getMainLooper());

    }

   /* private void fetchAddressFromLatLng(Location location){

        Intent intent = new Intent(this, FetchAddressIntentService.class);
        intent.putExtra(LocationConstants.RECEIVER,resultReceiver);
        intent.putExtra(LocationConstants.LOCATION_DATA_EXTRA,location);
        startService(intent);
    }

    private  class AddressResultReceiver extends ResultReceiver{

        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);

            if (resultCode == LocationConstants.SUCCESS_RESULT)
            {
                tvTool2.setText(resultData.getString(LocationConstants.RESULT_DATA_KEY));
            }
            else{

                Toast.makeText(MainActivity.this, resultData.getString(LocationConstants.RESULT_DATA_KEY), Toast.LENGTH_SHORT).show();
            }
        }
    }*/


}