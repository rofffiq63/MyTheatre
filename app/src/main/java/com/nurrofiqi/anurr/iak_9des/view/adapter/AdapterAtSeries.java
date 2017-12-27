package com.nurrofiqi.anurr.iak_9des.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtSeries;
import com.nurrofiqi.anurr.iak_9des.view.ActivityDetail;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by anurr on 12/9/2017.
 */

public class AdapterAtSeries extends RecyclerView.Adapter<AdapterAtSeries.ViewHolder> {

    Context context;
    List<PojoAtSeries.ResultsBean> data;
    int type;

    public static final int ITEM_TYPE_NORMAL = 0;
    public static final int ITEM_TYPE_RECOMMENDED = 1;

    public AdapterAtSeries(Context applicationContext, ArrayList<PojoAtSeries.ResultsBean> seriesData, int viewType) {
        this.context = applicationContext;
        this.data = seriesData;
        this.type = viewType;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == data.size()) ? R.layout.item_more : R.layout.item_main;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (type == ITEM_TYPE_NORMAL) {
            if (viewType == R.layout.item_main) {
                View normalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
                return new NormalSeriesView(normalView);
            } else {
                View moreView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_more, parent, false);
                return new MoreView(moreView);
            }
        } else if (type == ITEM_TYPE_RECOMMENDED) {
            View recommendedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend, parent, false);
            return new RecommendedSeriesView(recommendedView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position == data.size()) {

        } else {
            final PojoAtSeries.ResultsBean listitem = data.get(position);
            if (type == ITEM_TYPE_NORMAL) {
                double voteAvg = listitem.getVote_average();
                int voteCount = listitem.getVote_count();
                //String pop = String.valueOf(listitem.getPopularity());
                //pop = pop.substring(0, 4);

                float rating;
                rating  = Float.valueOf(String.valueOf(voteAvg));
                rating = rating/2;

                String oriDate = listitem.getFirst_air_date();
                if (oriDate.length() >= 4) {
                    oriDate = oriDate.substring(0, 4);
                }
                String overview = listitem.getOverview();
                final boolean[] opened = {false};

                final int[] count = {0};
                SweetAlertDialog sweetAlertDialog;
                String poster = "http://image.tmdb.org/t/p/w342" + listitem.getPoster_path();

                ((NormalSeriesView) holder).judul.setText(listitem.getOriginal_name());
                ((NormalSeriesView) holder).rating.setText(String.valueOf(new DecimalFormat("#.0").format(rating)));
                ((NormalSeriesView) holder).mvote.setText(String.valueOf(voteCount));
                ((NormalSeriesView) holder).mdate.setText(oriDate + " tv series");
                ((NormalSeriesView) holder).mgenre.setText(String.valueOf(listitem.getGenre_ids()));
                //holder.mpop.setText(pop);
                ((NormalSeriesView) holder).moverview.setText(overview);

                Glide.with(context)
                        .load(poster)
                        .into(((NormalSeriesView) holder).poster);

                final String finalOriDate = oriDate;
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toDetail = new Intent(context, ActivityDetail.class);
                        toDetail.putExtra("ids", listitem.getId());
                        toDetail.putExtra("title", listitem.getOriginal_name());
                        toDetail.putExtra("tahun", finalOriDate);
                        toDetail.putExtra("overview", listitem.getOverview());
                        toDetail.putExtra("backdrop", listitem.getBackdrop_path());
                        toDetail.putExtra("poster", listitem.getPoster_path());
                        v.getContext().startActivity(toDetail);
                    }
                });
            } else if (type == ITEM_TYPE_RECOMMENDED) {

                String poster = "http://image.tmdb.org/t/p/w342" + listitem.getPoster_path();
                String judul = listitem.getOriginal_name();
                String tahun = listitem.getFirst_air_date();

                if (tahun != null) {
                    tahun = tahun.substring(0, 4);
                }

                String rate = String.valueOf(listitem.getVote_average());

                Glide.with(context)
                        .load(poster)
                        .crossFade()
                        .into(((RecommendedSeriesView) holder).poster);

                final String finalTahun = tahun;
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toDetail = new Intent(context, ActivityDetail.class);
                        toDetail.putExtra("ids", listitem.getId());
                        toDetail.putExtra("title", listitem.getOriginal_name());
                        toDetail.putExtra("overview", listitem.getOverview());
                        toDetail.putExtra("tahun", finalTahun);
                        toDetail.putExtra("backdrop", listitem.getBackdrop_path());
                        toDetail.putExtra("poster", listitem.getPoster_path());
                        v.getContext().startActivity(toDetail);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if (type == ITEM_TYPE_RECOMMENDED) {
            return (null != data ? data.size() : 0);
        } else {
            return (null != data ? data.size() + 1 : 0);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class NormalSeriesView extends ViewHolder {

        TextView judul, rating, mdate, mgenre, mvote, moverview;
        ImageView poster;

        public NormalSeriesView(View normalView) {
            super(normalView);
            judul = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
            mdate = itemView.findViewById(R.id.date);
            mgenre = itemView.findViewById(R.id.genre);
            mvote = itemView.findViewById(R.id.totalvote);
            poster = itemView.findViewById(R.id.poster);
            moverview = itemView.findViewById(R.id.overview);
        }
    }

    private class RecommendedSeriesView extends ViewHolder {

        ImageView poster;

        public RecommendedSeriesView(View recommendedView) {
            super(recommendedView);
            poster = itemView.findViewById(R.id.poster);
        }
    }

    private class MoreView extends ViewHolder {

        public MoreView(View itemView) {
            super(itemView);
        }
    }
}
