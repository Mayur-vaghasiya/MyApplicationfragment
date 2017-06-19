package com.example.peacock.myapplicationfragmentdemo.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.peacock.myapplicationfragmentdemo.interfaces.ChangeCurrentFragment;
import com.example.peacock.myapplicationfragmentdemo.ui.MainActivity;

/**
 * Created by peacock on 18/4/17.
 */

public class Basefragment extends Fragment {
    private MainActivity activity;

    private ChangeCurrentFragment changeCurrentFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (MainActivity) getActivity();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        changeCurrentFragment = (ChangeCurrentFragment) context;

    }

    public ChangeCurrentFragment onChangeCurrentFragment(){

        return changeCurrentFragment;

    }

    public Activity getBaseActivity() {

        return activity;

    }

//    public SharedPreferenceUtility getBasePreferenceUtility() {
//
//        return activity.getPreferenceUtility();
//
//    }

    public ActionBar getBaseSupportActionBar() {

        return activity.getSupportActionBar();

    }
    public Toolbar getBaseToolBar() {

        return activity.getToolbar();

    }

    public TextView setToolBarText() {

        return activity.getToolbarTextView();

    }

}
