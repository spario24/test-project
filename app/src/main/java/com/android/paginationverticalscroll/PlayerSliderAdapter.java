package com.android.paginationverticalscroll;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.paging.AsyncPagingDataDiffer;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.android.paginationverticalscroll.fragments.ReelFragment;

public class PlayerSliderAdapter  extends FragmentStateAdapter {

    private final AsyncPagingDataDiffer<ReelModel> mDiffer;
    Lifecycle lifecycle;

    DiffUtilCallback<ReelModel> diff = new DiffUtilCallback<>(o -> o.id);

    public PlayerSliderAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.lifecycle = lifecycle;
        mDiffer = new AsyncPagingDataDiffer<>(
                new DiffUtil.ItemCallback<ReelModel>() {

                    @Override
                    public boolean areItemsTheSame(@NonNull ReelModel oldItem, @NonNull ReelModel newItem) {
                        return oldItem.id==newItem.id;
                    }

                    @Override
                    public boolean areContentsTheSame(@NonNull ReelModel oldItem, @NonNull ReelModel newItem) {
                        return oldItem.equals(newItem);
                    }
                },
                new ListUpdateCallback() {
                    @Override
                    public void onInserted(int position, int count) {
                        // Handle item insertions
                        notifyItemRangeInserted(position, count);
                    }

                    @Override
                    public void onRemoved(int position, int count) {
                        // Handle item removals
                        notifyItemRangeRemoved(position, count);
                    }

                    @Override
                    public void onMoved(int fromPosition, int toPosition) {
                        // Handle item moves
                        notifyItemMoved(fromPosition, toPosition);
                    }

                    @Override
                    public void onChanged(int position, int count, @Nullable Object payload) {
                        // Handle item changes
                        notifyItemRangeChanged(position, count, payload);
                    }
                }
        );
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ReelFragment.newInstance("","");
    }

    public ReelModel getItem(int position) {
        return mDiffer.getItem(position);
    }

    @Override
    public int getItemCount() {
        return mDiffer.getItemCount();
    }

    public void submitData(PagingData<ReelModel> pagingData) {
        mDiffer.submitData(lifecycle, pagingData);
    }
}
