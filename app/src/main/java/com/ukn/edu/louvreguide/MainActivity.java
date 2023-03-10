package com.ukn.edu.louvreguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.ukn.edu.louvreguide.fragment.HistoryFragment;
import com.ukn.edu.louvreguide.fragment.PavilionIntroductionFragment;
import com.ukn.edu.louvreguide.fragment.TicketIllustrateFragment;
import com.ukn.edu.louvreguide.fragment.TransportationFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> fragmentList;
    String[] titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentList = new ArrayList<>();
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new PavilionIntroductionFragment());
        fragmentList.add(new TransportationFragment());
        fragmentList.add(new TicketIllustrateFragment());

        titles = new String[]{
                "歷史簡介",
                "展館介紹",
                "交通方式",
                "票價說明"
        };

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(myPagerAdapter);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_guide_service){
            Intent goGuide = new Intent(this, GuideActivity.class);
            startActivity(goGuide);
            return true;
        }

        if(id == R.id.action_opinion){
            Intent goOpinion = new Intent(this, OpinionActivity.class);
            startActivity(goOpinion);
            return true;
        }

        if(id == R.id.action_login){
            Intent goLogin = new Intent(this, LoginActivity.class);
            startActivity(goLogin);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public CharSequence getPageTitle(int i){
            return titles[i];
        }
    }
}