package com.agrosense.graficos;

public class clima {
	
	private double variable;
	private double hora;
	
	public void Setvariable(double variable){
		this.variable = variable;
	}
	
	public void Sethora(double hour){
		this.hora = hour;
	}
	
	public double getvariable(){
		return this.variable;
	}
	
	public double gethora(){
		return this.hora;
	}
	


}
