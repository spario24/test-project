package com.android.paginationverticalscroll.fragments;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;

import com.android.paginationverticalscroll.R;
import com.android.paginationverticalscroll.databinding.FragmentStarUpBinding;

public class StarUpFragment extends Fragment {
    private static final String TAG = "StarUpFragment";
    String layout_name;
    MotionLayout mMotionLayout;

    int numImages;

    int selectedIndex = 0;
    FragmentStarUpBinding binding;

    int images[] = {
            R.drawable.bryce_canyon,
            R.drawable.cathedral_rock,
            R.drawable.death_valley,
            R.drawable.fitzgerald_marine_reserve,
            R.drawable.goldengate,
            R.drawable.golden_gate_bridge,
            R.drawable.shipwreck_1,
            R.drawable.shipwreck_2,
            R.drawable.grand_canyon,
            R.drawable.horseshoe_bend,
            R.drawable.muir_beach,
            R.drawable.rainbow_falls,
    };

    int colors[] = {
            Color.parseColor("#9C4B8F"),
            Color.parseColor("#945693"),
            Color.parseColor("#8C6096"),
            Color.parseColor("#846B9A"),
            Color.parseColor("#7C769E"),
            Color.parseColor("#7480A2"),
            Color.parseColor("#6D8BA5"),
            Color.parseColor("#6595A9"),
            Color.parseColor("#5DA0AD"),
            Color.parseColor("#55ABB1"),
            Color.parseColor("#4DB5B4"),
            Color.parseColor("#45C0B8"),
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStarUpBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        int layout  = R.layout.demo1;

        MotionLayout motionLayout = binding.motionContainer;

        View v1 = view.findViewById(R.id.v1);
        View v2 = view.findViewById(R.id.v2);
        View v3 = view.findViewById(R.id.v3);

        v1.setOnClickListener(view1 -> {
            if (selectedIndex == 0) {
                return;
            }

            motionLayout.setTransition(R.id.s2, R.id.s1); //orange to blue transition
            motionLayout.transitionToEnd();
            selectedIndex = 0;
        });
        v2.setOnClickListener(view1 -> {
            if (selectedIndex == 1) return;

            if (selectedIndex == 2) {
                motionLayout.setTransition(R.id.s3, R.id.s2);  //red to orange transition
            } else {
                motionLayout.setTransition(R.id.s1, R.id.s2); //blue to orange transition
            }
            motionLayout.transitionToEnd();
            selectedIndex = 1;
        });
        v3.setOnClickListener(view1 -> {
            if (selectedIndex == 2) return;

            motionLayout.setTransition(R.id.s2, R.id.s3); //orange to red transition
            motionLayout.transitionToEnd();
            selectedIndex = 2;
        });

    }


}
