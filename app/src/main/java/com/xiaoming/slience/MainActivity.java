package com.xiaoming.slience;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.xiaoming.slience.base.BaseFragment;
import com.xiaoming.slience.fragment.HotNewsFragment;
import com.xiaoming.slience.fragment.MusicFragment;
import com.xiaoming.slience.fragment.PhotosFragment;
import com.xiaoming.slience.fragment.SettingFragment;
import com.xiaoming.slience.fragment.ShareFragment;
import com.xiaoming.slience.fragment.ZdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FrameLayout fl_content;
    private List<BaseFragment> mFragments;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setCurrentFragment(0,"热点新闻",true);
        setSupportActionBar(mToolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





    }

    private void initData() {
        mFragments = new ArrayList<>();

        mFragments.add(new HotNewsFragment());
        mFragments.add(new ZdFragment());
        mFragments.add(new PhotosFragment());
        mFragments.add(new MusicFragment());
        mFragments.add(new SettingFragment());
        mFragments.add(new ShareFragment());

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_news:
                setCurrentFragment(0,item.getTitle(),false);
                break;
            case R.id.nav_dz:
                setCurrentFragment(1,item.getTitle(),false);
                break;
            case R.id.nav_photos:
                setCurrentFragment(2,item.getTitle(),false);
                break;
            case R.id.nav_music:
                setCurrentFragment(3,item.getTitle(),false);
                break;
            case R.id.nav_setting:
                setCurrentFragment(4,item.getTitle(),false);
                break;
            case R.id.nav_share:
                setCurrentFragment(5,item.getTitle(),false);
                break;
            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setCurrentFragment(int position,CharSequence title,boolean isInit) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        if(isInit){
            tr.replace(R.id.fl_content,new HotNewsFragment());
        }else{
            tr.replace(R.id.fl_content, mFragments.get(position));
        }
        tr.commit();
        //设置toolbar标题
        mToolbar.setTitle(title);
    }
}
