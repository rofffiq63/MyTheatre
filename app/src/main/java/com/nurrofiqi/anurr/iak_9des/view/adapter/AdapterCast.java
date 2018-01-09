package com.nurrofiqi.anurr.iak_9des.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoCast;
import com.nurrofiqi.anurr.iak_9des.model.PojoPopCast;
import com.nurrofiqi.anurr.iak_9des.view.CircleGlide;

import java.util.List;

/**
 * Created by anurr on 1/2/2018.
 */

public class AdapterCast extends RecyclerView.Adapter<AdapterCast.ViewHolder> {

    private Context context;
    private List<PojoCast.CastBean> castData;
    private List<PojoPopCast.ResultsBean> popcastData;
    private int id;

    public AdapterCast(Context context, List<PojoCast.CastBean> castdata, List<PojoPopCast.ResultsBean> popcastdata, int id) {
        this.context = context;
        this.castData = castdata;
        this.popcastData = popcastdata;
        this.id = id;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (id==0){
            final PojoCast.CastBean listitem = castData.get(position);
            String url = "http://image.tmdb.org/t/p/w185" + listitem.getProfile_path();

            Glide.with(context)
                    .load(url)
                    .crossFade()
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .bitmapTransform(new CircleGlide(context))
                    .placeholder(R.drawable.ic_account_circle_black_24dp)
                    .into(holder.castPic);

            if (listitem.getCharacter() == null || listitem.getCharacter().length() == 0) {
                holder.castName.setText(Html.fromHtml("<b>" + listitem.getName() + "</b><br>"));
            } else {
                holder.castName.setText(Html.fromHtml("<b>" + listitem.getName() + "</b><br>as " + listitem.getCharacter()));
            }
        } else {
            final PojoPopCast.ResultsBean listitem = popcastData.get(position);
            String url = "http://image.tmdb.org/t/p/w185" + listitem.getProfile_path();

            Glide.with(context)
                    .load(url)
                    .crossFade()
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .bitmapTransform(new CircleGlide(context))
                    .placeholder(R.drawable.ic_account_circle_black_24dp)
                    .into(holder.castPic);

            holder.castName.setText(Html.fromHtml("<b>" + listitem.getName() + "</b><br>"));
        }
    }

    @Override
    public int getItemCount() {
        if (id == 0){
            return castData.size();
        } else {
            return popcastData.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView castPic;
        TextView castName;

        public ViewHolder(View itemView) {
            super(itemView);
            castPic = itemView.findViewById(R.id.castpic);
            castName = itemView.findViewById(R.id.castname);
        }
    }
}
