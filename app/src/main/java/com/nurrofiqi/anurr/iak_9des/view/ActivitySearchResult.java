package com.nurrofiqi.anurr.iak_9des.view;

import com.nurrofiqi.anurr.iak_9des.model.PojoCast;
import com.nurrofiqi.anurr.iak_9des.model.PojoDetail;
import com.nurrofiqi.anurr.iak_9des.model.PojoGenre;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtMovies;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtSeries;
import com.nurrofiqi.anurr.iak_9des.model.PojoMultiSearch;
import com.nurrofiqi.anurr.iak_9des.model.PojoReviews;
import com.nurrofiqi.anurr.iak_9des.presenter.MainActivityContract;

import java.util.List;

/**
 * Created by anurr on 12/12/2017.
 */

public class ActivitySearchResult implements MainActivityContract.View {


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
    public void successCast(List<PojoCast.CastBean> castdata) {

    }

    @Override
    public void successGenre(List<PojoGenre.GenresBean> genredata) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void successOnSearch(List<PojoMultiSearch.ResultsBean> searchdata) {

    }

    @Override
    public void successReview(List<PojoReviews.ResultsBean> reviewdata) {

    }
}
