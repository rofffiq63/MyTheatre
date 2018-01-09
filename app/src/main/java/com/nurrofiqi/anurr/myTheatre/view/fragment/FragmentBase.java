package com.nurrofiqi.anurr.myTheatre.view.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nurrofiqi.anurr.myTheatre.R;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenre;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtMovies;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtSeries;
import com.nurrofiqi.anurr.myTheatre.model.PojoPopCast;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterCast;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterGenres;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterAtMovies;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterAtSeries;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by anurr on 12/14/2017.
 */

public class FragmentBase extends android.support.v4.app.Fragment {

    static RecyclerView genreList, recommendedList, upcomingList, nowList, popularList, popcastList;

    static ArrayList<PojoAtMovies.ResultsBean> recommendedArray, upArray, nowArray, popArray;
    static ArrayList<PojoAtSeries.ResultsBean> recommendedSeries, onSeries, todaySeries, popSeries;
    static ArrayList<PojoGenre.GenresBean> genreData;
    static ArrayList<PojoPopCast.ResultsBean> popcastData;

    static AdapterAtMovies adapterUpMovies, adapterNowMovies, adapterPopMovies, adapterRecommMovies;
    static AdapterAtSeries adapterOnAirSeries, adapterTodaySeries, adapterPopSeries, adapterRecommSeries;
    static AdapterGenres adapterGenres;
    static AdapterCast adapterCast;

    static LinearLayout nowHolder, popHolder, upHolder, popcastHolder;
    static RelativeLayout recommendedHolder;
    static RelativeLayout progresscircle;

    TextView nowShowing, popular, upcoming, upsubtitle, popsubtitle, nowsubtitle;
    static BottomNavigationViewEx bottomNavigationViewEx;

    String save = "save";
    int NORMAL_LAYOUT = 0;
    int RECOMMENDED_LAYOUT = 1;
    static int resourceready = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, view);

        progresscircle = view.findViewById(R.id.progresscircle);
        upHolder = view.findViewById(R.id.upcominglayout);
        nowHolder = view.findViewById(R.id.nowlayout);
        popHolder = view.findViewById(R.id.popularlayout);
        recommendedHolder = view.findViewById(R.id.recommendedlayout);
        popcastHolder = view.findViewById(R.id.popcastlayout);

        genreList = view.findViewById(R.id.genre_list);
        upcomingList = view.findViewById(R.id.uplist);
        recommendedList = view.findViewById(R.id.recommendedlist);
        nowList = view.findViewById(R.id.nowlist);
        popularList = view.findViewById(R.id.poplist);
        popcastList = view.findViewById(R.id.popcastlist);
        nowShowing = view.findViewById(R.id.nowtitle);
        popular = view.findViewById(R.id.poptitle);
        upcoming = view.findViewById(R.id.uptitle);
        upsubtitle = view.findViewById(R.id.upsubtitle);
        popsubtitle = view.findViewById(R.id.popsubtitle);
        nowsubtitle = view.findViewById(R.id.nowsubtitle);

        bottomNavigationViewEx = getActivity().findViewById(R.id.navigation);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progresscircle.setVisibility(View.VISIBLE);
        recommendedHolder.setVisibility(View.GONE);
        genreList.setVisibility(View.GONE);
        upHolder.setVisibility(View.GONE);
        nowHolder.setVisibility(View.GONE);
        popHolder.setVisibility(View.GONE);
        popcastHolder.setVisibility(View.GONE);

        initiateListView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(save, recommendedArray);
        outState.putParcelableArrayList(save, nowArray);
        outState.putParcelableArrayList(save, upArray);
        outState.putParcelableArrayList(save, popArray);
        outState.putParcelableArrayList(save, genreData);
    }

    public static void watchYoutubeVideo(Context context, String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(webIntent);
        }
    }

    public FragmentBase() {

    }

    public static FragmentBase newInstance() {
        return new FragmentBase();
    }

    public static FragmentBase getPopCast(List<PojoPopCast.ResultsBean> popCastData){
        popcastData.addAll(popCastData);
        popcastList.getAdapter().notifyDataSetChanged();
        popcastList.scheduleLayoutAnimation();
        return new FragmentBase();
    }

    public static FragmentBase getMoviesData(List<PojoAtMovies.ResultsBean> moviesdata, int id) {
        switch (id) {
            case 0:
                recommendedArray.addAll(moviesdata);
                recommendedList.getAdapter().notifyDataSetChanged();
                recommendedList.scheduleLayoutAnimation();

                break;
            case 1:
                upArray.addAll(moviesdata);
                upcomingList.getAdapter().notifyDataSetChanged();
                upcomingList.scheduleLayoutAnimation();

                break;
            case 2:
                nowArray.addAll(moviesdata);
                nowList.getAdapter().notifyDataSetChanged();
                nowList.scheduleLayoutAnimation();

                break;
            case 3:
                popArray.addAll(moviesdata);
                popularList.getAdapter().notifyDataSetChanged();
                popularList.scheduleLayoutAnimation();
                setVisible();

                break;
            default:
                break;
        }
        return new FragmentBase();
    }

    public static FragmentBase getSeriesData(List<PojoAtSeries.ResultsBean> seriesdata, int id) {
        switch (id) {
            case 10:
                recommendedSeries.addAll(seriesdata);
                recommendedList.getAdapter().notifyDataSetChanged();
                recommendedList.scheduleLayoutAnimation();

                break;
            case 11:
                onSeries.addAll(seriesdata);
                upcomingList.getAdapter().notifyDataSetChanged();
                upcomingList.scheduleLayoutAnimation();

                break;
            case 12:
                todaySeries.addAll(seriesdata);
                nowList.getAdapter().notifyDataSetChanged();
                nowList.scheduleLayoutAnimation();

                break;
            case 13:
                popSeries.addAll(seriesdata);
                popularList.getAdapter().notifyDataSetChanged();
                popularList.scheduleLayoutAnimation();
                setVisible();

                break;
            default:
                break;
        }
        return new FragmentBase();
    }

    public static FragmentBase getGenre(List<PojoGenre.GenresBean> genredata) {
        genreData.addAll(genredata);
        genreList.getAdapter().notifyDataSetChanged();
        genreList.scheduleLayoutAnimation();

        return new FragmentBase();
    }

    private void initiateListView() {
        final Context context = recommendedList.getContext();
        final LayoutAnimationController falldown =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation);

        recommendedList.setLayoutAnimation(falldown);
        nowList.setLayoutAnimation(falldown);
        popularList.setLayoutAnimation(falldown);
        upcomingList.setLayoutAnimation(falldown);
        genreList.setLayoutAnimation(falldown);

        switch (bottomNavigationViewEx.getCurrentItem()) {
            case 0:
                recommendedArray = new ArrayList<>();
                nowArray = new ArrayList<>();
                popArray = new ArrayList<>();
                upArray = new ArrayList<>();

                adapterRecommMovies = new AdapterAtMovies(getContext(), recommendedArray, RECOMMENDED_LAYOUT);
                adapterNowMovies = new AdapterAtMovies(getContext(), nowArray, NORMAL_LAYOUT);
                adapterPopMovies = new AdapterAtMovies(getContext(), popArray, NORMAL_LAYOUT);
                adapterUpMovies = new AdapterAtMovies(getContext(), upArray, NORMAL_LAYOUT);

                recommendedList.setAdapter(adapterRecommMovies);
                nowList.setAdapter(adapterNowMovies);
                popularList.setAdapter(adapterPopMovies);
                upcomingList.setAdapter(adapterUpMovies);

                popcastData = new ArrayList<>();
                adapterCast = new AdapterCast(getContext(), null, popcastData, 1);
                popcastList.setAdapter(adapterCast);

                break;
            case 1:
                nowShowing.setText("Airing today");
                popular.setText("Popular series");
                upcoming.setText("On the air");
                nowsubtitle.setText("your daily dose of series");
                popsubtitle.setText("everyone's talking about it");
                upsubtitle.setText("airing series for next 7 days");

                recommendedSeries = new ArrayList<>();
                todaySeries = new ArrayList<>();
                popSeries = new ArrayList<>();
                onSeries = new ArrayList<>();

                adapterRecommSeries = new AdapterAtSeries(getContext(), recommendedSeries, RECOMMENDED_LAYOUT);
                adapterTodaySeries = new AdapterAtSeries(getContext(), todaySeries, NORMAL_LAYOUT);
                adapterPopSeries = new AdapterAtSeries(getContext(), popSeries, NORMAL_LAYOUT);
                adapterOnAirSeries = new AdapterAtSeries(getContext(), onSeries, NORMAL_LAYOUT);

                recommendedList.setAdapter(adapterRecommSeries);
                nowList.setAdapter(adapterTodaySeries);
                popularList.setAdapter(adapterPopSeries);
                upcomingList.setAdapter(adapterOnAirSeries);

                break;
            default:
                break;
        }

        //recommendedList.addItemDecoration(new RecycleviewIndicator());
        //SNAPPY LIST
        SnapHelper snapHelper = new LinearSnapHelper();
        SnapHelper snapHelper1 = new GravitySnapHelper(Gravity.START);
        SnapHelper snapHelper2 = new GravitySnapHelper(Gravity.START);
        SnapHelper snapHelper3 = new GravitySnapHelper(Gravity.START);
        SnapHelper snapHelper4 = new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(recommendedList);
        snapHelper1.attachToRecyclerView(nowList);
        snapHelper2.attachToRecyclerView(popularList);
        snapHelper3.attachToRecyclerView(upcomingList);
        snapHelper4.attachToRecyclerView(popcastList);
        setGenre();
    }

    public void setGenre() {
        genreData = new ArrayList<>();
        adapterGenres = new AdapterGenres(getActivity().getApplicationContext(), genreData, null, 0);
        genreList.setAdapter(adapterGenres);
    }

    public static void setVisible() {
        recommendedHolder.setVisibility(View.VISIBLE);
        genreList.setVisibility(View.VISIBLE);
        upHolder.setVisibility(View.VISIBLE);
        popHolder.setVisibility(View.VISIBLE);
        nowHolder.setVisibility(View.VISIBLE);
        progresscircle.setVisibility(View.GONE);
        if (bottomNavigationViewEx.getCurrentItem()== 0){
            popcastHolder.setVisibility(View.VISIBLE);
        }
    }
}
