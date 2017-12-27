package com.nurrofiqi.anurr.iak_9des.view.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nurrofiqi.anurr.iak_9des.R;
import com.nurrofiqi.anurr.iak_9des.model.PojoGenre;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtMovies;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtSeries;
import com.nurrofiqi.anurr.iak_9des.view.adapter.AdapterGenres;
import com.nurrofiqi.anurr.iak_9des.view.adapter.AdapterAtMovies;
import com.nurrofiqi.anurr.iak_9des.view.adapter.AdapterAtSeries;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anurr on 12/14/2017.
 */

public class FragmentBase extends android.support.v4.app.Fragment {

    @BindView(R.id.recommendedlist) RecyclerView recommendedList;

    static RecyclerView genreList;
    RecyclerView upcomingList, nowList, popularList;

    static ArrayList<PojoAtMovies.ResultsBean> recommendedArray, upArray, nowArray, popArray;
    static ArrayList<PojoAtSeries.ResultsBean> recommendedSeries, onSeries, todaySeries, popSeries;
    static ArrayList<PojoGenre.GenresBean> genreData;

    static AdapterAtMovies adapterUpMovies, adapterNowMovies, adapterPopMovies, adapterRecommMovies;
    static AdapterAtSeries adapterOnAirSeries, adapterTodaySeries, adapterPopSeries, adapterRecommSeries;
    static AdapterGenres adapterGenres;

    static LinearLayout recommendHolder, nowHolder, popHolder, upHolder;
    static ProgressBar progresscircle;
    TextView nowShowing, popular, upcoming;
    BottomNavigationViewEx bottomNavigationViewEx;

    String save = "save";
    int NORMAL_LAYOUT = 0;
    int RECOMMENDED_LAYOUT = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, view);

        progresscircle = view.findViewById(R.id.progresscircle);
        recommendHolder = view.findViewById(R.id.recommendlayout);
        upHolder = view.findViewById(R.id.upcominglayout);
        nowHolder = view.findViewById(R.id.nowlayout);
        popHolder = view.findViewById(R.id.popularlayout);

        genreList = view.findViewById(R.id.genre_list);
        upcomingList = view.findViewById(R.id.uplist);
        nowList = view.findViewById(R.id.nowlist);
        popularList = view.findViewById(R.id.poplist);
        nowShowing = view.findViewById(R.id.nowtitle);
        popular = view.findViewById(R.id.poptitle);
        upcoming = view.findViewById(R.id.uptitle);

        bottomNavigationViewEx = getActivity().findViewById(R.id.navigation);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recommendHolder.setVisibility(View.GONE);
        genreList.setVisibility(View.GONE);
        upHolder.setVisibility(View.GONE);
        nowHolder.setVisibility(View.GONE);
        popHolder.setVisibility(View.GONE);

        upHolder.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 1){
                    popHolder.setVisibility(View.VISIBLE);
                }
            }
        });

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
//        adapterRecomMovies.notifyDataSetChanged();
//        adapterNowMovies.notifyDataSetChanged();
//        adapterPopMovies.notifyDataSetChanged();
//        adapterUpMovies.notifyDataSetChanged();
//        adapterGenres.notifyDataSetChanged();
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

    public static FragmentBase getMoviesData(List<PojoAtMovies.ResultsBean> moviesdata, int id) {
        switch (id) {
            case 0:
                recommendedArray.addAll(moviesdata);
                adapterRecommMovies.notifyDataSetChanged();
                break;
            case 1:
                upArray.addAll(moviesdata);
                adapterUpMovies.notifyDataSetChanged();
                break;
            case 2:
                nowArray.addAll(moviesdata);
                adapterNowMovies.notifyDataSetChanged();
                break;
            case 3:
                popArray.addAll(moviesdata);
                adapterPopMovies.notifyDataSetChanged();
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
                adapterRecommSeries.notifyDataSetChanged();
                break;
            case 11:
                onSeries.addAll(seriesdata);
                adapterOnAirSeries.notifyDataSetChanged();
                break;
            case 12:
                todaySeries.addAll(seriesdata);
                adapterTodaySeries.notifyDataSetChanged();
                break;
            case 13:
                popSeries.addAll(seriesdata);
                adapterPopSeries.notifyDataSetChanged();
                break;
            default:
                break;
        }
        return new FragmentBase();
    }

    public static FragmentBase getGenre(List<PojoGenre.GenresBean> genredata) {
        genreData.addAll(genredata);
        adapterGenres.notifyDataSetChanged();
        genreList.setVisibility(View.VISIBLE);
        return new FragmentBase();
    }

    private void initiateListView() {
        recommendedList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        nowList.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayout.HORIZONTAL,false));
        popularList.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayout.HORIZONTAL,false));
        upcomingList.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayout.HORIZONTAL,false));

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

                break;
            case 1:
                nowShowing.setText("Airing today");
                popular.setText("Popular series");
                upcoming.setText("On the air");

                recommendedSeries = new ArrayList<>();
                adapterRecommSeries = new AdapterAtSeries(getContext(), recommendedSeries, RECOMMENDED_LAYOUT);
                recommendedList.setAdapter(adapterRecommSeries);

                todaySeries = new ArrayList<>();
                adapterTodaySeries = new AdapterAtSeries(getContext(), todaySeries, NORMAL_LAYOUT);
                nowList.setAdapter(adapterTodaySeries);

                popSeries = new ArrayList<>();
                adapterPopSeries = new AdapterAtSeries(getContext(), popSeries, NORMAL_LAYOUT);
                popularList.setAdapter(adapterPopSeries);

                onSeries = new ArrayList<>();
                adapterOnAirSeries = new AdapterAtSeries(getContext(), onSeries, NORMAL_LAYOUT);
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
        snapHelper.attachToRecyclerView(recommendedList);
        snapHelper1.attachToRecyclerView(nowList);
        snapHelper2.attachToRecyclerView(popularList);
        snapHelper3.attachToRecyclerView(upcomingList);
        setGenre();
    }

    public void setGenre() {
        genreData = new ArrayList<>();
        adapterGenres = new AdapterGenres(getActivity().getApplicationContext(), genreData);
        genreList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        genreList.setAdapter(adapterGenres);
    }

    public static FragmentBase setVisible() {
        recommendHolder.setVisibility(View.VISIBLE);
        upHolder.setVisibility(View.VISIBLE);
        popHolder.setVisibility(View.VISIBLE);
        nowHolder.setVisibility(View.VISIBLE);
        progresscircle.setVisibility(View.GONE);
        return new FragmentBase();
    }
}
