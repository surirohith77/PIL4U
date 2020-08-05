package com.octohub.pil4u.ui.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.octohub.pil4u.R;

public class CarInsuranceFragmnet extends Fragment {

    View view;
    Activity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.car_insurance_fragmnet,container,false);

        RelativeLayout relativeLayout = view.findViewById(R.id.relativeMain);
        Animation animation1 =
                AnimationUtils.loadAnimation(activity, R.anim.down_to_up3);
        relativeLayout.startAnimation(animation1);

        return view;
    }
}
