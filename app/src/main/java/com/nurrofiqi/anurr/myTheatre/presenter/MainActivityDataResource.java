package com.nurrofiqi.anurr.myTheatre.presenter;

import android.support.annotation.NonNull;

import com.nurrofiqi.anurr.myTheatre.model.PojoCast;
import com.nurrofiqi.anurr.myTheatre.model.PojoDetail;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenre;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtMovies;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtSeries;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenreList;
import com.nurrofiqi.anurr.myTheatre.model.PojoMultiSearch;
import com.nurrofiqi.anurr.myTheatre.model.PojoPopCast;
import com.nurrofiqi.anurr.myTheatre.model.PojoReviews;

import java.util.List;

/**
 * Created by anurr on 12/9/2017.
 */

public interface MainActivityDataResource {


    interface MainActivityGetCallBack {

        void successMainSeries(List<PojoAtSeries.ResultsBean> mainseriesdata, int id);

        void successMainMovies(List<PojoAtMovies.ResultsBean> mainmoviesdata, int id);

        void successDetail(int id, int budget, List<PojoDetail.GenresBean> genres, List<PojoDetail.ProductionCompaniesBean> product, String homepage,
                           String original_title, String title, String overview, double popularity,
                           String poster, String backdrop, String date, int revenue, int runtime,
                           String status, String tagline, double rate, int vote, String language, List<PojoDetail.ImagesBean.BackdropsBean> backdropsdata, List<PojoDetail.ImagesBean.PostersBean> posterdata,
                           List<PojoDetail.VideosBean.ResultsBean> videosdata);

        void successGenres(List<PojoGenre.GenresBean> genredata);

        void successCast(List<PojoCast.CastBean> castdata, List<PojoPopCast.ResultsBean> popcastdata, int id);

        void successSearch(List<PojoMultiSearch.ResultsBean> searchdata);

        void successReview(List<PojoReviews.ResultsBean> reviewdata);

        void successGenreList(List<PojoGenreList.ResultsBean> genrelistdata);

        void onError(String msg);

    }

    void getDataList(@NonNull MainActivityGetCallBack mainActivityGetCallBack, String url, int id);

}
