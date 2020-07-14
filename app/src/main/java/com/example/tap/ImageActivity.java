package com.example.tap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class ImageActivity extends Activity {
    private ViewPager viewPager;
    private ImageViewPagerAdapter imageViewPagerAdapter;
    private static int img_num;
 //   private RecyclerView RecyclerView;
//    private ImgRecyclerAdapter imgRecyclerAdapter;
 //   private RecyclerView.LayoutManager imgLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_viewpager);

        Intent intent = getIntent();
        img_num = intent.getExtras().getInt("img_num");

        viewPager=findViewById(R.id.galleryViewPager);
        imageViewPagerAdapter=new ImageViewPagerAdapter(this);
        viewPager.setAdapter(imageViewPagerAdapter);
        viewPager.setCurrentItem(img_num);

      //  imgRecyclerAdapter=findViewById(R.id.recycler_images);
      //  imgRecyclerAdapter=new ImgRecyclerAdapter(img_num);
      //  imgRecyclerAdapter.setAdapter(ImgRecyclerAdapter);

      // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
     //   imgRecyclerAdapter.setLayoutManager(layoutManager);




    }
}