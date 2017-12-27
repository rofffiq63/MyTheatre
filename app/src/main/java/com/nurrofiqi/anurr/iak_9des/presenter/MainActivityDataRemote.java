package com.nurrofiqi.anurr.iak_9des.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.nurrofiqi.anurr.iak_9des.model.PojoDetail;
import com.nurrofiqi.anurr.iak_9des.model.PojoGenre;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtMovies;
import com.nurrofiqi.anurr.iak_9des.model.PojoAtSeries;
import com.nurrofiqi.anurr.iak_9des.model.PojoMultiSearch;

import static com.android.volley.Request.Method;

/**
 * Created by anurr on 12/9/2017.
 */

public class MainActivityDataRemote implements MainActivityDataResource {

    Context context;

    public MainActivityDataRemote(Context context) {
        this.context = context;
    }

    @Override
    public void getDataList(@NonNull final MainActivityGetCallBack mainActivityGetCallBack, String url, int id) {
        getData(mainActivityGetCallBack, url, id);
    }

    private void getData(final MainActivityGetCallBack mainActivityGetCallBack, String url, final int id) {
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                final PojoAtMovies pojoAtMovies = new Gson().fromJson(response, PojoAtMovies.class);
                final PojoGenre pojoGenre = new Gson().fromJson(response, PojoGenre.class);
                final PojoMultiSearch pojoMultiSearch = new Gson().fromJson(response, PojoMultiSearch.class);
                final PojoAtSeries pojoAtSeries = new Gson().fromJson(response, PojoAtSeries.class);
                final PojoDetail pojoDetail = new Gson().fromJson(response, PojoDetail.class);

                if (id == 0 || id == 1 || id == 2 || id == 3) {
                    if (pojoAtMovies == null) {
                        mainActivityGetCallBack.onError("BIG ERROR ON REQUEST");
                    } else {
                        mainActivityGetCallBack.successMainMovies(pojoAtMovies.getResults(), id);
                    }

                } else if (id == 10 || id == 11 || id == 12 || id == 13) {
                    if (pojoAtSeries == null) {
                        mainActivityGetCallBack.onError("BIG ERROR ON REQUEST");
                    } else {
                        mainActivityGetCallBack.successMainSeries(pojoAtSeries.getResults(), id);
                    }

                } else if (id == 4 || id == 14) {
                    if (pojoGenre == null) {
                        mainActivityGetCallBack.onError("BIG ERROR ON REQUEST");
                    } else {
                        mainActivityGetCallBack.successGenres(pojoGenre.getGenres());
                    }

                } else if (id == 5) {
                    if (pojoMultiSearch == null) {
                        mainActivityGetCallBack.onError("BIG ERROR ON REQUEST");
                    } else {
                        mainActivityGetCallBack.successSearch(pojoMultiSearch.getResults());
                    }

                } else if (id == 9) {
                    if (pojoDetail == null) {
                        mainActivityGetCallBack.onError("BIG ERROR ON REQUEST");
                    } else {
                        mainActivityGetCallBack.successDetail(
                                pojoDetail.getId(), pojoDetail.getBudget(), pojoDetail.getGenres(),
                                pojoDetail.getHomepage(), pojoDetail.getOriginal_title(), pojoDetail.getTitle(),
                                pojoDetail.getOverview(), pojoDetail.getPopularity(), pojoDetail.getPoster_path(),
                                pojoDetail.getBackdrop_path(), pojoDetail.getRelease_date(), pojoDetail.getRevenue(),
                                pojoDetail.getRuntime(), pojoDetail.getStatus(), pojoDetail.getTagline(),
                                pojoDetail.getVote_average(), pojoDetail.getVote_count(), pojoDetail.getOriginal_language());
                    }
                } else {
                    Toast.makeText(context, "ID not registered. Nothing requested", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mainActivityGetCallBack.onError("BIG ERROR ON REQUEST");
            }
        });
        requestQueue.add(stringRequest);
    }
}
