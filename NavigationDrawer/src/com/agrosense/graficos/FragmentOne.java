package com.agrosense.graficos;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.tutecentral.navigationdrawer.R;


import android.app.Fragment;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class FragmentOne extends Fragment {


	public ArrayList<clima> Array_datos = new ArrayList<clima>();
    private String variable;
    private String medida;
    private String Lugar;
	private GraphicalView mChart;

	public FragmentOne(ArrayList<clima> datos, String variable, String medida, String Lugar) {
		this.Array_datos = datos;
		this.variable = variable;
		this.medida = medida;
		this.Lugar = Lugar;
	}


	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.grafico, container,false);
		
		//Ordenar_Lista(Array_datos_copia);
		
		String[] titles = new String[] {Lugar};
		
		List<double[]> x = new ArrayList<double[]>();
		List<double[]> values = new ArrayList<double[]>();
		double [] ejex = new double [Array_datos.size()];
		double [] ejey = new double [Array_datos.size()];
		double [] ejey2 = new double[Array_datos.size()];

		
		for (int i = 0; i < Array_datos.size(); i++) {
			
			ejex[i] = Array_datos.get(i).gethora();
			ejey[i] = Array_datos.get(i).getvariable();
		
		}
		
		x.add(ejex);
		values.add(ejey);
		
		System.arraycopy(ejey, 0, ejey2, 0, ejey.length);
		
		Ordenar_Lista(ejey2);
	    
		int[] colors = new int[] {Color.GREEN};
	    
	    PointStyle[] styles = new PointStyle[] { PointStyle.DIAMOND};
		
	    XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
	    int length = renderer.getSeriesRendererCount();
	    
	    for (int i = 0; i < length; i++) {
	        ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
	     }
	    
	    setChartSettings(renderer, variable, "Horas", medida, 0, ejex[ejex.length-1] , ejey2[0]-1, ejey2[ejey2.length-1]+1, Color.LTGRAY, Color.LTGRAY);
	    renderer.setXLabelsColor(Color.YELLOW);
        renderer.setYLabelsColor(0, Color.YELLOW);
	    renderer.setXLabels(Array_datos.size());
	    renderer.setYLabels(Array_datos.size());
	    renderer.setShowGrid(true);
	    renderer.setXLabelsAlign(Align.RIGHT);
	    renderer.setYLabelsAlign(Align.RIGHT);
	    renderer.setZoomButtonsVisible(true);
	    renderer.setPanLimits(new double[] { -1, ejex[ejex.length-1]+1,ejey2[0]-1,ejey2[ejey2.length-1]+1});
	    renderer.setClickEnabled(true);
	    
	    XYMultipleSeriesDataset dataset = buildDataset(titles, x, values);

	    
	    LinearLayout chart_contenido = (LinearLayout)view.findViewById(R.id.chart);
	    
	    mChart = (GraphicalView)ChartFactory.getLineChartView(getActivity(), dataset, renderer);
	    
	    
	    mChart.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				
				SeriesSelection series_seleccion = mChart.getCurrentSeriesAndPoint();
				
					if(series_seleccion != null){
						
						double valor = series_seleccion.getValue();
						
						Toast.makeText(getActivity(), ""+valor, Toast.LENGTH_LONG).show();
					
						
					}
				
			}
		});
	    chart_contenido.addView(mChart);
		return view;
	}
	
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);
	}



	protected XYMultipleSeriesRenderer buildRenderer(int[] colors, PointStyle[] styles) {
		    XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		    setRenderer(renderer, colors, styles);
		    return renderer;
		  }
	  
	  protected void setRenderer(XYMultipleSeriesRenderer renderer, int[] colors, PointStyle[] styles) {
		    renderer.setAxisTitleTextSize(16);
		    renderer.setChartTitleTextSize(20);
		    renderer.setLabelsTextSize(15);
		    renderer.setLegendTextSize(15);
		    renderer.setPointSize(8f);
		    renderer.setMargins(new int[] { 20, 30, 15, 20 });
		    int length = colors.length;
		    for (int i = 0; i < length; i++) {
		      XYSeriesRenderer r = new XYSeriesRenderer();
		      r.setColor(colors[i]);
		      r.setPointStyle(styles[i]);
		      renderer.addSeriesRenderer(r);
		    }
		  }
	  
	  protected void setChartSettings(XYMultipleSeriesRenderer renderer, String title, String xTitle,
		      String yTitle, double xMin, double xMax, double yMin, double yMax, int axesColor,
		      int labelsColor) {
		    renderer.setChartTitle(title);
		    renderer.setXTitle(xTitle);
		    renderer.setYTitle(yTitle);
		    renderer.setXAxisMin(xMin);
		    renderer.setXAxisMax(xMax);
		    renderer.setYAxisMin(yMin);
		    renderer.setYAxisMax(yMax);
		    renderer.setAxesColor(axesColor);
		    renderer.setLabelsColor(labelsColor);
		  }
	  
	  protected XYMultipleSeriesDataset buildDataset(String[] titles, List<double[]> xValues,
		      List<double[]> yValues) {
		    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		    addXYSeries(dataset, titles, xValues, yValues, 0);
		    return dataset;
		  }
	  
	  public void addXYSeries(XYMultipleSeriesDataset dataset, String[] titles, List<double[]> xValues,
		      List<double[]> yValues, int scale) {
		    int length = titles.length;
		    for (int i = 0; i < length; i++) {
		      XYSeries series = new XYSeries(titles[i], scale);
		      double[] xV = xValues.get(i);
		      double[] yV = yValues.get(i);
		      int seriesLength = xV.length;
		      for (int k = 0; k < seriesLength; k++) {
		        series.add(xV[k], yV[k]);
		      }
		      dataset.addSeries(series);
		    }
		  }
	  
	  private void Ordenar_Lista (double [] vector){
		  
		  for (int i = 1; i < vector.length; i++) {
			for (int j = 0; j < vector.length-i; j++) {
				if (vector[j] > vector[j+1]) {
					double aux = vector[j];
					vector[j]=vector[j+1];
					vector[j+1] = aux;
					
				}	
			}
		  }	
	  }

}

