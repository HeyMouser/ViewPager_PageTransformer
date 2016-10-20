package com.xh.viewpagergallery;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by xiaohei on 2016/10/20.
 */

public class MyTaransformation implements ViewPager.PageTransformer {


    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;
    private static final float MAX_ROTATE = 30;


    @Override

    public void transformPage(View page, float position) {
        float centerX = page.getWidth() / 2;
        float centerY = page.getHeight() / 2;
        float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
        float rotate = 20 * Math.abs(position);

//        page.setScaleX(scaleFactor);
//        page.setScaleY(scaleFactor);
//        page.setRotationY(-rotate);

        if (position < -1) {

        } else if (position < 0) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(rotate);
        } else if (position < 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        } else {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotation(0);
        }
    }


}