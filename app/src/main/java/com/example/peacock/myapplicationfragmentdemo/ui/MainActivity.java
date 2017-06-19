package com.example.peacock.myapplicationfragmentdemo.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.peacock.myapplicationfragmentdemo.R;
import com.example.peacock.myapplicationfragmentdemo.fragment.DashBoard;
import com.example.peacock.myapplicationfragmentdemo.interfaces.ChangeCurrentFragment;

public class MainActivity extends AppCompatActivity implements ChangeCurrentFragment,
        FragmentManager.OnBackStackChangedListener{


    private Toolbar toolbar = null;
    private Activity activity = null;
    private AppCompatTextView actv_header_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actv_header_name = (AppCompatTextView) toolbar.findViewById(R.id.actv_header_name);
        
        manageFragments(new DashBoard(), getString(R.string.dashboard));
       
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }
    

    @Override
    public void onFancyColorSelected(String title, String selectedColors) {

    }

    @Override
    public void onFragmentChangeListener(Fragment fragment, String tag) {

        manageFragments(fragment, tag);

    }

    public Toolbar getToolbar() {

        return toolbar;

    }

    public TextView getToolbarTextView() {

        return actv_header_name;

    }
    private void manageFragments(Fragment fragmentName, String tag) {

        String fragment_name = fragmentName.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragment_popped = manager.popBackStackImmediate(fragment_name, 0);

        if (!fragment_popped) { //fragment not in back stack, create it.

            FragmentTransaction ft = manager.beginTransaction();
            ft.add(R.id.fl_content_layout, fragmentName, tag);
            ft.setCustomAnimations(R.anim.slide_up,R.anim.slide_down);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(fragment_name);
            ft.commit();

        }
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {

            finish();

        } else {

            super.onBackPressed();

        }
    }

    @Override
    public void onBackStackChanged() {

        Object object = getSupportFragmentManager().findFragmentById(R.id.fl_content_layout);

        if (object != null) {

            ((Fragment) object).onResume();

        }
    }



}
