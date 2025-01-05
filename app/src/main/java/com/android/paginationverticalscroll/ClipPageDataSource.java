package com.android.paginationverticalscroll;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;

import kotlin.coroutines.Continuation;

public class ClipPageDataSource extends PagingSource<Integer, ReelModel> {


    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, ReelModel> pagingState) {
        return 0;
    }

    @Nullable
    @Override
    public Object load(@NonNull LoadParams<Integer> loadParams, @NonNull Continuation<? super LoadResult<Integer, ReelModel>> continuation) {
        return null;
    }

//    public static class Factory extends DataSource.Factory<Integer, ReelModel> {
//        private final boolean mowner1;
//
//        public Bundle params;
//
//        public MutableLiveData<ClipPageDataSource> source = new MutableLiveData<>();
//
//        public Factory( Bundle params, boolean mowner) {
//            mowner1 = mowner;
//            this.params = params;
//        }
//
//
//
//        @NonNull
//        @Override
//        public DataSource<Integer, ReelModel> create() {
//            ClipPageDataSource source = new ClipPageDataSource();
//            this.source.postValue(source);
//            return source;
//        }
//    }
}
