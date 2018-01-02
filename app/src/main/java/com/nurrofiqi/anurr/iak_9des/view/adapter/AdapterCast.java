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
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoCast;

import java.util.List;

/**
 * Created by anurr on 1/2/2018.
 */

public class AdapterCast extends RecyclerView.Adapter<AdapterCast.ViewHolder> {

    Context context;
    List<PojoCast.CastBean> castData;

    public AdapterCast(Context context, List<PojoCast.CastBean> castdata) {
        this.context = context;
        this.castData = castdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PojoCast.CastBean listitem = castData.get(position);
        String url = "http://image.tmdb.org/t/p/w185" + listitem.getProfile_path();

        Glide.with(context)
                .load(url)
                .crossFade()
                .into(holder.castPic);

        holder.castName.setText(Html.fromHtml("<b>" + listitem.getName() + "</b><br>as " + listitem.getCharacter()));

    }

    @Override
    public int getItemCount() {
        return castData.size();
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
