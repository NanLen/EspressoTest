package com.espresso.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanan on 16/3/31.
 */
public class ViewPagerTestActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> title;
    private List<Fragment> fragments;
    private TextView tv_click_item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_test);
        initView();
        initData();
        initViewPager();
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tv_click_item = (TextView) findViewById(R.id.tv_click_item);
    }

    private void initData() {
        title = new ArrayList<>();
        title.add("tab 1");
        title.add("tab 2");
        title.add("tab 3");
        fragments = new ArrayList<>();
        ListFragment fragment1 = new ListFragment();
        fragment1.setListActionListener(new ListFragment.ListActionListener() {
            @Override
            public void itemClick(Book book) {
                tv_click_item.setText("tab " + viewPager.getCurrentItem() + " " + book.getTitle());
            }

            @Override
            public void btnClick(Book book) {
                tv_click_item.setText("tab " + viewPager.getCurrentItem() + " " + book.getDesc());

            }
        });
        ListFragment fragment2 = new ListFragment();
        fragment2.setListActionListener(new ListFragment.ListActionListener() {
            @Override
            public void itemClick(Book book) {
                tv_click_item.setText("tab " + viewPager.getCurrentItem() + " " + book.getTitle());

            }

            @Override
            public void btnClick(Book book) {
                tv_click_item.setText("tab " + viewPager.getCurrentItem() + " " + book.getDesc());

            }
        });
        ListFragment fragment3 = new ListFragment();
        fragment3.setListActionListener(new ListFragment.ListActionListener() {
            @Override
            public void itemClick(Book book) {
                tv_click_item.setText("tab " + viewPager.getCurrentItem() + " " + book.getTitle());
            }

            @Override
            public void btnClick(Book book) {
                tv_click_item.setText("tab " + viewPager.getCurrentItem() + " " + book.getDesc());
            }
        });
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
    }

    private void initViewPager() {
        viewPager.setAdapter(new ViewPagerAdapter(title, fragments));
        tabLayout.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<String> title;
        private List<Fragment> fragments;

        public ViewPagerAdapter(List<String> title, List<Fragment> fragments) {
            super(getSupportFragmentManager());
            this.title = title;
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title.get(position);
        }
    }

}
