package com.harvic.InterploatorEvaluator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.custom_interplolater).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,InterploatorActivity.class));
            }
        });

        findViewById(R.id.custom_evaluator).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,EvaluatorActivity.class));
            }
        });

        findViewById(R.id.argb_evaluator).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,ArgbEvaluatorActivity.class));
            }
        });

        findViewById(R.id.character_evaluator).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,CharacterEvaluatorActivity.class));
            }
        });
        findViewById(R.id.falling_ball_demo).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,FallingBallActivity.class));
            }
        });
    }
}
