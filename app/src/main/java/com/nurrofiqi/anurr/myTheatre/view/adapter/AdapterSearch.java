package com.nurrofiqi.anurr.myTheatre.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nurrofiqi.anurr.myTheatre.R;
import com.nurrofiqi.anurr.myTheatre.model.PojoMultiSearch;
import com.nurrofiqi.anurr.myTheatre.view.ActivityDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 12/11/2017.
 */

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.ViewHolder> {

    private Context context;
    private List<PojoMultiSearch.ResultsBean> search;

    public AdapterSearch(Context context, ArrayList<PojoMultiSearch.ResultsBean> search) {
        this.context = context;
        this.search = search;
    }

    @Override
    public AdapterSearch.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search, parent, false);
        final AdapterSearch.ViewHolder viewHolder = new AdapterSearch.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterSearch.ViewHolder holder, int position) {
        final PojoMultiSearch.ResultsBean listitem = search.get(position);
        String kind = listitem.getMedia_type();
        String oriDate, poster;

        switch (kind.toLowerCase()) {
            case "movie":
                kind = "film";
                oriDate = listitem.getRelease_date();
                poster = "http://image.tmdb.org/t/p/w185" + listitem.getPoster_path();

                if (!oriDate.isEmpty()) {
                    oriDate = oriDate.substring(0, 4);
                }

                holder.judul.setText(listitem.getTitle());
                holder.tahun.setText(Html.fromHtml(oriDate + " " + kind));

                Glide.with(context)
                        .load(poster)
                        .into(holder.smallposter);
                break;

            case "tv":
                kind = "tv series";
                oriDate = listitem.getFirst_air_date();
                poster = "http://image.tmdb.org/t/p/w185" + listitem.getPoster_path();

                if (!oriDate.isEmpty()) {
                    oriDate = oriDate.substring(0, 4);
                }

                holder.judul.setText(listitem.getOriginal_name());
                holder.tahun.setText(Html.fromHtml(oriDate + " " + kind));

                Glide.with(context)
                        .load(poster)
                        .placeholder(R.drawable.ic_date_range_black_24dp)
                        .into(holder.smallposter);
                break;

            case "person":
                poster = "http://image.tmdb.org/t/p/w185" + listitem.getProfile_path();

                holder.judul.setText(listitem.getName());
                holder.tahun.setText(Html.fromHtml(kind));

                Glide.with(context)
                        .load(poster)
                        .placeholder(R.drawable.ic_person_black_24dp)
                        .into(holder.smallposter);
        }

        final String mediatype = listitem.getMedia_type().toUpperCase();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDetail = new Intent(context, ActivityDetail.class);
                toDetail.putExtra("ids", listitem.getId());
                toDetail.putExtra("media", mediatype);
                v.getContext().startActivity(toDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (search.size() > 5) {
            return (null != search ? 5 : 0);
        } else {
            return (null != search ? search.size() : 0);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView judul, tahun;
        ImageView smallposter;

        public ViewHolder(View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            tahun = itemView.findViewById(R.id.tahun);
            smallposter = itemView.findViewById(R.id.smallposter);
        }
    }
}
