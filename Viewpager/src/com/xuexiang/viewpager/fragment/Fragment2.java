package com.xuexiang.viewpager.fragment;



import com.xuexiang.viewpager.R;

import android.os.Bundle;
import android.os.MessageQueue;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment2 extends Fragment {
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f2, null);
		return view;
	}

	
}


