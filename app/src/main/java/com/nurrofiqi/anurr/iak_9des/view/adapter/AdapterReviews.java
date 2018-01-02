package com.nurrofiqi.anurr.iak_9des.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoReviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 12/28/2017.
 */

public class AdapterReviews extends RecyclerView.Adapter<AdapterReviews.ViewHolder> {

    Context context;
    List<PojoReviews.ResultsBean> data;

    public AdapterReviews(Context applicationContext, ArrayList<PojoReviews.ResultsBean> reviewsdata) {
        this.context = applicationContext;
        this.data = reviewsdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reviews, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final PojoReviews.ResultsBean itemlist = data.get(position);
        final boolean[] expanded = {false};

        holder.author.setText(Html.fromHtml("<b>" + itemlist.getAuthor() + "</b> said"));
        holder.comment.setText("\"" + itemlist.getContent() + "\"");
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!expanded[0]) {
                    holder.comment.setMaxLines(Integer.MAX_VALUE);
                    holder.comment.setEllipsize(null);
                    expanded[0] = true;
                } else {
                    holder.comment.setMaxLines(5);
                    holder.comment.setEllipsize(TextUtils.TruncateAt.END);
                    expanded[0] = false;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (data.size() > 3) {
            return 3;
        } else {
            return data.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView author, comment;

        public ViewHolder(View itemView) {
            super(itemView);

            author = itemView.findViewById(R.id.author);
            comment = itemView.findViewById(R.id.comment);

        }
    }
}
