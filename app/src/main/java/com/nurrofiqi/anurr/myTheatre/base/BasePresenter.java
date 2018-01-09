package com.nurrofiqi.anurr.myTheatre.base;

/**
 * Created by anurr on 12/9/2017.
 */

public interface BasePresenter<T> {

    void onAttachView(T view);

    void setPresenter(T presenter);
}
