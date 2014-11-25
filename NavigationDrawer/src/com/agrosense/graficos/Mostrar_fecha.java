package com.agrosense.graficos;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class Mostrar_fecha extends FragmentActivity {
	
	public void showDatePickerDialog(View v){
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "Desde");
	}
}
