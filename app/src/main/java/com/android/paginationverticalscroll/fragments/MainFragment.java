package com.android.paginationverticalscroll.fragments;

import static com.android.paginationverticalscroll.ClipDataSource.KEY_BUNDLE;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.paginationverticalscroll.PlayerSliderAdapter;
import com.android.paginationverticalscroll.PlayerSliderFragmentViewModel;
import com.android.paginationverticalscroll.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }
    private PlayerSliderFragmentViewModel mModel;

    void initView(){
        Bundle params = getArguments().getBundle(KEY_BUNDLE);
        boolean isowner = false;

        PlayerSliderFragmentViewModel.Factory factory =
                new PlayerSliderFragmentViewModel.Factory(params, isowner);
        mModel = new ViewModelProvider(this, factory).get(PlayerSliderFragmentViewModel.class);

        PlayerSliderAdapter adapter = new PlayerSliderAdapter(getChildFragmentManager(), getLifecycle());
        binding.viewPager.setAdapter(adapter);

        mModel.clips.observe(getViewLifecycleOwner(), list -> {
//            adapter.submitList(list);
//            if (mModel.current > 0) {
//                pager2.setCurrentItem(mModel.current, false);
//            }
            adapter.submitData(list);
        });
    }
}