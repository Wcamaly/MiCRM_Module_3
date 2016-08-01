package com.next.micrm_module_3.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.constant.ConstantGeneral;
import com.next.micrm_module_3.view.fragments.FragmentHome;
import com.next.micrm_module_3.view.fragments.FragmentListEntidades;
/**
 * This class is the main entry activity of the applicatio and it contains menus for the rest of the app. Also, action bar initialization.
 */
public class BaseNavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_navigation_drawer);

        initializeViews();
        initializeActionBar();

    }

    private void initializeViews() {
        mDrawerLayout = (DrawerLayout)findViewById(R.id.page);
        mNavigationView = (NavigationView)findViewById(R.id.navigation_drawer);
        mNavigationView.setNavigationItemSelectedListener(this);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
    }

    private void initializeActionBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_view_headline_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @TargetApi(Build.VERSION_CODES.DONUT)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
    @TargetApi(Build.VERSION_CODES.DONUT)
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = new FragmentListEntidades();
        Bundle arg = new Bundle();

        switch (item.getItemId()) {
            case R.id.menu_seccion_1:
                fragment = new FragmentHome();
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_2:
                arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_PEOPLE);
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_3:
                arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_ORGANIZATION);
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_4:
                arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_COMMERCE);
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_5:
                arg.putInt(ConstantGeneral.SELECTED_ITEM_MENU,ConstantGeneral.ITEM_MENU_ACTIVITY);
                fragmentTransaction = true;
                break;
        }

        if(fragmentTransaction) {
            fragment.setArguments(arg);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_section, fragment)
                    .commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        mDrawerLayout.closeDrawers();

        return true;
    }
}

