package com.xuexiang.viewpager.fragment;



import java.util.ArrayList;

import com.xuexiang.viewpager.R;
import com.xuexiang.viewpager.adapter.MainFragmentPagerAdapter;
import com.xuexiang.viewpager.menu.ResideMenu;
import com.xuexiang.viewpager.menu.ResideMenuInfo;
import com.xuexiang.viewpager.menu.ResideMenuItem;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class Fragment1 extends Fragment implements View.OnClickListener{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f1, null);
		FrameLayout ll=(FrameLayout)view.findViewById(R.id.frame1);	//获取布局文件中的帧布局管理器
		ll.addView(new MySurfaceView(getActivity()));
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
	
}



