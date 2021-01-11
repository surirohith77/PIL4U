package com.octohub.pil4u.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.octohub.pil4u.Adapter.ImageListRecyclerAdapter;
import com.octohub.pil4u.R;
import com.octohub.pil4u.utils.Action;
import com.octohub.pil4u.utils.CustomGallery;
import com.octohub.pil4u.utils.ImageUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AddFreeImagesPickrActivity extends AppCompatActivity {

    ImageView imgSinglePick;
    Button btnGalleryPickMul;
    ViewSwitcher viewSwitcher;
    RecyclerView recyclerView;


    String action;
    Handler handler;
    ImageListRecyclerAdapter imageListRecyclerAdapter;
    //	GalleryAdapter adapter;
    ImageLoader imageLoader;
    private HashMap<String, CustomGallery> imagesUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_free_images_pickr);


        initImageLoader();
        init();
    }

    public void initImageLoader() {

        imageLoader = ImageUtils.initImageLoader(this);

    }

    private void init() {

        btnGalleryPickMul = findViewById(R.id.btnGalleryPickMul);
        viewSwitcher = findViewById(R.id.viewSwitcher);
        recyclerView = findViewById(R.id.recyclerView);

        handler = new Handler();
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
//		gridGallery.setFastScrollEnabled(true);
        imageListRecyclerAdapter = new ImageListRecyclerAdapter(getApplicationContext());
        imageListRecyclerAdapter.setMultiplePick(false);
        recyclerView.setAdapter(imageListRecyclerAdapter);

        viewSwitcher.setDisplayedChild(1);

//		btnGalleryPickMul = (Button) findViewById(R.id.btnGalleryPickMul);
        btnGalleryPickMul.setOnClickListener(v -> {
            Intent i = new Intent(Action.ACTION_MULTIPLE_PICK);
            startActivityForResult(i, 200);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       /* if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            imageListRecyclerAdapter.clear();

            viewSwitcher.setDisplayedChild(1);
            String single_path = data.getStringExtra("single_path");
            imageLoader.displayImage("file://" + single_path, imgSinglePick);

        } else*/ if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
            String[] all_path = data.getStringArrayExtra("all_path");

            ArrayList<CustomGallery> dataT = new ArrayList<CustomGallery>();

            for (String string : all_path) {
                CustomGallery item = new CustomGallery();
                item.sdcardPath = string;

                dataT.add(item);
            }

            viewSwitcher.setDisplayedChild(0);
            imageListRecyclerAdapter.addAll(dataT);
        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
