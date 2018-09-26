package com.pb.demo.model;

public class GenderValue {
	private double f=0.0;
	private double m=0.0;
	
	public GenderValue() {
	}
	public GenderValue(double m,double f) {
		this.m=m;
		this.f=f;
	}
	public double getF() {
		return f;
	}
	public void setF(double f) {
		this.f = f;
	}
	public double getM() {
		return m;
	}
	public void setM(double m) {
		this.m = m;
	}
}
