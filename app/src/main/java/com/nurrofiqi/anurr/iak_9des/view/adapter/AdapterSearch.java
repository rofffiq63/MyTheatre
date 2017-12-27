package com.nurrofiqi.anurr.iak_9des.view.adapter;

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
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoMultiSearch;
import com.nurrofiqi.anurr.iak_9des.view.ActivityDetail;
import com.nurrofiqi.anurr.iak_9des.view.ActivityMain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 12/11/2017.
 */

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.ViewHolder> {

    Context context;
    List<PojoMultiSearch.ResultsBean> search;

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
        double voteAvg;
        String oriDate = null, poster;

        switch (kind.toLowerCase()){
            case "movie":
                voteAvg = listitem.getVote_average();
                oriDate = listitem.getRelease_date();
                poster = "http://image.tmdb.org/t/p/w185" + listitem.getPoster_path();

                if (!oriDate.isEmpty()){
                    oriDate = oriDate.substring(0, 4);
                }

                holder.judul.setText(listitem.getTitle());
                holder.tahun.setText(Html.fromHtml(oriDate + " " + kind));
                holder.rating.setText(String.valueOf(voteAvg));
                //holder.overview.setText(listitem.getOverview());

                Glide.with(context)
                        .load(poster)
                        .placeholder(R.drawable.ic_movie_black_24dp)
                        .into(holder.smallposter);
                break;

            case "tv":
                kind = "tv series";
                voteAvg = listitem.getVote_average();
                oriDate = listitem.getFirst_air_date();
                poster = "http://image.tmdb.org/t/p/w185" + listitem.getPoster_path();

                if (!oriDate.isEmpty()){
                    oriDate = oriDate.substring(0, 4);
                }

                holder.judul.setText(listitem.getOriginal_name());
                holder.tahun.setText(Html.fromHtml(oriDate + " " + kind));
                holder.rating.setText(String.valueOf(voteAvg));

                Glide.with(context)
                        .load(poster)
                        .placeholder(R.drawable.ic_date_range_black_24dp)
                        .into(holder.smallposter);
                break;

            case "person":
                poster = "http://image.tmdb.org/t/p/w185" + listitem.getProfile_path();

                holder.judul.setText(listitem.getName());
                holder.tahun.setText(Html.fromHtml(kind));
                holder.rating.setText("");

                Glide.with(context)
                        .load(poster)
                        .placeholder(R.drawable.ic_person_black_24dp)
                        .into(holder.smallposter);
        }

        final String finalOriDate = oriDate;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDetail = new Intent(context, ActivityDetail.class);
                toDetail.putExtra("ids", listitem.getId());
                toDetail.putExtra("title", holder.judul.getText());
                toDetail.putExtra("tahun", finalOriDate);
                toDetail.putExtra("overview", listitem.getOverview());
                toDetail.putExtra("backdrop", listitem.getBackdrop_path());
                toDetail.putExtra("poster", listitem.getPoster_path());
                v.getContext().startActivity(toDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != search ? search.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView judul, rating, tahun, overview;
        ImageView smallposter;

        public ViewHolder(View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul);
            rating = itemView.findViewById(R.id.rating);
            tahun = itemView.findViewById(R.id.tahun);
            smallposter = itemView.findViewById(R.id.smallposter);
            overview = itemView.findViewById(R.id.overview);
        }
    }
}
