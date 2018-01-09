package com.nurrofiqi.anurr.myTheatre.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nurrofiqi.anurr.myTheatre.R;
import com.nurrofiqi.anurr.myTheatre.model.PojoDetail;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 12/13/2017.
 */

public class AdapterGenres extends RecyclerView.Adapter<AdapterGenres.ViewHolder> {

    private Context context;
    private List<PojoGenre.GenresBean> genresBeans;
    private List<PojoDetail.GenresBean> genresdetail;
    private int id;

    public AdapterGenres(Context context, ArrayList<PojoGenre.GenresBean> genre, ArrayList<PojoDetail.GenresBean> genredetail, int id) {
        this.context = context;
        this.genresBeans = genre;
        this.genresdetail = genredetail;
        this.id = id;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_genre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (id == 0) {
            final PojoGenre.GenresBean listitem = genresBeans.get(position);
            String name = listitem.getName().toUpperCase();
            holder.mgenres.setText(name);
        } else {
            final PojoDetail.GenresBean listitem = genresdetail.get(position);
            String name = listitem.getName().toUpperCase();
            holder.mgenres.setText(name);
        }

    }

    @Override
    public int getItemCount() {
        if (id == 0) {
            return (null != genresBeans ? genresBeans.size() : 0);
        } else {
            return (null != genresdetail ? genresdetail.size() : 0);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mgenres;

        public ViewHolder(View itemView) {
            super(itemView);
            mgenres = itemView.findViewById(R.id.genretitle);
        }
    }
}
