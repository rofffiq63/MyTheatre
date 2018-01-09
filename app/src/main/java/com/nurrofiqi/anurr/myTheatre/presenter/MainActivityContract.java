package com.nurrofiqi.anurr.myTheatre.presenter;

import com.nurrofiqi.anurr.myTheatre.base.BasePresenter;
import com.nurrofiqi.anurr.myTheatre.model.PojoCast;
import com.nurrofiqi.anurr.myTheatre.model.PojoDetail;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenre;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtMovies;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtSeries;
import com.nurrofiqi.anurr.myTheatre.model.PojoMultiSearch;
import com.nurrofiqi.anurr.myTheatre.model.PojoPopCast;
import com.nurrofiqi.anurr.myTheatre.model.PojoReviews;

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

        void successCast(List<PojoCast.CastBean> castdata, List<PojoPopCast.ResultsBean> popcastdata, int id);

        void successGenre(List<PojoGenre.GenresBean> genredata);

        void successOnSearch(List<PojoMultiSearch.ResultsBean> searchdata);

        void successReview(List<PojoReviews.ResultsBean> reviewdata);

        void onError(String msg);

    }

    public interface Presenter extends BasePresenter<View> {

        void setLink(String url, int id);
    }
}
