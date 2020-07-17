package com.harvic.ShapeDrawable_7_3;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by qijian on 16/9/15.
 */
public class ShapeInstanceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shape_instance);

        final TextView tv = (TextView)findViewById(R.id.shape_tv);

        findViewById(R.id.add_shape_corner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradientDrawable drawable = (GradientDrawable) tv.getBackground();
                drawable.setCornerRadius(20);
            }
        });
    }
}
