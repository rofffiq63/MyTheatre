package com.nurrofiqi.anurr.iak_9des.presenter;

import com.nurrofiqi.anurr.iak_9des.base.BasePresenter;
import com.nurrofiqi.anurr.iak_9des.model.PojoCast;
import com.nurrofiqi.anurr.iak_9des.model.PojoDetail;
import com.nurrofiqi.anurr.iak_9des.model.PojoGenre;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtMovies;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtSeries;
import com.nurrofiqi.anurr.iak_9des.model.PojoMultiSearch;
import com.nurrofiqi.anurr.iak_9des.model.PojoReviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurr on 12/9/2017.
 */

public class MainActivityContract {

    public interface View {

        void successMainSeries(List<PojoAtSeries.ResultsBean> mainseriesdata, int id);

        void successMainMovies(List<PojoAtMovies.ResultsBean> mainmoviesdata, int id);

        void successDetail(int id, int budget, List<PojoDetail.GenresBean> genres, List<PojoDetail.ProductionCompaniesBean> product, String homepage,
                           String original_title, String title, String overview, double popularity,
                           String poster, String backdrop, String date, int revenue, int runtime,
                           String status, String tagline, double rate, int vote, String language, List<PojoDetail.ImagesBean.BackdropsBean> backdropsdata, List<PojoDetail.ImagesBean.PostersBean> posterdata,
                           List<PojoDetail.VideosBean.ResultsBean> videosdata);

        void successCast(List<PojoCast.CastBean> castdata);

        void successGenre(List<PojoGenre.GenresBean> genredata);

        void successOnSearch(List<PojoMultiSearch.ResultsBean> searchdata);

        void successReview(List<PojoReviews.ResultsBean> reviewdata);

        void onError(String msg);

    }

    public interface Presenter extends BasePresenter<View> {

        void setLink(String url, int id);
    }
}
