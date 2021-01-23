package com.nosin.wr.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.nosin.wr.R;

import java.util.ArrayList;

public class ImageSlidingAdapter extends PagerAdapter {

    private ArrayList <String> images = new ArrayList<>();

    private LayoutInflater layoutInflater;
    private Context mContext;
    private int currentPos = 0;

    @Override
    public int getCount() {
        return images.size();
    }

    public ImageSlidingAdapter(Context ctx) {
        this.mContext = ctx;
        images.add("https://tinyurl.com/y3w8oaah");
        images.add("https://tinyurl.com/y4vaulog");
        images.add("https://tinyurl.com/y3j7rq6g");
        images.add("https://tinyurl.com/y28jpmyr");
        images.add("https://tinyurl.com/y2w7fbdo");
        images.add("https://tinyurl.com/yy2f6lha");


    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        if (currentPos > 3)
//            currentPos = 0;

        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        Glide.with(mContext)
                .load(images.get(position))
                .into(imageView);
        container.addView(itemView);
//        currentPos++;
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
