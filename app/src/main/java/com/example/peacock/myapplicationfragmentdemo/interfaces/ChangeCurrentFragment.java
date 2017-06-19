package com.example.peacock.myapplicationfragmentdemo.interfaces;

import android.support.v4.app.Fragment;

/**
 * Created by peacock on 25/1/17.
 */

public interface ChangeCurrentFragment {

    void onFragmentChangeListener(Fragment fragment, String tag);

    void onFancyColorSelected(String title, String selectedColors);

}
