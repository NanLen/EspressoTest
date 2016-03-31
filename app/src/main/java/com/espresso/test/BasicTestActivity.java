package com.espresso.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by liyanan on 16/3/29.
 */
public class BasicTestActivity extends AppCompatActivity {
    private EditText et_content;
    private TextView tv_error;
    private Button btn_complete;
    private TextView tv_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_basic);
        initView();
        addListener();
    }

    private void initView() {
        et_content = (EditText) findViewById(R.id.et_content);
        tv_error = (TextView) findViewById(R.id.tv_error);
        btn_complete = (Button) findViewById(R.id.btn_complete);
        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    private void addListener() {
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_content.getText())) {
                    tv_error.setVisibility(View.VISIBLE);
                    tv_content.setVisibility(View.GONE);
                } else {
                    tv_error.setVisibility(View.GONE);
                    tv_content.setVisibility(View.VISIBLE);
                    tv_content.setText(et_content.getText());
                }
            }
        });
    }
}
