package com.espresso.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_test_basic;
    private Button btn_test_list;
    private Button btn_test_view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addListener();
    }

    private void initView() {
        btn_test_basic = (Button) findViewById(R.id.btn_test_basic);
        btn_test_list = (Button) findViewById(R.id.btn_test_list);
        btn_test_view_pager = (Button) findViewById(R.id.btn_test_view_pager);
    }

    private void addListener() {
        btn_test_basic.setOnClickListener(onClickListener);
        btn_test_list.setOnClickListener(onClickListener);
        btn_test_view_pager.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_test_basic:
                    startActivity(new Intent(MainActivity.this, BasicTestActivity.class));
                    break;
                case R.id.btn_test_list:
                    startActivity(new Intent(MainActivity.this, ListTestActivity.class));
                    break;
                case R.id.btn_test_view_pager:
                    startActivity(new Intent(MainActivity.this, ViewPagerTestActivity.class));
                    break;
            }

        }
    };
}
