package com.android.paginationverticalscroll.corouse2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.android.paginationverticalscroll.databinding.ItemImageBinding;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    ViewPager2 viewPager2;

    int[] array;

    public ImageAdapter(int[] array, ViewPager2 vp) {
        this.array = array;
        viewPager2 = vp;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageHolder(
                ItemImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        holder.bind(array[position]);
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    class ImageHolder extends RecyclerView.ViewHolder {

        ItemImageBinding binding;

        public ImageHolder(@NonNull ItemImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(int res) {
            binding.image.setImageResource(res);
        }
    }
}
