package com.nurrofiqi.anurr.iak_9des.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoDetail;
import com.nurrofiqi.anurr.iak_9des.model.PojoGenre;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtMovies;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtSeries;
import com.nurrofiqi.anurr.iak_9des.model.PojoMultiSearch;
import com.nurrofiqi.anurr.iak_9des.presenter.MainActivityContract;
import com.nurrofiqi.anurr.iak_9des.presenter.MainActivityPresenter;
import com.nurrofiqi.anurr.iak_9des.presenter.MainActivityRepoInject;
import com.nurrofiqi.anurr.iak_9des.view.adapter.AdapterAtMovies;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anurr on 12/16/2017.
 */

public class ActivityDetail extends AppCompatActivity implements MainActivityContract.View {

    @BindView(R.id.similiarlist) RecyclerView similiarList;
    @BindView(R.id.toolbar) Toolbar mtoolbar;
    @BindView(R.id.progressholder) RelativeLayout progressHolder;
    @BindView(R.id.contentholder) LinearLayout contentHolder;
    @BindView(R.id.poster) ImageView mposter;
    @BindView(R.id.backdrop) ImageView mbackdrop;
    @BindView(R.id.title) TextView mtitle;
    @BindView(R.id.subtitle) TextView subtitle;
    @BindView(R.id.overview) TextView moverview;
    @BindView(R.id.genres) TextView mgenres;
    @BindView(R.id.rating) TextView mrate;
    @BindView(R.id.vote) TextView mvote;
    @BindView(R.id.ratingbar) RatingBar ratingBar;

    ArrayList<PojoAtMovies.ResultsBean> similiarData;
    AdapterAtMovies adapterSimiliar;
    MainActivityPresenter mPresenter;

    String API_KEY = "dc06aa24248daf1a618d531314fe6a04";
    String simliarUrl, detailurl;

    private static final int DETAIL_MOVIES = 9;

    int ids;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        initiateView();

    }

    private void initiateView() {

        progressHolder.setVisibility(View.VISIBLE);
        contentHolder.setVisibility(View.GONE);

        mPresenter = new MainActivityPresenter(MainActivityRepoInject.provideToMainRepo(getApplicationContext()));
        mPresenter.onAttachView(this);

        ids = getIntent().getExtras().getInt("ids");

        simliarUrl = "https://api.themoviedb.org/3/movie/" + String.valueOf(ids) + "/similar?api_key=" + API_KEY + "&language=en-US&page=1";
        detailurl = "https://api.themoviedb.org/3/movie/" + ids + "?api_key=dc06aa24248daf1a618d531314fe6a04&language=en-US";

        mPresenter.setLink(detailurl, DETAIL_MOVIES);

        similiarData = new ArrayList<>();
        adapterSimiliar = new AdapterAtMovies(this, similiarData, 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        similiarList.setLayoutManager(linearLayoutManager);
        similiarList.setAdapter(adapterSimiliar);
        mPresenter.setLink(simliarUrl, 1);

    }

    @Override
    public void successMainSeries(List<PojoAtSeries.ResultsBean> mainseriesdata, int id) {

    }

    @Override
    public void successMainMovies(List<PojoAtMovies.ResultsBean> mainmoviesdata, int id) {
        this.similiarData.addAll(mainmoviesdata);
        adapterSimiliar.notifyDataSetChanged();
    }

    @Override
    public void successDetail(int id, int budget, List<PojoDetail.GenresBean> genres,
                              String homepage, String original_title, String title,
                              String overview, double popularity, String poster, String backdrop,
                              String date, int revenue, int runtime, String status, String tagline,
                              double rate, int vote, String language) {

        String item;
        final String[] arraygenres = new String[genres.size()];
        for (int i = 0; i < arraygenres.length; i++) {
            PojoDetail.GenresBean listgenres = genres.get(i);
            item = listgenres.getName();
            arraygenres[i] = item;
        }

        float rating;
        rating  = Float.valueOf(String.valueOf(rate));
        rating = rating/2;

        if (runtime!=0){
            subtitle.setText(status + " - " + date + "\n" + String.valueOf(runtime) + " minutes \n" + language.toUpperCase());
        } else {
            subtitle.setText(status + "\nscheduled release " + date + "\n" + language.toUpperCase());
        }

        if (rate!=0){
            mrate.setText(new DecimalFormat("0.0").format(rating));
        } else {
            mrate.setText("Not Rated");
        }

        mtitle.setText(title);
        moverview.setText(overview);
        mgenres.setText(TextUtils.join(", ", arraygenres));
        ratingBar.setRating(rating);
        mvote.setText(String.valueOf(vote));

        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setTitle("");

        Glide.with(this)
                .load("http://image.tmdb.org/t/p/w342" + poster)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressHolder.setVisibility(View.GONE);
                        contentHolder.setVisibility(View.VISIBLE);
                        return false;
                    }
                })
                .into(mposter);

        Glide.with(this)
                .load("http://image.tmdb.org/t/p/original" + backdrop)
                .into(mbackdrop);
    }

    @Override
    public void successGenre(List<PojoGenre.GenresBean> genredata) {

    }

    @Override
    public void successOnSearch(List<PojoMultiSearch.ResultsBean> searchdata) {

    }

    @Override
    public void onError(String msg) {

    }
}