package com.xh.viewpagergallery;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int pagerWidth;
    private List<ImageView> imageViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ImageView i1 = new ImageView(this);
        i1.setImageResource(R.mipmap.first);
        ImageView i2 = new ImageView(this);
        i2.setImageResource(R.mipmap.second);
        ImageView i3 = new ImageView(this);
        i3.setImageResource(R.mipmap.third);
        ImageView i4 = new ImageView(this);
        i4.setImageResource(R.mipmap.fourth);
        ImageView i5 = new ImageView(this);
        i5.setImageResource(R.mipmap.fifth);

        if (imageViewList == null)
            imageViewList = new ArrayList<>();

        imageViewList.add(i1);
        imageViewList.add(i2);
        imageViewList.add(i3);
        imageViewList.add(i4);
        imageViewList.add(i5);

        viewPager.setOffscreenPageLimit(3);

        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0 / 5.0f);
        ViewGroup.LayoutParams lp = viewPager.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);

        } else {
            lp.width = pagerWidth;
        }
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(-50);


        findViewById(R.id.activity_main).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return viewPager.dispatchTouchEvent(event);
            }
        });

        viewPager.setPageTransformer(true, new MyTaransformation());
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViewList == null ? 0 : imageViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = imageViewList.get(position);
                container.addView(imageView, position);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageViewList.get(position));
            }
        });
    }
}
