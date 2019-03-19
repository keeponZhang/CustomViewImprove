package com.darren.scrolltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.darren.view_day01.R;

public class ScorllActivity extends AppCompatActivity {

    private LinearLayout layout;

    private Button scrollToBtn;

    private Button scrollByBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll2);
        layout = (LinearLayout) findViewById(R.id.layout);
        scrollToBtn = (Button) findViewById(R.id.scroll_to_btn);
        scrollByBtn = (Button) findViewById(R.id.scroll_by_btn);
        if(scrollByBtn!=null){
            scrollToBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout.scrollTo(-60, -100);
                }
            });
        }

        if(scrollByBtn!=null){
            scrollByBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout.scrollBy(-60, -100);
                }
            });
        }

    }

}
