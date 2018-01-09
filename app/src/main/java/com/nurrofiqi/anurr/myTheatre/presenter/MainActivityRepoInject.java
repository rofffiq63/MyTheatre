package com.nurrofiqi.anurr.myTheatre.presenter;

import android.content.Context;

/**
 * Created by anurr on 12/9/2017.
 */

public class MainActivityRepoInject {

    public static MainActivityRepositories provideToMainRepo(Context context) {
        return new MainActivityRepositories(new MainActivityDataRemote(context));
    }
}
