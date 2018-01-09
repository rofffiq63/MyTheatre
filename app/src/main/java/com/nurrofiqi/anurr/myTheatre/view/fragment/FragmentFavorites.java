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

public class FragmentFavorites extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        return view;
    }

    public FragmentFavorites() {

    }

    public static FragmentFavorites newInstance() {
        return new FragmentFavorites();
    }
}
