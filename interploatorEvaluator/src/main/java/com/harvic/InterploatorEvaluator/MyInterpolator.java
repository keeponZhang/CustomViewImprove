package com.harvic.InterploatorEvaluator;

import android.animation.TimeInterpolator;

/**
 * Created by qijian on 16/12/5.
 */
public class MyInterpolator implements TimeInterpolator {
    public float getInterpolation(float input) {
        return 1-input;
    }
}
