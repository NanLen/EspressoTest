package com.espresso.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by liyanan on 16/3/30.
 */
public class ListTestActivity extends AppCompatActivity {
    private TextView tv_click_item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);
        init();
    }

    private void init() {
        tv_click_item = (TextView) findViewById(R.id.tv_click_item);
        ListFragment fragment = new ListFragment();
        fragment.setListActionListener(new ListFragment.ListActionListener() {
            @Override
            public void itemClick(Book book) {
                tv_click_item.setText(book.getTitle());
            }

            @Override
            public void btnClick(Book book) {
                tv_click_item.setText(book.getDesc());
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
    }


}
