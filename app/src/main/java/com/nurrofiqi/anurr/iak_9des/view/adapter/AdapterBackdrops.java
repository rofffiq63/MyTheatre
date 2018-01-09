package com.nurrofiqi.anurr.iak_9des.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 1/2/2018.
 */

public class AdapterBackdrops extends RecyclerView.Adapter<AdapterBackdrops.ViewHolder> {

    private Context context;
    private List<PojoDetail.ImagesBean.BackdropsBean> backdropsdata;

    public AdapterBackdrops(Context context, ArrayList<PojoDetail.ImagesBean.BackdropsBean> backdropsdata) {
        this.context = context;
        this.backdropsdata = backdropsdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_backdrops, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PojoDetail.ImagesBean.BackdropsBean listitem = backdropsdata.get(position);
        String poster = "http://image.tmdb.org/t/p/w1280" + listitem.getFile_path();
        Glide.with(context)
                .load(poster)
                .crossFade()
                .into(holder.backdrops);
        holder.counterbackdrops.setText(String.valueOf(position + 1) + "/" + backdropsdata.size());
    }

    @Override
    public int getItemCount() {
        return backdropsdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView backdrops;
        TextView counterbackdrops;

        public ViewHolder(View itemView) {
            super(itemView);

            backdrops = itemView.findViewById(R.id.backdrops);
            counterbackdrops = itemView.findViewById(R.id.counterbackdrops);

        }
    }
}
