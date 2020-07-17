package com.harvic.ShapeDrawable_7_3;

import android.graphics.*;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by qijian on 16/9/16.
 */
public class RegionShape extends Shape {
    private Region mRegion;
    public RegionShape(Region region) {
        assert(region != null);
        mRegion = region;
    }
    @Override
    public void draw(Canvas canvas, Paint paint) {
        RegionIterator iter = new RegionIterator(mRegion);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }

    }
}
