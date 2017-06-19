package com.example.peacock.myapplicationfragmentdemo.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peacock.myapplicationfragmentdemo.R;
import com.example.peacock.myapplicationfragmentdemo.ui.MainActivity;

/**
 * Created by peacock on 18/4/17.
 */

public class fragmentsecond extends  Basefragment implements View.OnClickListener {

    private Activity activity = null;

    public fragmentsecond() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = getBaseActivity();

    }

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View my_order_status = inflater.inflate(R.layout.fragmentsecond, container, false);

        my_order_status.setOnClickListener(this);

        getBaseToolBar().setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ((MainActivity) activity).getSupportFragmentManager().popBackStackImmediate();

            }
        });

        return my_order_status;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onResume() {
        super.onResume();

        setToolBarText().setText(getString(R.string.fargmenttwos));

        getBaseSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
