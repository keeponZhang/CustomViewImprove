package com.darren.view_day08;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text_view);

        Log.e("TAG", "height1 -> " + mTextView.getMeasuredHeight()); // 0

        mTextView.post(new Runnable() {
            // 保存到Queue中，什么都没干，会在dispatchAttachedToWindow会在测量完毕之后调用中执行，executeActions（）
            @Override
            public void run() {
                Log.e("TAG", "height2 -> " + mTextView.getMeasuredHeight()); // 高度
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "height3 -> " + mTextView.getMeasuredHeight()); // 0
    }
}
