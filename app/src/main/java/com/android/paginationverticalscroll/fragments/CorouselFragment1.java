package com.android.paginationverticalscroll.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;

import com.android.paginationverticalscroll.databinding.FragmentCorouselBinding;

public class CorouselFragment1 extends Fragment {

    FragmentCorouselBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCorouselBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.carousel.setAdapter(new Carousel.Adapter() {
            @Override
            public int count() {
                // need to return the number of items we have in the carousel
                return 4;
            }

            @Override
            public void populate(View view, int index) {
                // need to implement this to populate the view at the given index
            }

            @Override
            public void onNewItem(int index) {
                // called when an item is set
            }
        });
    }
}
