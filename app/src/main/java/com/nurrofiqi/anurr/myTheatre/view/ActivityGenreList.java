package com.nurrofiqi.anurr.myTheatre.view;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterGenreList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityGenreList extends AppCompatActivity implements MainActivityContract.View {

    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.genrelist)
    RecyclerView genreList;
    @BindView(R.id.progress)
    RelativeLayout progress;
    @BindView(R.id.collapsingtoolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    MainActivityPresenter mainActivityPresenter;
    AdapterGenreList adapterGenreList;
    ArrayList<PojoGenreList.ResultsBean> genrelistData;
    String API_KEY = "dc06aa24248daf1a618d531314fe6a04";
    int ids;
    int pages = 1;
    String genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_list);
        ButterKnife.bind(this);

        mainActivityPresenter = new MainActivityPresenter(MainActivityRepoInject.provideToMainRepo(this));
        mainActivityPresenter.onAttachView(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ids = getIntent().getIntExtra("genreid", 0);
        genre = getIntent().getStringExtra("genrename");
        Toast.makeText(this, genre + ids, Toast.LENGTH_SHORT).show();
        getSupportActionBar().setTitle(genre);
        genrelistData = new ArrayList<>();
        adapterGenreList = new AdapterGenreList(this, genrelistData);
        adapterGenreList.setLoadMoreListener(new AdapterGenreList.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                genreList.post(new Runnable() {
                    @Override
                    public void run() {
//                        int index = genrelistData.size() + 1;
//                        loadMore(index);
//                        getData();
                    }
                });
            }
        });
        getData();
        genreList.setAdapter(adapterGenreList);
    }

    private void loadMore(int index) {

        //add loading progress view
        genrelistData.add(new PojoGenreList.ResultsBean("load"));
        adapterGenreList.notifyItemInserted(genrelistData.size() - 1);
    }

    private void getData() {
        String url = "https://api.themoviedb.org/3/genre/" + String.valueOf(ids) + "/movies?api_key=" +
                API_KEY + "&language=en-US&include_adult=false&sort_by=created_at.desc&page=" + String.valueOf(pages);
        mainActivityPresenter.setLink(url, 123);
    }

    @Override
    public void successMainSeries(List<PojoAtSeries.ResultsBean> mainseriesdata, int id) {

    }

    @Override
    public void successMainMovies(List<PojoAtMovies.ResultsBean> mainmoviesdata, int id) {

    }

    @Override
    public void successDetail(int id, int budget, List<PojoDetail.GenresBean> genres, List<PojoDetail.ProductionCompaniesBean> product, String homepage, String original_title, String title, String overview, double popularity, String poster, String backdrop, String date, int revenue, int runtime, String status, String tagline, double rate, int vote, String language, List<PojoDetail.ImagesBean.BackdropsBean> backdropsdata, List<PojoDetail.ImagesBean.PostersBean> posterdata, List<PojoDetail.VideosBean.ResultsBean> videosdata) {

    }

    @Override
    public void successCast(List<PojoCast.CastBean> castdata, List<PojoPopCast.ResultsBean> popcastdata, int id) {

    }

    @Override
    public void successGenre(List<PojoGenre.GenresBean> genredata) {

    }

    @Override
    public void successOnSearch(List<PojoMultiSearch.ResultsBean> searchdata) {

    }

    @Override
    public void successReview(List<PojoReviews.ResultsBean> reviewdata) {

    }

    @Override
    public void successGenreList(List<PojoGenreList.ResultsBean> genrelistdata) {
        this.genrelistData.addAll(genrelistdata);
        adapterGenreList.notifyDataSetChanged();
        progress.setVisibility(View.GONE);
        int index = genrelistData.size() - 1;
        loadMore(index);
        pages++;
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
