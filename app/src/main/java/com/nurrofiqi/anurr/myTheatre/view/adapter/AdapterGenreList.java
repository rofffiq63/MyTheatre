package com.nurrofiqi.anurr.myTheatre.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nurrofiqi.anurr.myTheatre.R;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenre;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenreList;

import java.util.List;

/**
 * Created by anurr on 1/17/2018.
 */

public class AdapterGenreList extends RecyclerView.Adapter<AdapterGenreList.ViewHolder> {

    public final int TYPE_MOVIE = 0;
    public final int TYPE_LOAD = 1;

    static Context context;
    List<PojoGenreList.ResultsBean> movies;
    OnLoadMoreListener loadMoreListener;
    boolean isLoading = false, isMoreDataAvailable = true;

    /*
    * isLoading - to set the remote loading and complete status to fix back to back load more call
    * isMoreDataAvailable - to set whether more data from server available or not.
    * It will prevent useless load more request even after all the server data loaded
    * */


    public AdapterGenreList(Context context, List<PojoGenreList.ResultsBean> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public AdapterGenreList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == TYPE_MOVIE) {
            return new MovieHolder(inflater.inflate(R.layout.item_genrelist, parent, false));
        } else {
            return new LoadHolder(inflater.inflate(R.layout.item_loadmore, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(AdapterGenreList.ViewHolder holder, int position) {
        if (position >= getItemCount() - 1 && isMoreDataAvailable && !isLoading && loadMoreListener != null) {
            isLoading = true;
            loadMoreListener.onLoadMore();
        }

        if (getItemViewType(position) == TYPE_MOVIE) {
            ((MovieHolder) holder).tvposition.setText(String.valueOf(position + 1));
            ((MovieHolder) holder).bindData(movies.get(position));
        }
        //No else part needed as load holder doesn't bind any data
    }

    @Override
    public int getItemViewType(int position) {
        if (position <= movies.size()) {
            return TYPE_MOVIE;
        } else {
            return TYPE_LOAD;
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    /* VIEW HOLDERS */

    public class MovieHolder extends AdapterGenreList.ViewHolder {
        TextView tvTitle, tvposition;
        TextView tvRating;

        public MovieHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            tvRating = itemView.findViewById(R.id.rating);
            tvposition = itemView.findViewById(R.id.position);
        }

        void bindData(PojoGenreList.ResultsBean movieModel) {
            tvTitle.setText(movieModel.getTitle());
            tvRating.setText(String.valueOf(movieModel.getVote_average()));
        }
    }

    public class LoadHolder extends AdapterGenreList.ViewHolder {
        public LoadHolder(View itemView) {
            super(itemView);
        }
    }

    public void setMoreDataAvailable(boolean moreDataAvailable) {
        isMoreDataAvailable = moreDataAvailable;
    }

    /* notifyDataSetChanged is final method so we can't override it
         call adapter.notifyDataChanged(); after update the list
         */
    public void notifyDataChanged() {
        notifyDataSetChanged();
        isLoading = false;
    }


    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
