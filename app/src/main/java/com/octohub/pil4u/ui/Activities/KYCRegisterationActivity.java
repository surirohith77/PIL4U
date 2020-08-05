package com.octohub.pil4u.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.octohub.pil4u.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class KYCRegisterationActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, View.OnClickListener{

    TextView tvPreferedDocSelect;
    TextView mItemSelected;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();

    AppCompatEditText etAadhar;
    AppCompatSpinner spinnerAddress, spinnerBankSt, spinnerDesignation, spinnerIncome;

    private String[] address = { "Select Address","Business Address","Residential Address"};
    private String[] banks = { "Select Bank","State bank of india","ICICI BANK","HDFC BANK", "Kotam Mahindra","Karur Vysya Bank"};
    private String[] designation = { "Select Designation","Manager","CEO","MD","Assitant clerk","Others"};
    private String[] incomeScope = { "Select Income Type","Yearly","Monthly"};

    ImageView ivDocument, ivPan, ivAddress, ivBankSt;
  TextView  tvSelectdAddress, tvUPloadDocSelect , tvUPloadPanSelect , tvBankSTSelect, tvDob, tvDobSelect ;

    private static final int STORAGE_PERMISSION_CODE = 23;
    private static final int SELECT_DOCUMENT = 33;
    private static final int SELECT_PAN = 34;
    private static final int SELECT_ADDRESS = 35;
    private static final int SELECT_BANKST = 36;

    DatePickerDialog.OnDateSetListener mDateSetListener ;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kyc_registeration);

        initializeToolbar();
        initalize();
        initlizeSpinnerAddress();
        initlizeSpinnerBanks();
        initlizeSpinnerDesignation();
        initlizeSpinnerIncomeScope();

        tvPreferedDocSelect =  findViewById(R.id.tvPreferedDocSelect);
        mItemSelected = (TextView) findViewById(R.id.tvItemSelected);

        listItems = getResources().getStringArray(R.array.kyc_proof);
        checkedItems = new boolean[listItems.length];

        tvPreferedDocSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(KYCRegisterationActivity.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
//                        if (isChecked) {
//                            if (!mUserItems.contains(position)) {
//                                mUserItems.add(position);
//                            }
//                        } else if (mUserItems.contains(position)) {
//                            mUserItems.remove(position);
//                        }
                        if(isChecked){
                            mUserItems.add(position);
                        }else{
                            mUserItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems.size(); i++) {
                            item = item + listItems[mUserItems.get(i)];
                            if (i != mUserItems.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        mItemSelected.setText(item);
                    }
                });

                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            mUserItems.clear();
                            mItemSelected.setText("");
                        }
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
    }

    private void initializeToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("KYC Form");
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initalize() {

        etAadhar = findViewById(R.id.etAadharr);

        ivDocument = findViewById(R.id.ivCam1);
        ivPan = findViewById(R.id.ivPan);
        ivAddress = findViewById(R.id.ivAddress);
        ivBankSt = findViewById(R.id.ivBankST);

        tvSelectdAddress = findViewById(R.id.tvSelectdAddress);
        tvUPloadDocSelect = findViewById(R.id.tvUPloadDocSelect);
        tvUPloadPanSelect = findViewById(R.id.tvUPloadPanSelect);
        tvBankSTSelect = findViewById(R.id.tvBankSTSelect);

        tvDob = findViewById(R.id.tvDob);
        tvDobSelect = findViewById(R.id.tvDobSelect);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvSelectdAddress.setOnClickListener(this);
        tvUPloadDocSelect.setOnClickListener(this);
        tvUPloadPanSelect.setOnClickListener(this);
        tvBankSTSelect.setOnClickListener(this);
        tvDobSelect.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);


        etAadhar.addTextChangedListener(new TextWatcher() {
            private static final char space = ' ';

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                // Remove spacing char
                if (s.length() > 0 && (s.length() % 4) == 0) {
                    final char c = s.charAt(s.length() - 1);
                    if (space == c) {
                        s.delete(s.length() - 1, s.length());
                    }
                }
                // Insert char where needed.
                if (s.length() > 0 && (s.length() % 5) == 0) {
                    char c = s.charAt(s.length() - 1);
                    // Only if its a digit where there should be a space we insert a space
                    if (Character.isDigit(c) && TextUtils.split(s.toString(), String.valueOf(space)).length <= 3) {
                        s.insert(s.length() - 1, String.valueOf(space));
                    }
                }
            }
        });

    }


    public void initlizeSpinnerAddress(){

        spinnerAddress =  findViewById(R.id.spinnerAddress);
        spinnerAddress.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,address);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerAddress.setAdapter(aa);
    }

    public void initlizeSpinnerBanks(){

        spinnerBankSt =  findViewById(R.id.spinnerBankSt);
        spinnerBankSt.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,banks);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerBankSt.setAdapter(aa);
    }

    public void initlizeSpinnerIncomeScope(){

        spinnerIncome =  findViewById(R.id.spinnerIncome);
        spinnerIncome.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,incomeScope);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerIncome.setAdapter(aa);
    }

    public void initlizeSpinnerDesignation(){

        spinnerDesignation =  findViewById(R.id.spinnerDesignation);
        spinnerDesignation.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,designation);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerDesignation.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

           /*   if (!spinnerTime.equals("Select Loan type")){
            leadtype = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();
        }*/

        //  timeType = spinnerTime.getItemAtPosition(spinnerTime.getSelectedItemPosition()).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tvSelectdAddress:

                openGalleryPermissionCheck(SELECT_ADDRESS);

                break;

            case R.id.tvUPloadDocSelect:

                openGalleryPermissionCheck(SELECT_DOCUMENT);
                break;

            case R.id.tvUPloadPanSelect:

                openGalleryPermissionCheck(SELECT_PAN);
                break;

            case R.id.tvBankSTSelect:
                openGalleryPermissionCheck(SELECT_BANKST);
                break;

            case R.id.tvDobSelect:
                openCalendar();
                break;

            case R.id.btnSubmit:
               startActivity(new Intent(this,CheckCivilScoreActivity.class));
                break;

        }


    }

    private void openCalendar() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);



        DatePickerDialog dialog = new DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
             //   Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date =  day+ "/" + month + "/" + year;
                tvDob.setText("DOB : "+date);
            }
        };
    }

    private void openGalleryPermissionCheck(int Checkcode) {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    /*Toast.makeText(activity, "You have already granted this permission!",
                            Toast.LENGTH_SHORT).show();*/

            openGallery(Checkcode);

            // showFileChooser();
        } else {
            requestStoragePermission();
        }
    }


    private void openGallery(int checkcode) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),checkcode);

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_DOCUMENT) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());

                 //   String    img = BitMapToString(bitmap);
                        ivDocument.setImageBitmap(bitmap);
                        ivDocument.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else    if (requestCode == SELECT_PAN) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());

                        //   String    img = BitMapToString(bitmap);
                        ivPan.setImageBitmap(bitmap);
                        ivPan.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else    if (requestCode == SELECT_ADDRESS) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());

                        //   String    img = BitMapToString(bitmap);
                        ivAddress.setImageBitmap(bitmap);
                        ivAddress.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        else    if (requestCode == SELECT_BANKST) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());

                        //   String    img = BitMapToString(bitmap);
                        ivBankSt.setImageBitmap(bitmap);
                        ivBankSt.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }

    // converting bitmapImage to String or base64
    public String BitMapToString(Bitmap bitmap){

        ByteArrayOutputStream baos = new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] arr=baos.toByteArray();
        String result =  Base64.encodeToString(arr, Base64.DEFAULT);
        return result;
    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(KYCRegisterationActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {

            new android.app.AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed to access gallery")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(KYCRegisterationActivity.this,
                                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);

                          // openGallery(Checkcode);
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
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();

                //openGallery(Checkcode);
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_favorites, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;


            case  R.id.ic_favorites:
                Intent intent = new Intent(this,FavoritesActivity.class);
                startActivity(intent);
                return true;

            case  R.id.ic_search:
                // Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();

                Intent intent2 = new Intent(this,SearchviewActivity.class);
                startActivity(intent2);

                return true;
        }


        return super.onOptionsItemSelected(item);
    }


}