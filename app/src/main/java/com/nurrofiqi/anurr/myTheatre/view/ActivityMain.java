package com.nurrofiqi.anurr.myTheatre.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nurrofiqi.anurr.myTheatre.R;
import com.nurrofiqi.anurr.myTheatre.model.PojoCast;
import com.nurrofiqi.anurr.myTheatre.model.PojoDetail;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenre;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtMovies;
import com.nurrofiqi.anurr.myTheatre.model.PojoAtSeries;
import com.nurrofiqi.anurr.myTheatre.model.PojoGenreList;
import com.nurrofiqi.anurr.myTheatre.model.PojoMultiSearch;
import com.nurrofiqi.anurr.myTheatre.model.PojoPopCast;
import com.nurrofiqi.anurr.myTheatre.model.PojoReviews;
import com.nurrofiqi.anurr.myTheatre.presenter.MainActivityContract;
import com.nurrofiqi.anurr.myTheatre.presenter.MainActivityPresenter;
import com.nurrofiqi.anurr.myTheatre.presenter.MainActivityRepoInject;
import com.nurrofiqi.anurr.myTheatre.view.adapter.AdapterSearch;
import com.nurrofiqi.anurr.myTheatre.view.fragment.FragmentBase;
import com.nurrofiqi.anurr.myTheatre.view.fragment.FragmentFavorites;
import com.nurrofiqi.anurr.myTheatre.view.fragment.FragmentWatchlist;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMain extends AppCompatActivity implements MainActivityContract.View {

    @BindView(R.id.rootlayout)
    CoordinatorLayout rootLayout;
    @BindView(R.id.instant_inmovies)
    RecyclerView searchList;
    @BindView(R.id.catholder)
    LinearLayout mcatholder;
    @BindView(R.id.searchbase)
    LinearLayout searchBase;
    @BindView(R.id.searchcontainer)
    LinearLayout searchContainer;
    @BindView(R.id.searchchildcontainer)
    RelativeLayout searchChildContainer;
    @BindView(R.id.error)
    LinearLayout merror;
    @BindView(R.id.nothing)
    TextView nothing;
    @BindView(R.id.inmovies)
    TextView inmovies;
    @BindView(R.id.intv)
    TextView intv;
    @BindView(R.id.inall)
    TextView inall;
    @BindView(R.id.search)
    EditText msearch;
    @BindView(R.id.clearsearch)
    ImageView clearsearch;
    @BindView(R.id.filter)
    ImageView filterbut;
    @BindView(R.id.profile)
    ImageView accountpic;
    @BindView(R.id.darkdrop)
    View darkDrop;
    @BindView(R.id.navigation)
    BottomNavigationViewEx bottomNavigationView;

    MainActivityPresenter mainActivityPresenter;
    ArrayList<PojoMultiSearch.ResultsBean> searchData;
    AdapterSearch adapterSearch;

    FragmentBase fragmentBase;
    FragmentWatchlist fragmentWatchlist;
    FragmentFavorites fragmentFavorites;
    FragmentTransaction fragmentTransaction;

    public static final String EXTRA_CIRCULAR_REVEAL_X = "EXTRA_CIRCULAR_REVEAL_X";
    public static final String EXTRA_CIRCULAR_REVEAL_Y = "EXTRA_CIRCULAR_REVEAL_Y";

    private static final int RECOMMENDED_MOVIES = 0;
    private static final int NOW_MOVIES = 2;
    private static final int POP_MOVIES = 3;
    private static final int UP_MOVIES = 1;

    private static final int RECOMMENDED_SERIES = 10;
    private static final int NOW_SERIES = 12;
    private static final int POP_SERIES = 13;
    private static final int ON_AIR_SERIES = 11;

    private static final int GENRE_MOVIES = 4;
    private static final int GENRE_SERIES = 14;
    private static final int SEARCH = 5;
    private static final int POP_CAST = 990;

    private int revealX;
    private int revealY;

    int FRAGMENT_BASE = 0;
    int FRAGMENT_WATCHLIST = 1;
    int FRAGMENT_FAVORITES = 2;
    int pagecount = 1;

    long delay = 1000;
    long duration = 500;
    long last_text_edit = 0;

    Handler handler = new Handler();
    String API_KEY = "dc06aa24248daf1a618d531314fe6a04";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        INITIATE VIEW
        initiateView(savedInstanceState);

        //ENDLESS SCROLL
        /*upcomingList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView upcomingList, int dx, int dy) {
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();
                boolean endHasBeenReached = lastVisible + 1 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    Toast.makeText(getApplicationContext(), "You reached bottom! Total data count: "+String.valueOf(upcomingAdapter.getItemCount()), Toast.LENGTH_SHORT).show();
                    loadData();
                    //you have reached to the bottom of your recycler view
                }
            }
        });*/
    }

    private void initiateView(Bundle savedInstanceState) {

        clearsearch.setVisibility(View.GONE);
        mcatholder.setVisibility(View.GONE);
        searchList.setVisibility(View.GONE);
        darkDrop.setVisibility(View.GONE);

        LayoutTransition transition = searchContainer.getLayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);

        //        REVEAL ANIMATION
//        final Intent intent = getIntent();
//        if (savedInstanceState == null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
//                intent.hasExtra(EXTRA_CIRCULAR_REVEAL_X) &&
//                intent.hasExtra(EXTRA_CIRCULAR_REVEAL_Y)) {
//
//            revealX = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_X, 0);
//            revealY = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_Y, 0);

//            ViewTreeObserver viewTreeObserver = rootLayout.getViewTreeObserver();
//            if (viewTreeObserver.isAlive()) {
//                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        revealActivity(revealX, revealY);
//                        rootLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                    }
//                });
//            }
//        }

        KeyboardVisibilityEvent.setEventListener(
                this,
                new KeyboardVisibilityEventListener() {
                    @Override
                    public void onVisibilityChanged(boolean isOpen) {
                        if (!isOpen) {
                            keyboardGone();
                        }
                        // some code depending on keyboard visiblity status
                    }
                });

        mainActivityPresenter = new MainActivityPresenter(MainActivityRepoInject.provideToMainRepo(this));
        mainActivityPresenter.onAttachView(this);

        darkDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                msearch.setText("");
                keyboardGone();
            }
        });

        merror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSearch();
            }
        });
        clearsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FOR CLEAR BUTTON
                msearch.setText("");
            }
        });

        msearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (msearch.hasFocus()) {
                    darkDrop.setVisibility(View.VISIBLE);
                    accountpic.setVisibility(View.GONE);
                    filterbut.setVisibility(View.GONE);
                } else {
                    msearch.setText("");
                    accountpic.setVisibility(View.VISIBLE);
                    darkDrop.setVisibility(View.GONE);
                    filterbut.setVisibility(View.VISIBLE);
                }
            }
        });

        msearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != KeyEvent.ACTION_DOWN)
                    return false;
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    //ENTER FOR KEYBOARD SEARCH BUTTON
                    keyboardGone();
                    return true;
                }
                return false;
            }
        });

        msearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //RESET COUNTER
                handler.removeCallbacks(finishChecker);
                nothing.setVisibility(View.GONE);
                merror.setVisibility(View.GONE);
//                searchList.setVisibility(View.GONE);

                String livetext = String.valueOf(msearch.getText());
                inall.setText(Html.fromHtml("<b>" + livetext + "</b> in All Categories"));
                inmovies.setText(Html.fromHtml("<b>" + livetext + "</b> in Movies"));
                intv.setText(Html.fromHtml("<b>" + livetext + "</b> in TV Series"));

                if (msearch.length() > 0) {
                    mcatholder.setVisibility(View.VISIBLE);
                    clearsearch.setVisibility(View.VISIBLE);
                    nothing.setVisibility(View.GONE);
                    merror.setVisibility(View.GONE);
                    setSearch();
                } else {
                    clearsearch.setVisibility(View.GONE);
                    mcatholder.setVisibility(View.GONE);
                    searchList.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (msearch.length() != 0) {
                    last_text_edit = System.currentTimeMillis();
//                    handler.postDelayed(finishChecker, delay);
                }
            }
        });

        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.enableItemShiftingMode(false);
        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.setTextVisibility(false);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_movies:
                        openFragment(fragmentBase, FRAGMENT_BASE);
                        reqLink(GENRE_MOVIES);
                        reqLink(RECOMMENDED_MOVIES);
                        reqLink(UP_MOVIES);
                        reqLink(NOW_MOVIES);
                        reqLink(POP_MOVIES);
                        reqLink(POP_CAST);
                        break;
                    case R.id.navigation_series:
                        openFragment(fragmentBase, FRAGMENT_BASE);
                        reqLink(GENRE_SERIES);
                        reqLink(RECOMMENDED_SERIES);
                        reqLink(ON_AIR_SERIES);
                        reqLink(NOW_SERIES);
                        reqLink(POP_SERIES);
                        break;
                    case R.id.watch_list:
                        openFragment(fragmentWatchlist, FRAGMENT_WATCHLIST);
                        break;
                    case R.id.navigation_favorites:
                        openFragment(fragmentFavorites, FRAGMENT_FAVORITES);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        bottomNavigationView.setCurrentItem(0);

        searchData = new ArrayList<>();
        adapterSearch = new AdapterSearch(ActivityMain.this, searchData);
        searchList.setLayoutManager(new LinearLayoutManager(this));
        searchList.setAdapter(adapterSearch);
    }

    private void revealActivity(int x, int y) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);

            // create the animator for this view (the start radius is zero)
            Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, x, y, 0, finalRadius);
            circularReveal.setDuration(300);
            circularReveal.setInterpolator(new AccelerateInterpolator());

            // make the view visible and start the animation
            rootLayout.setVisibility(View.VISIBLE);
            circularReveal.start();
        } else {
            finish();
        }
    }

    protected void unRevealActivity() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            finish();
        } else {
            float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()) * 1.1);
            Animator circularReveal = ViewAnimationUtils.createCircularReveal(
                    rootLayout, revealX, revealY, finalRadius, 0);

            circularReveal.setDuration(300);
            circularReveal.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    finish();
                }
            });
            circularReveal.start();
        }
    }

    private void openFragment(Fragment fragment, int id) {
        switch (id) {
            case 0:
                fragment = FragmentBase.newInstance();
                break;
            case 1:
                fragment = FragmentWatchlist.newInstance();
                break;
            case 2:
                fragment = FragmentFavorites.newInstance();
                break;
            default:
                Toast.makeText(this, "No fragment created", Toast.LENGTH_SHORT).show();

        }

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentview, fragment);
        fragmentTransaction.commit();
    }

    private Runnable finishChecker = new Runnable() {
        public void run() {
            if (System.currentTimeMillis() > (last_text_edit + delay - duration)) {
                if (msearch.length() != 0) {
                    setSearch();
                }
            }
        }
    };

    void keyboardGone() {
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        rootLayout.requestFocus();
    }

    public void setSearch() {
//        progressBar.setVisibility(View.VISIBLE);
        if (msearch.length() != 0) {
            String searchm;
            searchm = String.valueOf(msearch.getText());
            searchm = searchm.replaceAll(" ", "%20");
            searchm = "https://api.themoviedb.org/3/search/multi?api_key=" + API_KEY + "&query=" +
                    searchm + "&language=en-US&page=1&include_adult=false";
            mainActivityPresenter.setLink(searchm, SEARCH);
        } else {
            searchList.setVisibility(View.GONE);
        }
    }

    public void reqLink(int id) {

        /**
         * 0 10 rec
         * 1 11 up
         * 2 12 now
         * 3 13 pop
         * 4 14 genre
         * 5 search
         **/

        String url = null;
        switch (id) {
            case RECOMMENDED_MOVIES:
                url = "https://api.themoviedb.org/3/movie/177572/recommendations?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            case NOW_MOVIES:
                url = "https://api.themoviedb.org/3/movie/now_playing?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            case POP_MOVIES:
                url = "https://api.themoviedb.org/3/movie/popular?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            case UP_MOVIES:
                url = "https://api.themoviedb.org/3/movie/upcoming?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            case RECOMMENDED_SERIES:
                url = "https://api.themoviedb.org/3/tv/66732/recommendations?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            case NOW_SERIES:
                url = "https://api.themoviedb.org/3/tv/airing_today?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            case POP_SERIES:
                url = "https://api.themoviedb.org/3/tv/popular?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            case ON_AIR_SERIES:
                url = "https://api.themoviedb.org/3/tv/on_the_air?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            case GENRE_MOVIES:
                url = "https://api.themoviedb.org/3/genre/movie/list?api_key=" +
                        API_KEY + "&language=en-US";
                break;
            case GENRE_SERIES:
                url = "https://api.themoviedb.org/3/genre/tv/list?api_key=" +
                        API_KEY + "&language=en-US";
                break;
            case POP_CAST:
                url = "https://api.themoviedb.org/3/person/popular?api_key=" +
                        API_KEY + "&language=en-US&page=" + String.valueOf(pagecount);
                break;
            default:
                break;
        }
        mainActivityPresenter.setLink(url, id);
    }

    @Override
    public void successMainSeries(List<PojoAtSeries.ResultsBean> mainseriesdata, int id) {
        FragmentBase.getSeriesData(mainseriesdata, id);
    }

    @Override
    public void successMainMovies(List<PojoAtMovies.ResultsBean> mainmoviesdata, int id) {
        FragmentBase.getMoviesData(mainmoviesdata, id);
    }

    @Override
    public void successDetail(int id, int budget, List<PojoDetail.GenresBean> genres, List<PojoDetail.ProductionCompaniesBean> product, String homepage, String original_title, String title, String overview, double popularity, String poster, String backdrop, String date, int revenue, int runtime, String status, String tagline, double rate, int vote, String language, List<PojoDetail.ImagesBean.BackdropsBean> backdropsdata, List<PojoDetail.ImagesBean.PostersBean> posterdata, List<PojoDetail.VideosBean.ResultsBean> videosdata) {

    }

    @Override
    public void successCast(List<PojoCast.CastBean> castdata, List<PojoPopCast.ResultsBean> popcastdata, int id) {
        FragmentBase.getPopCast(popcastdata);
    }

    @Override
    public void successGenre(final List<PojoGenre.GenresBean> genredata) {
        FragmentBase.getGenre(genredata);
    }

    @Override
    public void successOnSearch(final List<PojoMultiSearch.ResultsBean> searchdata) {
        this.searchData.clear();
        this.searchData.addAll(searchdata);
        Handler mhandler = new Handler();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                progressBar.setVisibility(View.INVISIBLE);
                if (searchdata == null) {
                    nothing.setVisibility(View.VISIBLE);
                    mcatholder.setVisibility(View.GONE);
                } else {
                    if (msearch.length() != 0) {
                        adapterSearch.notifyDataSetChanged();
                        searchList.setVisibility(View.VISIBLE);
                    } else {
                        searchList.setVisibility(View.GONE);
                    }
                }
            }
        }, 300);
    }

    @Override
    public void successReview(List<PojoReviews.ResultsBean> reviewdata) {

    }

    @Override
    public void successGenreList(List<PojoGenreList.ResultsBean> genrelistdata) {

    }

    @Override
    public void onError(String msg) {

    }

}
