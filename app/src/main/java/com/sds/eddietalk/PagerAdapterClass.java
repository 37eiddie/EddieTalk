package com.sds.eddietalk;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class PagerAdapterClass extends PagerAdapter{

    private final LayoutInflater layoutInflater;
    int NumberOfPages = 11;

    int[] res = {
            R.drawable.eddie_000,
            R.drawable.eddie_001,
            R.drawable.eddie_002,
            R.drawable.eddie_003,
            R.drawable.eddie_004,
            R.drawable.eddie_005,
            R.drawable.eddie_006,
            R.drawable.eddie_007,
            R.drawable.eddie_008,
            R.drawable.eddie_009,
            R.drawable.eddie_010,
            };

    Context AdapterContext;

    public PagerAdapterClass(Context context) {
        AdapterContext = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return NumberOfPages;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View inflate = layoutInflater.inflate(R.layout.gallery_item, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.gallery_image);

        if(position <= 2) {
            Glide.with(AdapterContext)
                    .load(res[position])
                    .asGif()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageView);
        } else {
            Glide.with(AdapterContext)
                    .load(res[position])
                    .into(imageView);
        }
        container.addView(inflate, 0);


        return inflate;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
