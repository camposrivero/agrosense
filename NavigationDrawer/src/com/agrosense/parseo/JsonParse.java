package com.agrosense.parseo;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.agrosense.graficos.clima;

import android.util.Log;

public class JsonParse {
	
    private static final String TAG_HORA = "Hour";
    private String medida;
    
    public ArrayList<clima> Array_datos = new ArrayList<clima>();
    
    private static String json = null;
	
	public JsonParse (String respuesta, String medida){
		JsonParse.json = respuesta;
		this.medida = medida;
	}
	
	public ArrayList<clima> datos_graficos (){
		
		if(json != null){
			
			try {
				JSONObject datos = new JSONObject(json);
				JSONArray datos2 = datos.getJSONObject("retval").getJSONArray("_firstBatch");
				
				for (int i=0 ; i<datos2.length(); i++){
					
					JSONObject objeto = datos2.getJSONObject(i);
                    String hora = objeto.getJSONObject("_id").getString(TAG_HORA);
                    String temp = objeto.getString(medida);
                    
                    double hora2 = Double.valueOf(hora).doubleValue();
                    double temp2 = Double.valueOf(temp).doubleValue();
                    
                    clima nodo = new clima();
                    nodo.Sethora(hora2);
                    nodo.Setvariable(temp2);
                    
                    Array_datos.add(nodo);
					
				}
			} catch (JSONException e) {
				e.printStackTrace();
			} 
			
		}else {
			  Log.e("Jsonparse", "No se obtuvo datos");
		}
		return Array_datos;
	}

}
