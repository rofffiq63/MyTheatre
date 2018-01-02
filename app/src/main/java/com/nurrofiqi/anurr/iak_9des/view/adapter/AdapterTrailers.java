package com.nurrofiqi.anurr.iak_9des.view.adapter;

import android.animation.LayoutTransition;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 1/1/2018.
 */

public class AdapterTrailers extends RecyclerView.Adapter<AdapterTrailers.ViewHolder> {

    Context context;
    List<PojoDetail.VideosBean.ResultsBean> videosdata;

    public AdapterTrailers(Context applicationContext, ArrayList<PojoDetail.VideosBean.ResultsBean> videosdata) {
        this.context = applicationContext;
        this.videosdata = videosdata;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trailers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final String KEY;
//        final String API_KEY = "AIzaSyDK3EVw7otmvqRnhOeDXDbjyGZjJX8ZJ1Q";
        final PojoDetail.VideosBean.ResultsBean itemlist = videosdata.get(position);
        KEY = itemlist.getKey();

        final String YOUTUBE_URL = "https://www.youtube.com/watch?v=" + KEY;
        String[] strUrlText = YOUTUBE_URL.split("=");
        String strURL = "http://img.youtube.com/vi/" + strUrlText[1] + "/hqdefault.jpg";

        Glide.with(context)
                .load(strURL)
                .crossFade()
                .into(holder.youtubethubmnail);
        holder.trailername.setText(itemlist.getName());

        holder.youtubethubmnail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, itemlist.getName() + " " + itemlist.getSite(), Toast.LENGTH_SHORT).show();
                watchYoutubeVideo(context, KEY);
//                Intent in = new Intent(context, Youtube_Player_Activity.class);
//                in.putExtra("URL", YOUTUBE_URL);
//                context.startActivity(in);
            }
        });
    }

    public static void watchYoutubeVideo(Context context, String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            appIntent.putExtra("force_fullscreen", true);
            context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            webIntent.putExtra("force_fullscreen", true);
            context.startActivity(webIntent);
        }
    }

    @Override
    public int getItemCount() {
        return videosdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView youtubethubmnail;
        TextView trailername;

        public ViewHolder(View itemView) {
            super(itemView);

            youtubethubmnail = itemView.findViewById(R.id.youtubethumbnail);
            trailername = itemView.findViewById(R.id.trailername);

        }
    }
}
