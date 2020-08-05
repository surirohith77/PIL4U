package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.octohub.pil4u.R;

public class RequestCallbackFragment extends Fragment {

    Activity activity;
    View view;

    Button btnSubmit;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (Activity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.request_callback_fragment,container,false);

        btnSubmit = view.findViewById(R.id.btnSubmit);

        Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up2);
        btnSubmit.startAnimation(animation1);

        return  view;
    }
}
