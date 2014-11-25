package com.agrosense.graficos;


import java.util.Calendar;

import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.app.Dialog;
import android.os.Bundle;
import android.app.DatePickerDialog;


public class DatePickerFragment extends DialogFragment implements 
DatePickerDialog.OnDateSetListener {

	public Dialog onCreateDialog(Bundle savedInstanceState){
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		return new DatePickerDialog(getActivity(),this, year, month, day);
		
	}
	public void onDateSet(DatePicker view, int year, int month,
			int day) {

	}

}
