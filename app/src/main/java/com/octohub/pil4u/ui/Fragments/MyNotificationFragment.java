package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.octohub.pil4u.Adapter.AdssAdapter;
import com.octohub.pil4u.Adapter.MyNotificationAdapter;
import com.octohub.pil4u.Model.Ads;
import com.octohub.pil4u.Model.MyNotification;
import com.octohub.pil4u.R;

import java.util.ArrayList;

public class MyNotificationFragment extends Fragment {

    Activity activity;
    View view;

    RecyclerView rvNotify;
    ArrayList notifyList;
    MyNotificationAdapter notificationAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.mynotification_fragment,container,false);

       intializeNotificationRecyclerview();
       initializeRvNotifications();
       return  view;
    }

    private void intializeNotificationRecyclerview() {

        rvNotify = view.findViewById(R.id.rvNotifications);
        rvNotify.setHasFixedSize(true);
        rvNotify.addItemDecoration(new DividerItemDecoration(rvNotify.getContext(), DividerItemDecoration.VERTICAL));
        rvNotify.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
       CardView cardView = view.findViewById(R.id.cardview);
        cardView.setBackgroundResource(R.drawable.cardview_corner_radius);

    }

    private void initializeRvNotifications() {


        notifyList = new ArrayList();
        notifyList.add(new MyNotification("Vincent Porter Vincent Porter Vincent Porter","The house was too awesome","Offline","2",R.drawable.s1));
        notifyList.add(new MyNotification("Jacob brown","I'm planning to buy villa","Online","0",R.drawable.s2));
        notifyList.add(new MyNotification("Harry talyor","Where are you","Pending","0",R.drawable.s3));

        notifyList.add(new MyNotification("Sarah miller","Recently i got an insurance","Offline","0",R.drawable.s4));
        notifyList.add(new MyNotification("Joanne Davis","Going to New york","Online","0",R.drawable.s6));
        notifyList.add(new MyNotification("Sam Lee","Let's go","Pending","6",R.drawable.s5));

        notifyList.add(new MyNotification("Vincent","Awesome","Offline","0",R.drawable.s2));
        notifyList.add(new MyNotification("Jacob brown","good","Online","0",R.drawable.s3));
        notifyList.add(new MyNotification("Rohith","Hitec city","Pending","1",R.drawable.s3));

        notifyList.add(new MyNotification("Vincent Porter","The house was too awesome","Offline","2",R.drawable.s1));
        notifyList.add(new MyNotification("Jacob brown","I'm planning to buy villa","Online","0",R.drawable.s2));
        notifyList.add(new MyNotification("Harry talyor","Where are you","Pending","0",R.drawable.s3));

        notifyList.add(new MyNotification("Sarah miller","Recently i got an insurance","Offline","0",R.drawable.s4));
        notifyList.add(new MyNotification("Joanne Davis","Going to New york","Online","0",R.drawable.s6));
        notifyList.add(new MyNotification("Sam Lee","Let's go","Pending","6",R.drawable.s5));

        notifyList.add(new MyNotification("Vincent","Awesome","Offline","0",R.drawable.s2));
        notifyList.add(new MyNotification("Jacob brown","good","Online","0",R.drawable.s3));
        notifyList.add(new MyNotification("Rohith","Hitec city","Pending","1",R.drawable.s3));


        notificationAdapter = new MyNotificationAdapter(notifyList);
        rvNotify.setAdapter(notificationAdapter);



    }
}
