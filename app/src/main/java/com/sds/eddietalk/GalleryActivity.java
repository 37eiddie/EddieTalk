package com.sds.eddietalk;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GalleryActivity extends AppCompatActivity{

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_fragment);

        mPagerAdapter = new PagerAdapterClass(this);

        mPager = (ViewPager)findViewById(R.id.view_pager);
        mPager.setAdapter(mPagerAdapter);

        final ImageView loadingImage = (ImageView) findViewById(R.id.loading);
        Glide.with(this).load(R.drawable.page).asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(loadingImage);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == 0) {
                    mPager.setAlpha(1.0f);
                    loadingImage.setVisibility(View.INVISIBLE);
                } else if (state == 1) {
                    mPager.setAlpha(0.3f);
                    loadingImage.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
