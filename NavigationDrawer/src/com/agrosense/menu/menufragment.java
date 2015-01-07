package com.agrosense.menu;

import com.tutecentral.navigationdrawer.R;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class menufragment extends Fragment {
		
	
	public menufragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.presentacion, container,
				false);
			
		return view;
		
		
	}

}

