package com.nurrofiqi.anurr.iak_9des.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nurrofiqi.anurr.iak_9des.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityFirstRun extends AppCompatActivity {

    @BindView(R.id.iconsplash)
    ImageView iconsplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        iconsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), ActivityMain.class);
                startActivity(in);
            }
        });
    }
}
