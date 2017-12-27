package com.nurrofiqi.anurr.iak_9des.presenter;

import com.nurrofiqi.anurr.iak_9des.model.PojoDetail;
import com.nurrofiqi.anurr.iak_9des.model.PojoGenre;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtSeries;
import com.nurrofiqi.anurr.iak_9des.model.PojoMultiSearch;

import java.util.ArrayList;
import java.util.List;

import static com.nurrofiqi.anurr.iak_9des.model.PojoAtMovies.ResultsBean;

/**
 * Created by anurr on 12/9/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;
    MainActivityContract.Presenter presenter;

    private MainActivityRepositories mainActivityRepositories;

    public MainActivityPresenter(MainActivityRepositories mainActivityRepositories) {

        this.mainActivityRepositories = mainActivityRepositories;
    }

    @Override
    public void setLink(String url, int id) {
        mainActivityRepositories.getDataList(new MainActivityDataResource.MainActivityGetCallBack() {
            @Override
            public void successMainSeries(List<PojoAtSeries.ResultsBean> mainseriesdata, int id) {
                view.successMainSeries(mainseriesdata, id);
            }

            @Override
            public void successMainMovies(List<ResultsBean> mainmoviesdata, int id) {
                view.successMainMovies(mainmoviesdata, id);
            }

            @Override
            public void successDetail(int id, int budget, List<PojoDetail.GenresBean> genres,
                                      String homepage, String original_title, String title,
                                      String overview, double popularity, String poster,
                                      String backdrop, String date, int revenue, int runtime,
                                      String status, String tagline, double rate, int vote, String language) {
                view.successDetail(id, budget, genres, homepage, original_title, title,
                        overview, popularity, poster, backdrop, date, revenue, runtime,
                        status, tagline, rate, vote, language);
            }

            @Override
            public void successGenres(List<PojoGenre.GenresBean> genredata) {
                view.successGenre(genredata);
            }

            @Override
            public void successSearch(List<PojoMultiSearch.ResultsBean> searchdata) {
                view.successOnSearch(searchdata);
            }

            @Override
            public void onError(String msg) {
                view.onError(msg);
            }
        }, url, id);
    }

    @Override
    public void onAttachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void setPresenter(MainActivityContract.View presenter) {
        this.view = presenter;
    }
}
