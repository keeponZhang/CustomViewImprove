package com.harvic.InterploatorEvaluator;

import android.animation.TypeEvaluator;

/**
 * Created by qijian on 16/12/5.
 */
public class ReverseEvaluator implements TypeEvaluator<Integer> {
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int)(endValue - fraction * (endValue - startInt));
    }
}
