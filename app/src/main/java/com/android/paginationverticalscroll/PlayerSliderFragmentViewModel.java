package com.android.paginationverticalscroll;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;

public class PlayerSliderFragmentViewModel  extends ViewModel {
//    public final LiveData<PagedList<ReelModel>> clips;
//    public final LiveData<PagingData<ReelModel>> clips;
//    public final ClipPageDataSource.Factory factory;
//    public final LiveData<LoadingState> state;

    public LiveData<PagingData<ReelModel>> clips;

    public PlayerSliderFragmentViewModel(@NonNull Bundle params, boolean mowner) {
//        PagedList.Config config = new PagedList.Config.Builder()
//                .setPageSize(params.getInt(ClipDataSource.PARAM_COUNT))
//                .build();
//        factory = new ClipPageDataSource.Factory(params, mowner);
//        state = Transformations.switchMap(factory.source, input -> input.state);
////        clips = new LivePagedListBuilder<>(factory, config).build();

        // Set up the PagingSource factory
        PagingSource<Integer, ReelModel> pagingSource = new ClipPageDataSource();
        PagingConfig pagingConfig = new PagingConfig(
                10,   // Number of items to load per page
                3,    // Prefetch distance
                false // Disable placeholders
        );

        // Create a Pager to handle the data flow and convert it into PagingData
//        clips = new Pager<>(
//                pagingConfig,
//                () -> pagingSource
//        ).getLiveData();


    }

    public static class Factory implements ViewModelProvider.Factory {

        private final boolean mowner;
        @NonNull private final Bundle mParams;

        public Factory(@NonNull Bundle params, boolean ads) {
            mParams = params;
            mowner = ads;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return (T)new PlayerSliderFragmentViewModel(mParams, mowner);
        }
    }
}
