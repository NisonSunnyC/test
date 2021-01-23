package com.nosin.wr.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nosin.wr.R;
import com.nosin.wr.ui.model.Product;

import java.util.ArrayList;


public class ProductsRecycleAdapter extends RecyclerView.Adapter<ProductsRecycleAdapter.ProductItemHolder> {

    private ArrayList<Product> itemsList;
    private Context mContext;

    public ProductsRecycleAdapter(Context context, ArrayList<Product> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public ProductItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vertical_recycler_item, null);
     ProductItemHolder productItemHolder = new ProductItemHolder(v);
        return productItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductItemHolder holder, int position) {
        Product product = itemsList.get(position);


        holder.tvName.setText(product.getName());
        holder.tvOffer.setText(product.getOffer());
        Glide.with(mContext)
                .load(product.getImgUrl()).override(400,400)
                .into(holder.productImage);
    }



    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class ProductItemHolder extends RecyclerView.ViewHolder {

        protected TextView tvName;
        protected TextView tvOffer;
        protected ImageView productImage;


        public ProductItemHolder(View view) {
            super(view);

            this.tvName = (TextView) view.findViewById(R.id.tv_name);
            this.tvOffer = (TextView) view.findViewById(R.id.tv_offer);
            this.productImage = (ImageView) view.findViewById(R.id.iv_product);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), tvName.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}