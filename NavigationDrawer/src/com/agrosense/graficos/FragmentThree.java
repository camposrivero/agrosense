package com.agrosense.graficos;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



import com.agrosense.conexion.cargar_datos;
import com.tutecentral.navigationdrawer.R;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;



@SuppressLint("SimpleDateFormat") public class FragmentThree extends Fragment implements OnClickListener{
	
	public ArrayList<clima> Array_datos = new ArrayList<clima>();
	
	private String [] funciones = {"getClimate","getPlant","getSoil"};
	private String [] medidas = {"MeanTemp","MeanHum","MeanPress","MeanSolar","MeanLeaf","MeanBatt","MeanTempS"};
	private String [] lugar_nodo = new String [5];
	private String fecha1, fecha1_2, fecha2, fecha2_2, fecha3, fecha3_3;
	private TextView text, text2, text3, text4, text5, text6;
	private Calendar calender = Calendar.getInstance();
	
	
	public FragmentThree(String [] lugar_nodo) {
		System.arraycopy(lugar_nodo, 0, this.lugar_nodo, 0, lugar_nodo.length);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.pestanas, container,
				false);
		
		Resources res = getResources();
		TabHost tabs = (TabHost)view.findViewById(android.R.id.tabhost);
		tabs.setup();
		
		TabHost.TabSpec spec = tabs.newTabSpec("mi pestaña");
		
		spec.setContent(R.id.tab1);
		spec.setIndicator("   CLIMA   ", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("pestaña 2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("   PLANTA   ", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("pestaña 3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("   SUELO   ", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		
		tabs.setCurrentTab(0);
		
		
		TextView texto = (TextView)view.findViewById(R.id.fecha);
		TextView texto2 = (TextView)view.findViewById(R.id.fecha2);
		TextView texto3 = (TextView)view.findViewById(R.id.fecha3);
		TextView texto4 = (TextView)view.findViewById(R.id.fecha4);
		TextView texto5 = (TextView)view.findViewById(R.id.fecha5);
		TextView texto6 = (TextView)view.findViewById(R.id.fecha6);
		
		this.fecha1 = texto.getText().toString();
		this.fecha1_2 = texto2.getText().toString();
		this.fecha2 = texto3.getText().toString();
		this.fecha2_2 = texto4.getText().toString();
		this.fecha3 = texto5.getText().toString();
		this.fecha3_3 = texto6.getText().toString();
		
		Button date = (Button)view.findViewById(R.id.btn_fecha);
		Button date2 = (Button)view.findViewById(R.id.btn_fecha2);
		Button date3 = (Button)view.findViewById(R.id.btn_fecha3);
		Button date4 = (Button)view.findViewById(R.id.btn_fecha4);
		Button date5 = (Button)view.findViewById(R.id.btn_fecha5);
		Button date6 = (Button)view.findViewById(R.id.btn_fecha6);
		
		Button boton1 =(Button)view.findViewById(R.id.nodo1_temp);
		Button boton2 =(Button)view.findViewById(R.id.nodo2_temp); //Temperatura Clima
		Button boton3 =(Button)view.findViewById(R.id.nodo3_temp);
		
		Button boton4 =(Button)view.findViewById(R.id.nodo1_hum);
		Button boton5 =(Button)view.findViewById(R.id.nodo2_hum); //Humedad CLima
		Button boton6 =(Button)view.findViewById(R.id.nodo3_hum);
		
		Button boton7 =(Button)view.findViewById(R.id.nodo1_presion);
		Button boton8 =(Button)view.findViewById(R.id.nodo2_presion); //Presión CLima
		Button boton9 =(Button)view.findViewById(R.id.nodo3_presion);
		
		Button boton10 =(Button)view.findViewById(R.id.nodo1_rad);
		Button boton11 =(Button)view.findViewById(R.id.nodo2_rad); //Radación  Planta
		Button boton12 =(Button)view.findViewById(R.id.nodo3_rad);
		
		Button boton13 =(Button)view.findViewById(R.id.nodo1_hum_plant);
		Button boton14 =(Button)view.findViewById(R.id.nodo2_hum_plant); //Humedad  Planta
		Button boton15 =(Button)view.findViewById(R.id.nodo3_hum_plant);
		
		Button boton16 =(Button)view.findViewById(R.id.nodo1_bateria);
		Button boton17 =(Button)view.findViewById(R.id.nodo2_bateria); //Bateria  Planta
		Button boton18 =(Button)view.findViewById(R.id.nodo3_bateria);
		
		Button boton19 =(Button)view.findViewById(R.id.nodo1_tempsuelo);
		Button boton20 =(Button)view.findViewById(R.id.nodo2_tempsuelo); //Temperatura Suelo  Suelo
		Button boton21 =(Button)view.findViewById(R.id.nodo3_tempsuelo);
		
		date.setOnClickListener(this);
		date2.setOnClickListener(this);
		date3.setOnClickListener(this);
		date4.setOnClickListener(this);
		date5.setOnClickListener(this);
		date6.setOnClickListener(this);

		
		boton1.setOnClickListener(this);
		boton2.setOnClickListener(this);
		boton3.setOnClickListener(this);
		
		boton4.setOnClickListener(this);
		boton5.setOnClickListener(this);
		boton6.setOnClickListener(this);
		
		boton7.setOnClickListener(this);
		boton8.setOnClickListener(this);
		boton9.setOnClickListener(this);
		
		boton10.setOnClickListener(this);
		boton11.setOnClickListener(this);
		boton12.setOnClickListener(this);
		
		boton13.setOnClickListener(this);
		boton14.setOnClickListener(this);
		boton15.setOnClickListener(this);
		
		boton16.setOnClickListener(this);
		boton17.setOnClickListener(this);
		boton18.setOnClickListener(this);
		
		boton19.setOnClickListener(this);
		boton20.setOnClickListener(this);
		boton21.setOnClickListener(this);
		
		updatelabelall(texto, texto2, texto3, texto4, texto5, texto6);
		
		this.fecha1 = texto.getText().toString();
		this.fecha1_2 = texto.getText().toString();
			
		return view;
		
		
	}
	@SuppressLint("CutPasteId") public void onClick(View v){		
		Bundle args = null;
		Fragment fragment = null;
		cargar_datos aux = null;
		FragmentManager frgManager = null;
		
		this.text = (TextView)getActivity().findViewById(R.id.fecha);
		this.text2 = (TextView)getActivity().findViewById(R.id.fecha2);
		this.text3 = (TextView)getActivity().findViewById(R.id.fecha3);
		this.text4 = (TextView)getActivity().findViewById(R.id.fecha4);
		this.text5 = (TextView)getActivity().findViewById(R.id.fecha5);
		this.text6= (TextView)getActivity().findViewById(R.id.fecha6);
		
		this.fecha1 = text.getText().toString();
		this.fecha1_2 = text2.getText().toString();
		this.fecha2 = text3.getText().toString();
		this.fecha2_2 = text4.getText().toString();
		this.fecha3 = text5.getText().toString();
		this.fecha3_3 = text6.getText().toString();
		
		switch(v.getId()){
		
		case R.id.btn_fecha:
			this.text = (TextView)getActivity().findViewById(R.id.fecha);
			new Handler().post(new Runnable() {
				public void run() {
					setDate();	
				}
			});
		break;
		case R.id.btn_fecha2:
			this.text = (TextView)getActivity().findViewById(R.id.fecha2);
			new Handler().post(new Runnable() {
				public void run() {
					setDate();	
				}
			});	
		break;
		case R.id.btn_fecha3:
			this.text = (TextView)getActivity().findViewById(R.id.fecha3);
			new Handler().post(new Runnable() {
				public void run() {
					setDate();	
				}
			});	
		break;
		case R.id.btn_fecha4:
			this.text = (TextView)getActivity().findViewById(R.id.fecha4);
			new Handler().post(new Runnable() {
				public void run() {
					setDate();	
				}
			});	
		break;
		case R.id.btn_fecha5:
			this.text = (TextView)getActivity().findViewById(R.id.fecha5);
			new Handler().post(new Runnable() {
				public void run() {
					setDate();	
				}
			});	
		break;
		case R.id.btn_fecha6:
			this.text = (TextView)getActivity().findViewById(R.id.fecha6);
			new Handler().post(new Runnable() {
				public void run() {
					setDate();	
				}
			});	
		break;
		case R.id.nodo1_temp:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[1],fecha1, fecha1_2,medidas[0],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
			Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Temperatura", "Grados Celsius",""+this.lugar_nodo[4]+": Nodo 1");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo2_temp:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[2],fecha1, fecha1_2,medidas[0],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Temperatura", "Grados Celsius",""+this.lugar_nodo[4]+": Nodo 2");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo3_temp:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[3],fecha1,fecha1_2,medidas[0],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Temperatura", "Grados Celsius",""+this.lugar_nodo[4]+": Nodo 3");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo1_hum:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[1],fecha1,fecha1_2,medidas[1],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Humedad[%]", "Porcentaje Humedad",""+this.lugar_nodo[4]+": Nodo 1");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo2_hum:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[2],fecha1, fecha1_2,medidas[1],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Humedad[%]", "Porcentaje Humedad",""+this.lugar_nodo[4]+": Nodo 2");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo3_hum:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[3],fecha1, fecha1_2,medidas[1],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Humedad[%]", "Porcentaje Humedad",""+this.lugar_nodo[4]+": Nodo 3");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo1_presion:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[1],fecha1,fecha1_2,medidas[2],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Presión[Kpa]", "Presión[Kpa]",""+this.lugar_nodo[4]+": Nodo 1");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo2_presion:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[2],fecha1,fecha1_2,medidas[2],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Presión[Kpa]", "Presión[Kpa]",""+this.lugar_nodo[4]+": Nodo 2");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo3_presion:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[3],fecha1,fecha1_2,medidas[2],funciones[0]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Presión[Kpa]", "Presión[Kpa]",""+this.lugar_nodo[4]+": Nodo 3");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo1_rad:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[1],fecha2, fecha2_2,medidas[3],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Radiación Solar[Watts/(m^2)]", "[Watts/(m^2)]",""+this.lugar_nodo[4]+": Nodo 1");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo2_rad:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[2],fecha2,fecha2_2,medidas[3],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Radiación Solar[Watts/(m^2)]", "[Watts/(m^2)]",""+this.lugar_nodo[4]+": Nodo 2");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo3_rad:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[3],fecha2,fecha2_2,medidas[3],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Radiación Solar[Watts/(m^2)]", "[Watts/(m^2)]",""+this.lugar_nodo[4]+": Nodo 3");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo1_hum_plant:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[1],fecha2,fecha2_2,medidas[4],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Humedad Hoja[V]", "Humedad Hoja[V]",""+this.lugar_nodo[4]+": Nodo 1");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo2_hum_plant:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[2],fecha2,fecha2_2,medidas[4],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Humedad Hoja[V]", "Humedad Hoja[V]",""+this.lugar_nodo[4]+": Nodo 2");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo3_hum_plant:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[3],fecha2,fecha2_2,medidas[4],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Humedad Hoja[V]", "Humedad Hoja[V]",""+this.lugar_nodo[4]+": Nodo 3");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo1_bateria:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[1],fecha2,fecha2_2,medidas[5],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Porcentaje Batería", "Batería %",""+this.lugar_nodo[4]+": Nodo 1");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo2_bateria:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[2],fecha2,fecha2_2,medidas[5],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Porcentaje Batería", "Batería %",""+this.lugar_nodo[4]+": Nodo 2");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo3_bateria:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[3],fecha2,fecha2_2,medidas[5],funciones[1]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Porcentaje Batería", "Batería %",""+this.lugar_nodo[4]+": Nodo 3");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo1_tempsuelo:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[1],fecha3,fecha3_3,medidas[6],funciones[2]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Temperatura Suelo[C°]", "[C°]",""+this.lugar_nodo[4]+": Nodo 1");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo2_tempsuelo:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[2],fecha3,fecha3_3,medidas[6],funciones[2]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Temperatura Suelo[C°]", "[C°]",""+this.lugar_nodo[4]+": Nodo 2");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		case R.id.nodo3_tempsuelo:
			args = new Bundle();
			aux = new cargar_datos(this.lugar_nodo[0], this.lugar_nodo[3],fecha3,fecha3_3,medidas[6],funciones[2]);
			Array_datos = aux.get_datos();
			if(Array_datos.isEmpty()){
				Toast.makeText(getActivity(), "Datos no subidos", Toast.LENGTH_SHORT).show();
			}
			else{
			fragment = new FragmentOne(Array_datos, "Temperatura Suelo[C°]", "[C°]",""+this.lugar_nodo[4]+": Nodo 3");
			fragment.setArguments(args);
			frgManager = getFragmentManager();
			frgManager.beginTransaction().replace(R.id.content_frame, fragment)
			.commit();
			}
			break;
		}
	}
	
	public void updatelabel(TextView texto){
		String date = new SimpleDateFormat("yyyy-MM-dd").format(calender.getTime());
		texto.setText(date);
	}
	
	public void updatelabelall(TextView texto, TextView texto2, TextView texto3, TextView texto4, TextView texto5, TextView texto6){
		String date = new SimpleDateFormat("yyyy-MM-dd").format(calender.getTime());
		texto.setText(date);
		texto2.setText(date);
		texto3.setText(date);
		texto4.setText(date);
		texto5.setText(date);
		texto6.setText(date);
	}
	

	
	public void setDate(){
		new DatePickerDialog(getActivity(), d,
				calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH)).show();
		
	}
	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker arg0, int year, int month,
				int day) {
			
			calender.set(Calendar.YEAR, year);
			calender.set(Calendar.MONTH, month);
			calender.set(Calendar.DAY_OF_MONTH, day);
			updatelabel(text);
			
		}
	};

}
