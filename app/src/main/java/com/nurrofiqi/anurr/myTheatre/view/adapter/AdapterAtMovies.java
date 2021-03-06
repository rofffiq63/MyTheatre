package com.nurrofiqi.anurr.myTheatre.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.nurrofiqi.anurr.myTheatre.R;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtMovies;
import com.nurrofiqi.anurr.myTheatre.view.ActivityDetail;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 12/9/2017.
 */

public class AdapterAtMovies extends RecyclerView.Adapter<AdapterAtMovies.ViewHolder> {

    private Context context;
    private List<PojoAtMovies.ResultsBean> data;
    private int type;
    private String media = "MOVIE";

    public static final int ITEM_TYPE_NORMAL = 0;
    public static final int ITEM_TYPE_RECOMMENDED = 1;

    public AdapterAtMovies(Context applicationContext, ArrayList<PojoAtMovies.ResultsBean> moviesData, int layoutType) {
        this.context = applicationContext;
        this.data = moviesData;
        this.type = layoutType;
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
                return new NormalMoviesView(normalView);
            } else {
                View moreView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_more, parent, false);
                return new MoreView(moreView);
            }
        } else if (type == ITEM_TYPE_RECOMMENDED) {
            View recommendedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend, parent, false);
            return new RecommendedMoviesView(recommendedView);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position == data.size()) {

        } else {
            final PojoAtMovies.ResultsBean listitem = data.get(position);
            if (type == ITEM_TYPE_NORMAL) {

                double voteAvg = listitem.getVote_average();
                int voteCount = listitem.getVote_count();

                float rating;
                rating = Float.valueOf(String.valueOf(voteAvg));
                rating = rating / 2;

                String oriDate = listitem.getRelease_date();
                if (oriDate.length() >= 4) {
                    oriDate = oriDate.substring(0, 4);
                }
                String overview = listitem.getOverview();

                String poster = "http://image.tmdb.org/t/p/w342" + listitem.getPoster_path();

                ((NormalMoviesView) holder).judul.setText(listitem.getTitle());
                ((NormalMoviesView) holder).mdate.setText(oriDate + " movie");

                Glide.with(context)
                        .load(poster)
                        .fitCenter()
                        .into(((NormalMoviesView) holder).poster);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Movie's id: " + String.valueOf(listitem.getId()), Toast.LENGTH_LONG).show();
                        Intent toDetail = new Intent(context, ActivityDetail.class);
                        toDetail.putExtra("ids", listitem.getId());
                        toDetail.putExtra("media", media);
                        v.getContext().startActivity(toDetail);
                    }
                });
            } else if (type == ITEM_TYPE_RECOMMENDED) {

                String poster = "http://image.tmdb.org/t/p/w1280" + listitem.getBackdrop_path();
                String judul = listitem.getTitle();
                String tahun = listitem.getRelease_date();

                if (tahun != null) {
                    tahun = tahun.substring(0, 4);
                }

                Float rate = (float) listitem.getVote_average();
                rate = rate / 2;

                ((RecommendedMoviesView) holder).judul.setText(judul);
                ((RecommendedMoviesView) holder).rating.setText(new DecimalFormat("0.0").format(rate));
                ((RecommendedMoviesView) holder).ratingBar.setRating(rate);
                ((RecommendedMoviesView) holder).positiontext.setText(String.valueOf(position + 1) + "/" + data.size());

                Glide.with(context)
                        .load(poster)
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                ((RecommendedMoviesView) holder).progressBar.setVisibility(View.GONE);
                                return false;
                            }
                        })
                        .crossFade()
                        .into(((RecommendedMoviesView) holder).poster);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Movie's id: " + String.valueOf(listitem.getId()), Toast.LENGTH_LONG).show();
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
        return (null != data ? data.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }

    private class NormalMoviesView extends ViewHolder {

        TextView judul, mdate;
        ImageView poster;

        public NormalMoviesView(View normalView) {
            super(normalView);
            judul = itemView.findViewById(R.id.title);
            mdate = itemView.findViewById(R.id.date);
            poster = itemView.findViewById(R.id.poster);

        }
    }

    private class RecommendedMoviesView extends ViewHolder {

        ImageView poster;
        TextView judul, rating, positiontext;
        RatingBar ratingBar;
        ProgressBar progressBar;

        public RecommendedMoviesView(View recommendedView) {
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
