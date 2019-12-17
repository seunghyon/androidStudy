package com.example.sh.mypager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       pager = (ViewPager)findViewById(R.id.pager);
       pager.setOffscreenPageLimit(3);
        // 캐싱하는게 3개까지 늘어남

        MoviePagerAdapter adapter = new MoviePagerAdapter(getSupportFragmentManager());

        fragment1 = new Fragment1();
        adapter.addItem(fragment1);

        fragment2 = new Fragment2();
        adapter.addItem(fragment2);

        fragment3 = new Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
            }
        });
    }

    class MoviePagerAdapter extends FragmentStatePagerAdapter{

        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MoviePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item)
        {
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "페이지 "+position;
        }
    }
}
