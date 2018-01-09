package com.nurrofiqi.anurr.myTheatre.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nurrofiqi.anurr.myTheatre.R;

/**
 * Created by anurr on 12/16/2017.
 */

public class FragmentWatchlist extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watchlist, container, false);
        return view;
    }

    public FragmentWatchlist() {

    }

    public static FragmentWatchlist newInstance() {
        return new FragmentWatchlist();
    }
}
