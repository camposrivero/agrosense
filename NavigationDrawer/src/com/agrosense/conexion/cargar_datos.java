package com.agrosense.conexion;

import java.util.ArrayList;



import com.agrosense.graficos.clima;
import com.agrosense.parseo.JsonParse;


import android.os.AsyncTask;
import android.util.Log;


public class cargar_datos{
	
	public ArrayList<clima> Array_datos = new ArrayList<clima>();
	private static String url = "http://www.geoespacial.ucm.cl:27080/procedures/_cmd";
	private String fecha, fecha2;
	
	private String medida;
	private String funcion;
	
	private String lugar;
	private String Nodo;

	///////////////////////////////////////////////////
	public String item_name ="";
	
	public cargar_datos (String lugar,String Nodo,String fecha, String fecha2, String medida, String funcion){
		this.Nodo = Nodo;
		this.fecha = fecha;
		this.fecha2 = fecha2;
		this.lugar = lugar;
		this.medida = medida;
		this.funcion = funcion;
		
		datos_url aux = new datos_url();
		aux.execute();
		try{
			aux.get();
		}catch(Exception e){
			Log.w("mensaje:", " > Error en conexion");
		}
		
	}
	
	
	public class datos_url extends AsyncTask<Void, Integer, ArrayList<clima>>{
		

		protected void onPreExecute() {
			

		}

		protected ArrayList<clima> doInBackground(Void... arg0) {
			
					ServiceHandler conexion = new ServiceHandler();
					String json = conexion.post(url, funcion, lugar , Nodo, fecha, fecha2);

						Log.d("respuesta", ">" + json);
						JsonParse datos = new JsonParse(json, medida);
						Array_datos = datos.datos_graficos();
				

			return  Array_datos;
		}

		protected void onPostExecute(ArrayList<clima> result) {

			Array_datos = result;
			
		}
	}
	public ArrayList<clima> get_datos(){
		
		return Array_datos;
	}
	
	
//	private class progreso extends AsyncTask<Integer, Integer, Integer> {
//
//        	protected void onPreExecute() {
//
//
//               pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//
//               pDialog.setMessage("Calculando...");
//
//               pDialog.setCancelable(false);
//
//               pDialog.setMax(100);
//
//               pDialog.setProgress(0);
//
//               pDialog.show();
//
//        }
//
//        @Override protected Integer doInBackground(Integer... n) {
//
//               int res = 1;
//
//               for (int i = 1; i <= n[0]; i++) {
//
//                      res *= i;
//
//                      SystemClock.sleep(1000);
//
//                      publishProgress(i*100 / n[0]);
//
//               }
//
//               return res;
//
//        }
//
//        @Override protected void onProgressUpdate(Integer... porc) {
//
//               pDialog.setProgress(porc[0]);
//
//        }
//
//        @Override protected void onPostExecute(Integer res) {
//
//               pDialog.dismiss();
//
//               //salida.append(res + "\n");
//
//        }
//
//  }


	
}
