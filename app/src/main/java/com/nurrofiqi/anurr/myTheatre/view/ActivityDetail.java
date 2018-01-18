package com.nurrofiqi.anurr.myTheatre.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.nurrofiqi.anurr.myTheatre.R;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtMovies;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtSeries;
import com.nurrofiqi.anurr.myTheatre.model.PojoCast;
import com.nurrofiqi.anurr.myTheatre.model.PojoDetail;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenre;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenreList;
import com.nurrofiqi.anurr.myTheatre.model.PojoMultiSearch;
import com.nurrofiqi.anurr.myTheatre.model.PojoPopCast;
import com.nurrofiqi.anurr.myTheatre.model.PojoReviews;
import com.nurrofiqi.anurr.myTheatre.presenter.MainActivityContract;
import com.nurrofiqi.anurr.myTheatre.presenter.MainActivityPresenter;
import com.nurrofiqi.anurr.myTheatre.presenter.MainActivityRepoInject;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterAtMovies;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterBackdrops;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterCast;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterGenres;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterReviews;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterTrailers;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anurr on 12/16/2017.
 */

public class ActivityDetail extends AppCompatActivity implements MainActivityContract.View {

    @BindView(R.id.similiarlist)
    RecyclerView similiarList;
    @BindView(R.id.reviewlist)
    RecyclerView reviewList;
    @BindView(R.id.trailers)
    RecyclerView trailerlist;
    @BindView(R.id.progressholder)
    RelativeLayout progressHolder;
    @BindView(R.id.poster)
    ImageView mposter;
    @BindView(R.id.backdropdetail)
    RecyclerView backdropList;
    @BindView(R.id.title)
    TextView mtitle;
    @BindView(R.id.synopsis)
    TextView moverview;
    //    @BindView(R.id.genres)
//    TextView mgenres;
    @BindView(R.id.rating)
    TextView mrate;
    @BindView(R.id.vote)
    TextView mvote;
    @BindView(R.id.ratingbardetail)
    RatingBar mratingBar;
    @BindView(R.id.company)
    TextView companies;
    @BindView(R.id.tahun)
    TextView release;
    @BindView(R.id.duration)
    TextView mruntime;
    @BindView(R.id.genres)
    RecyclerView genreslist;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar mtoolbar;
    @BindView(R.id.collapsingtoolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.mediatype)
    TextView mediatype;
    @BindView(R.id.noreview)
    TextView noreview;
    @BindView(R.id.release)
    TextView mrelease;
    @BindView(R.id.castlist)
    RecyclerView castList;
    @BindView(R.id.reviewholder)
    LinearLayout reviewHolder;
    @BindView(R.id.similiarholder)
    LinearLayout simliarholder;

    ArrayList<PojoAtMovies.ResultsBean> similiarData;
    ArrayList<PojoReviews.ResultsBean> reviewsData;
    ArrayList<PojoDetail.GenresBean> genresData;
    ArrayList<PojoDetail.VideosBean.ResultsBean> videosData;
    ArrayList<PojoCast.CastBean> castData;
    ArrayList<PojoDetail.ImagesBean.BackdropsBean> backdropsData;
    AdapterReviews adapterReviews;
    AdapterAtMovies adapterSimiliar;
    AdapterGenres adapterGenres;
    AdapterTrailers adapterTrailers;
    AdapterCast adapterCast;
    AdapterBackdrops adapterBackdrops;
    MainActivityPresenter mPresenter;

    String API_KEY = "dc06aa24248daf1a618d531314fe6a04";
    String simliarUrl, detailurl, reviewsurl, casturl;

    private static final int DETAIL_MOVIES = 9;
    private static final int REVIEWS = 6;

    int ids;
    String media;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        initiateView();

    }

    private void initiateView() {

        progressHolder.setVisibility(View.VISIBLE);

        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mPresenter = new MainActivityPresenter(MainActivityRepoInject.provideToMainRepo(getApplicationContext()));
        mPresenter.onAttachView(this);

        ids = getIntent().getExtras().getInt("ids");
        media = getIntent().getExtras().getString("media");
        mediatype.setText(media);
        collapsingToolbarLayout.setTitle(media);

        simliarUrl = "https://api.themoviedb.org/3/movie/" + ids + "/similar?api_key=" + API_KEY + "&language=en-US&page=1";
        reviewsurl = "https://api.themoviedb.org/3/movie/" + ids + "/reviews?api_key=" + API_KEY + "&language=en-US&page=1";
        detailurl = "https://api.themoviedb.org/3/movie/" + ids + "?api_key=" + API_KEY + "&append_to_response=videos,images";
        casturl = "https://api.themoviedb.org/3/movie/" + ids + "/credits?api_key=" + API_KEY;

        mPresenter.setLink(detailurl, DETAIL_MOVIES);

        similiarData = new ArrayList<>();
        adapterSimiliar = new AdapterAtMovies(this, similiarData, 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        similiarList.setLayoutManager(linearLayoutManager);
        similiarList.setAdapter(adapterSimiliar);

        mPresenter.setLink(simliarUrl, 1);

        reviewsData = new ArrayList<>();
        adapterReviews = new AdapterReviews(this, reviewsData);
        reviewList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        reviewList.setAdapter(adapterReviews);

        mPresenter.setLink(reviewsurl, REVIEWS);

        genresData = new ArrayList<>();
        adapterGenres = new AdapterGenres(this, null, genresData, 1);
        genreslist.setAdapter(adapterGenres);

        videosData = new ArrayList<>();
        adapterTrailers = new AdapterTrailers(this, videosData);
        trailerlist.setAdapter(adapterTrailers);

        backdropsData = new ArrayList<>();
        adapterBackdrops = new AdapterBackdrops(this, backdropsData);
        backdropList.setAdapter(adapterBackdrops);

        castData = new ArrayList<>();
        adapterCast = new AdapterCast(this, castData, null, 0);
        castList.setAdapter(adapterCast);

        mPresenter.setLink(casturl, 999);

        SnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
        SnapHelper snapHelper1 = new LinearSnapHelper();
        SnapHelper snapHelper2 = new GravitySnapHelper(Gravity.START);
        SnapHelper snapHelper3 = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(similiarList);
        snapHelper1.attachToRecyclerView(trailerlist);
        snapHelper2.attachToRecyclerView(castList);
        snapHelper3.attachToRecyclerView(backdropList);

    }

    @Override
    public void successMainSeries(List<PojoAtSeries.ResultsBean> mainseriesdata, int id) {

    }

    @Override
    public void successMainMovies(List<PojoAtMovies.ResultsBean> mainmoviesdata, int id) {
        if (mainmoviesdata.size()==0){
            simliarholder.setVisibility(View.GONE);
        }
        this.similiarData.addAll(mainmoviesdata);
        adapterSimiliar.notifyDataSetChanged();
    }

    @Override
    public void successDetail(int id, int budget, List<PojoDetail.GenresBean> genres,
                              List<PojoDetail.ProductionCompaniesBean> product, String homepage,
                              String original_title, String title, String overview, double popularity,
                              String poster, String backdrop, String date, int revenue, int runtime,
                              String status, String tagline, double rate, int vote, String language,
                              final List<PojoDetail.ImagesBean.BackdropsBean> backdropsdata, List<PojoDetail.ImagesBean.PostersBean> posterdata,
                              List<PojoDetail.VideosBean.ResultsBean> videosdata) {

        String item;
        this.genresData.addAll(genres);
        this.videosData.addAll(videosdata);
        this.backdropsData.addAll(backdropsdata);
        trailerlist.getAdapter().notifyDataSetChanged();
        genreslist.getAdapter().notifyDataSetChanged();
        backdropList.getAdapter().notifyDataSetChanged();
        progressHolder.setVisibility(View.GONE);
        Toast.makeText(this, "Total trailers: " + videosdata.size(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Total backdrops: " + backdropsdata.size(), Toast.LENGTH_SHORT).show();

        final String[] arraycompanies = new String[product.size()];
        for (int i = 0; i < arraycompanies.length; i++) {
            PojoDetail.ProductionCompaniesBean listcompanies = product.get(i);
            item = listcompanies.getName();
            arraycompanies[i] = item;
        }

        if (backdropsdata.size() == 0) {
            collapsingToolbarLayout.setBackgroundColor(getResources().getColor(R.color.appColor));
        }

        float rating;
        rating = Float.valueOf(String.valueOf(rate));
        rating = rating / 2;

        if (rate != 0) {
            mrate.setText(new DecimalFormat("0.0").format(rating));
        } else {
            mrate.setTextSize(12f);
            mrate.setText("Not\nRated");
        }

        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "MMMM dd, YYYY";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date mdate;
        String str = null;

        try {
            mdate = inputFormat.parse(date);
            str = outputFormat.format(mdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mrelease.setText(Html.fromHtml("<b>Release</b><br>" + str));

        if (runtime != 0) {
            date = date.substring(0, 4);
            release.setText(Html.fromHtml(date));
            mruntime.setText(Html.fromHtml("<b>Duration</b> <br>" + runtime + " minutes"));
        } else {
            release.setText(Html.fromHtml(status));
            mruntime.setText(Html.fromHtml("<b>Duration</b> <br>" + status));
        }

        mtitle.setText(title);
        moverview.setText(overview);
//        mgenres.setText(TextUtils.join(", ", arraygenres));1
        companies.setText(Html.fromHtml("<b>Production</b><br>" + TextUtils.join(", ", arraycompanies)));

        mratingBar.setRating(rating);
        mvote.setText(String.valueOf(vote));

        Glide.with(this)
                .load("http://image.tmdb.org/t/p/w342" + poster)
                .into(mposter);

    }

    @Override
    public void successCast(List<PojoCast.CastBean> castdata, List<PojoPopCast.ResultsBean> popcastdata, int id) {
        this.castData.addAll(castdata);
        castList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void successGenre(List<PojoGenre.GenresBean> genredata) {

    }

    @Override
    public void successOnSearch(List<PojoMultiSearch.ResultsBean> searchdata) {

    }

    @Override
    public void successReview(List<PojoReviews.ResultsBean> reviewdata) {
        this.reviewsData.addAll(reviewdata);
        adapterReviews.notifyDataSetChanged();
        if (reviewdata.isEmpty()) {
            reviewHolder.setVisibility(View.GONE);
        } else {
            noreview.setText("See all " + reviewdata.size() + " Reviews");
        }
    }

    @Override
    public void successGenreList(List<PojoGenreList.ResultsBean> genrelistdata) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.share_mark:
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
