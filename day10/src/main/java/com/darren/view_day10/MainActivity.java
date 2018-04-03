package com.darren.view_day10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /*private TagLayout mTagLayout;

    private List<String> mItems;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.touch_view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("TAG", "onTouch -> " + event.getAction());
                return false;
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "onClick");
            }
        });

        /*mTagLayout = (TagLayout) findViewById(R.id.tag_layout);

        // 标签 后台获取 很多的实现方式  加List<String> 的集合
        mItems = new ArrayList<>();
        mItems.add("1111111");
        mItems.add("11");
        mItems.add("1111");
        mItems.add("1111");
        mItems.add("11");
        mItems.add("1111");
        mItems.add("1111111");
        mItems.add("1111111");
        mItems.add("11");
        mItems.add("1111");
        mItems.add("1111");
        mItems.add("11");
        mItems.add("1111");
        mItems.add("1111111");


        mTagLayout.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mItems.size();
            }

            @Override
            public View getView(int position, ViewGroup parent) {
                TextView tagTv = (TextView) LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.item_tag, parent, false);
                tagTv.setText(mItems.get(position));
                // 操作ListView的方式差不多

                return tagTv;
            }
        });*/
    }
}
