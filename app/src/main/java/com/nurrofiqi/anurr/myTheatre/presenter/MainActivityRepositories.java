package com.nurrofiqi.anurr.myTheatre.presenter;

import android.support.annotation.NonNull;

/**
 * Created by anurr on 12/9/2017.
 */

public class MainActivityRepositories implements MainActivityDataResource {

    MainActivityDataResource mainActivityDataResource;

    public MainActivityRepositories(MainActivityDataResource mainActivityDataResource) {
        this.mainActivityDataResource = mainActivityDataResource;
    }

    @Override
    public void getDataList(@NonNull MainActivityGetCallBack mainActivityGetCallBack, String url, int id) {
        mainActivityDataResource.getDataList(mainActivityGetCallBack, url, id);
    }
}
