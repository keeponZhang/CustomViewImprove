package com.harvic.FrameAnim;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by qijian on 16/11/18.
 */
public class FrameAnimJAVAActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_anim_java_activity);

        ImageView image = (ImageView) findViewById(R.id.frame_image);
        final AnimationDrawable anim = new AnimationDrawable();
        for (int i = 1; i <= 14; i++) {
            int id = getResources().getIdentifier("list_icon_gif_playing" + i, "drawable", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            anim.addFrame(drawable, 60);
        }

        anim.setOneShot(false);
        image.setBackgroundDrawable(anim);

        anim.start();
    }
}
