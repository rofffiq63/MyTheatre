package com.nurrofiqi.anurr.iak_9des.presenter;

import android.content.Context;

/**
 * Created by anurr on 12/9/2017.
 */

public class MainActivityRepoInject {

    public static MainActivityRepositories provideToMainRepo(Context context) {
        return new MainActivityRepositories(new MainActivityDataRemote(context));
    }
}
