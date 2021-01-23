package com.nosin.wr.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.appbar.AppBarLayout;
import com.nosin.wr.R;
import com.nosin.wr.ui.adapter.AutoFitGridLayoutManager;
import com.nosin.wr.ui.adapter.ImageSlidingAdapter;
import com.nosin.wr.ui.adapter.ProductsRecycleAdapter;
import com.nosin.wr.ui.model.Product;

import java.util.ArrayList;
import java.util.Timer;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {

    private View rootView;
    private AppBarLayout searchBar;
    private ImageView ivSearch;
    private ImageView ivBack;
    private ViewPager viewPager;
    private ImageSlidingAdapter imageSlidingAdapter;
    private NestedScrollView nestedScrollView;
    private int current_pos = 0;
    private int current_dots_pos = 0;
    int[] images = null;
    Timer timer;
    private LinearLayout dotsContainer;
    private ProductsRecycleAdapter recyclerViewDataAdapter;
    RecyclerView recyclerView;


    public homeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        return rootView;
    }

    private void init() {
        searchBar = rootView.findViewById(R.id.search_bar_layout);
        ivBack = rootView.findViewById(R.id.iv_back);
        viewPager = rootView.findViewById(R.id.viewPager);
        images = new int[]{R.drawable.abcd, R.drawable.home, R.drawable.cdef, R.drawable.drop};
        dotsContainer = rootView.findViewById(R.id.dotsContainer);
        imageSlidingAdapter = new ImageSlidingAdapter(getActivity());
        viewPager.setAdapter(imageSlidingAdapter);
        nestedScrollView = (NestedScrollView) rootView.findViewById(R.id.nested_scrollview);
        nestedScrollView.setFillViewport(true);
        recyclerView = rootView.findViewById(R.id.vertical_recyclerview);
//        createSlideShow();
        prepareDots(current_dots_pos);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (current_dots_pos > 3)
                    current_dots_pos = 0;
                prepareDots(position);
                current_dots_pos++;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(getActivity(), 500);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewDataAdapter = new ProductsRecycleAdapter(getActivity(),getProductDataSet());
        recyclerView.setAdapter(recyclerViewDataAdapter);
    }

    private ArrayList<Product> getProductDataSet() {
        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setName("Shirt1");
        p1.setOffer("Min 50% off");
        p1.setImgUrl("https://tinyurl.com/y4f5e96j");
        products.add(p1);
        Product p2 = new Product();
        p2.setName("Shirt2");
        p2.setOffer("Min 80% off");
        p2.setImgUrl("https://tinyurl.com/y4bfj5b7");
        products.add(p2);
        Product p3 = new Product();
        p3.setName("Shirt3");
        p3.setOffer("Min 60% off");
        p3.setImgUrl("https://tinyurl.com/y44marw5");
        products.add(p3);
        Product p4 = new Product();
        p4.setName("Shirt4");
        p4.setOffer("Min 30% off");
        p4.setImgUrl("https://tinyurl.com/y4urobx8");
        products.add(p4);
        Product p5 = new Product();
        p5.setName("Shirt5");
        p5.setOffer("Min 60% off");
        p5.setImgUrl("https://tinyurl.com/y2yhf95n");
        products.add(p5);
        Product p6 = new Product();
        p6.setName("Shirt6");
        p6.setOffer("Min 40% off");
        p6.setImgUrl("https://tinyurl.com/y5n467o3");
        products.add(p6);
        Product p7 = new Product();
        p7.setName("Shirt7");
        p7.setOffer("Min 55% off");
        p7.setImgUrl("https://tinyurl.com/yxupqdll");
        products.add(p7);
        return products;
    }

    private void prepareDots(int current_pos) {

        if (dotsContainer.getChildCount() > 0)
            dotsContainer.removeAllViews();

        ImageView dots[] = new ImageView[6];

        for (int i = 0; i < 6; i++) {
            dots[i] = new ImageView(getActivity());
            if (i == current_pos)
                dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dots));
            else
                dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.inactive_dots));

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4, 0, 4, 0);
            dotsContainer.addView(dots[i], layoutParams);

        }

    }


}