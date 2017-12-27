package com.nurrofiqi.anurr.iak_9des.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoGenre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 12/13/2017.
 */

public class AdapterGenres extends RecyclerView.Adapter<AdapterGenres.ViewHolder> {

    Context context;
    List<PojoGenre.GenresBean> genresBeans;

    public AdapterGenres(Context context, ArrayList<PojoGenre.GenresBean> genre) {
        this.context = context;
        this.genresBeans = genre;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_genre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PojoGenre.GenresBean listitem = genresBeans.get(position);
        String name = listitem.getName();
        name = name.toUpperCase();
        holder.mgenres.setText(name);
    }

    @Override
    public int getItemCount() {
        return (null != genresBeans ? genresBeans.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView mgenres;
        public ViewHolder(View itemView) {
            super(itemView);
            mgenres = itemView.findViewById(R.id.genretitle);
        }
    }
}
