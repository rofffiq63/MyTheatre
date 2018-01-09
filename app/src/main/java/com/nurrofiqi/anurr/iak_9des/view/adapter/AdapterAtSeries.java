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
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
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

    private Context context;
    private List<PojoAtSeries.ResultsBean> data;
    private int type;
    private String media;

    public static final int ITEM_TYPE_NORMAL = 0;
    public static final int ITEM_TYPE_RECOMMENDED = 1;

    public AdapterAtSeries(Context applicationContext, ArrayList<PojoAtSeries.ResultsBean> seriesData, int viewType) {
        this.context = applicationContext;
        this.data = seriesData;
        this.type = viewType;
        media = "TV SERIES";
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
                rating = Float.valueOf(String.valueOf(voteAvg));
                rating = rating / 2;

                String oriDate = listitem.getFirst_air_date();
                if (oriDate.length() >= 4) {
                    oriDate = oriDate.substring(0, 4);
                }
                String overview = listitem.getOverview();
                final boolean[] opened = {false};

                final int[] count = {0};
                SweetAlertDialog sweetAlertDialog;
                String poster = "http://image.tmdb.org/t/p/w342" + listitem.getPoster_path();

                ((NormalSeriesView) holder).judul.setText(listitem.getName());
                ((NormalSeriesView) holder).mdate.setText(oriDate + " tv series");

                Glide.with(context)
                        .load(poster)
                        .into(((NormalSeriesView) holder).poster);

                final String finalOriDate = oriDate;
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toDetail = new Intent(context, ActivityDetail.class);
                        toDetail.putExtra("ids", listitem.getId());
                        toDetail.putExtra("media", media);
                        v.getContext().startActivity(toDetail);
                    }
                });
            } else if (type == ITEM_TYPE_RECOMMENDED) {

                String poster = "http://image.tmdb.org/t/p/w1280" + listitem.getBackdrop_path();
                String judul = listitem.getName();
                String tahun = listitem.getFirst_air_date();

                if (tahun != null) {
                    tahun = tahun.substring(0, 4);
                }

                Float rate = (float) listitem.getVote_average();
                rate = rate / 2;

                ((RecommendedSeriesView) holder).judul.setText(judul);
                ((RecommendedSeriesView) holder).rating.setText(new DecimalFormat("0.0").format(rate));
                ((RecommendedSeriesView) holder).ratingBar.setRating(rate);
                ((RecommendedSeriesView) holder).positiontext.setText(String.valueOf(position + 1) + "/" + data.size());

                Glide.with(context)
                        .load(poster)
                        .crossFade()
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                ((RecommendedSeriesView) holder).progressBar.setVisibility(View.GONE);
                                return false;
                            }
                        })
                        .into(((RecommendedSeriesView) holder).poster);

                final String finalTahun = tahun;
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toDetail = new Intent(context, ActivityDetail.class);
                        toDetail.putExtra("ids", listitem.getId());
                        toDetail.putExtra("media", media);
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
            return (null != data ? data.size() : 0);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class NormalSeriesView extends ViewHolder {

        TextView judul, mdate;
        ImageView poster;

        public NormalSeriesView(View normalView) {
            super(normalView);
            judul = itemView.findViewById(R.id.title);
            mdate = itemView.findViewById(R.id.date);
            poster = itemView.findViewById(R.id.poster);

        }
    }

    private class RecommendedSeriesView extends ViewHolder {

        ImageView poster;
        TextView judul, rating, positiontext;
        RatingBar ratingBar;
        ProgressBar progressBar;

        public RecommendedSeriesView(View recommendedView) {
            super(recommendedView);

            poster = itemView.findViewById(R.id.poster);
            judul = itemView.findViewById(R.id.judul);
            rating = itemView.findViewById(R.id.rate);
            ratingBar = itemView.findViewById(R.id.ratingbar);
            positiontext = itemView.findViewById(R.id.position);
            progressBar = itemView.findViewById(R.id.itemprogress);
        }
    }

    private class MoreView extends ViewHolder {

        public MoreView(View itemView) {
            super(itemView);
        }
    }
}
