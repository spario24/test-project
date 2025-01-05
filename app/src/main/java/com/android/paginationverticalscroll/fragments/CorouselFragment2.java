package com.android.paginationverticalscroll.fragments;

import static java.lang.Math.abs;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.android.paginationverticalscroll.R;
import com.android.paginationverticalscroll.corouse2.CarouselItemDecoration;
import com.android.paginationverticalscroll.corouse2.ImageAdapter;
import com.android.paginationverticalscroll.databinding.FragmentCorousel2Binding;

public class CorouselFragment2 extends Fragment {

    Handler handler = new Handler(Looper.myLooper());

    FragmentCorousel2Binding binding;

    ImageAdapter adapter;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCorousel2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ImageAdapter(images, binding.viewPager);

        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setOffscreenPageLimit(3);
        binding.viewPager.setClipToPadding(false);
        binding.viewPager.setClipChildren(false);
        binding.viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        binding.viewPager.addItemDecoration(new CarouselItemDecoration(8));

        setuptransiton();

        setupIndicators();
//        setCurrentIndicator(0);
        animateIndicator(0);

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                setCurrentIndicator(position % images.length);
                animateIndicator(position % images.length);
            }
        });
    }

    void setuptransiton() {
        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - abs(position);
                page.setScaleY(0.85f + r * 0.14f);
                page.setAlpha(0.5f + (1 - Math.abs(position)));
            }
        });
        binding.viewPager.setPageTransformer(transformer);
    }

    private void setupIndicators() {
        ImageView[] indicators = new ImageView[images.length];
        binding.indicatorLayout.removeAllViews();

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getContext());
            indicators[i].setImageResource(R.drawable.indicator_inactive);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(8, 0, 8, 0);
            indicators[i].setLayoutParams(layoutParams);

            binding.indicatorLayout.addView(indicators[i]);
        }
    }

    private void setCurrentIndicator(int index) {
        int childCount = binding.indicatorLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) binding.indicatorLayout.getChildAt(i);
            if (i == index) {
                animateIndicator(imageView, true);
            } else {
                animateIndicator(imageView, false);
            }
        }
    }

    private void animateIndicator(ImageView imageView, boolean isActive) {
        if (isActive) {
            imageView.setImageResource(R.drawable.indicator_active);
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 1.2f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 1.2f);
            scaleX.setDuration(300);
            scaleY.setDuration(300);
            scaleX.start();
            scaleY.start();
        } else {
            imageView.setImageResource(R.drawable.indicator_inactive);
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1.2f, 1f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1.2f, 1f);
            scaleX.setDuration(300);
            scaleY.setDuration(300);
            scaleX.start();
            scaleY.start();
        }
    }

    private void animateIndicator(int index) {
        if (binding.indicatorLayout.getChildCount() == 0) return;

        View targetDot = binding.indicatorLayout.getChildAt(index);

        // Get the target dot's position on the screen
        float targetX = targetDot.getX();

        // Animate the moving indicator to the target dot
        ObjectAnimator animator = ObjectAnimator.ofFloat(binding.animatedIndicator, "translationX", targetX);
        animator.setDuration(300);
        animator.start();
    }

}
