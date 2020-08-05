package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.octohub.pil4u.Adapter.FavoritesAdapter;
import com.octohub.pil4u.Adapter.HotPackagesAdapter;
import com.octohub.pil4u.Adapter.PopularHousesAdapter;
import com.octohub.pil4u.Model.Favorites;
import com.octohub.pil4u.Model.HotPackages;
import com.octohub.pil4u.Model.PopularHouses;
import com.octohub.pil4u.R;

import java.util.ArrayList;

public class MyPropertiesFragment extends Fragment {

    Activity activity;
    View view;

    ArrayList  popularHousesList, hotPackagesList;
    PopularHousesAdapter favoritesAdapter;
    RecyclerView rvPopularHOuses, rvHotPackages;
    HotPackagesAdapter hotPackagesAdapter;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.myproperties_fragment,container,false);

        intializePopularHousesRecyclerview();
        intializeHotPackagesRecyclerview();
        RvPOpularHouses();
        RvHotPackages();

       return  view;
    }


    private void intializePopularHousesRecyclerview() {

        rvPopularHOuses = view.findViewById(R.id.rvPopularHouses);
        rvPopularHOuses.setHasFixedSize(true);
        rvPopularHOuses.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

    }

    private void RvPOpularHouses() {


        popularHousesList = new ArrayList();
        popularHousesList.add(new PopularHouses("\u20B935000","Renovated Apartment","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p7));
        popularHousesList.add(new PopularHouses("\u20B913000","Luxury Family Home ","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p4));
        popularHousesList.add(new PopularHouses("\u20B915000","Villa","1421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.p5));
        popularHousesList.add(new PopularHouses("\u20B915000","Gorgeous Villa Bay View","421 San Pedro St, Los Angeles, CA 90015","4.5",R.drawable.insidehouse2));


        favoritesAdapter = new PopularHousesAdapter(popularHousesList);
        rvPopularHOuses.setAdapter(favoritesAdapter);

    }

    private void intializeHotPackagesRecyclerview() {

        rvHotPackages = view.findViewById(R.id.rvHotPackages);
        /*rvHotPackages.setHasFixedSize(true);
        rvHotPackages.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
*/
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        rvHotPackages.setLayoutManager(staggeredGridLayoutManager);
       // rvHotPackages.setAdapter(staggeredRecyclerViewAdapter);

    }


    private void RvHotPackages() {


        hotPackagesList = new ArrayList();
        hotPackagesList.add(new HotPackages("\u20B935000","Renovated Apartment","421 San Pedro St, Los Angeles, CA 90015","Pending",R.drawable.insidehouse1));
        hotPackagesList.add(new HotPackages("\u20B9$13000","Luxury Family Home ","421 San Pedro St, Los Angeles, CA 90015","Published",R.drawable.insidehouse3));
        hotPackagesList.add(new HotPackages("\u20B9$15000","Villa","1421 San Pedro St, Los Angeles, CA 90015","Processing",R.drawable.p4));
        hotPackagesList.add(new HotPackages("\u20B9$15000","Gorgeous Villa Bay View","421 San Pedro St, Los Angeles, CA 90015","Pending",R.drawable.insidehouse2));


        hotPackagesAdapter = new HotPackagesAdapter(hotPackagesList);
        rvHotPackages.setAdapter(hotPackagesAdapter);

    }
}
