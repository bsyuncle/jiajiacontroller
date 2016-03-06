package com.xuexiang.viewpager.fragment;

import java.util.ArrayList;

import com.xuexiang.viewpager.R;
import com.xuexiang.viewpager.adapter.MainFragmentPagerAdapter;
import com.xuexiang.viewpager.menu.ResideMenu;
import com.xuexiang.viewpager.menu.ResideMenuInfo;
import com.xuexiang.viewpager.menu.ResideMenuItem;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class myviewpager extends ViewPager{
   public myviewpager(Context context) {  
        super(context);  

   }  

	  
   public myviewpager(Context context, AttributeSet attrs) {  
        super(context, attrs);  

   } 
   
   @Override
   public void scrollTo(int x, int y) {
       super.scrollTo(x, y);
   }

   @Override
   public boolean onTouchEvent(MotionEvent arg0) {
       /* return false;//super.onTouchEvent(arg0); */
           return false;
   }

   @Override
   public boolean onInterceptTouchEvent(MotionEvent arg0) {
           return false;
   }

}
