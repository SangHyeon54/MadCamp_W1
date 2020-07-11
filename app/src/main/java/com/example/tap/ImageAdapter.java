package com.example.tap;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
    Context context;

    private Integer[] mThumblds ={R.drawable.image1, R.drawable.image2,R.drawable.image3,
            R.drawable.image4,R.drawable.image5,R.drawable.image6,
            R.drawable.image7,R.drawable.image8,R.drawable.image9,
            R.drawable.image10,R.drawable.image11,R.drawable.image12,
            R.drawable.image13,R.drawable.image14,R.drawable.image15,
            R.drawable.image16,R.drawable.image17,R.drawable.image18,
            R.drawable.image19,R.drawable.image20,
    };

    public ImageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return mThumblds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }else{
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumblds[position]);
        return imageView;
    }
}
