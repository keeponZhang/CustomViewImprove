package com.darren.viewday25;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageBubbleView.attach(findViewById(R.id.text_view), new  BubbleMessageTouchListener.BubbleDisappearListener() {
            @Override
            public void dismiss(View view) {

            }
        });
    }
}
