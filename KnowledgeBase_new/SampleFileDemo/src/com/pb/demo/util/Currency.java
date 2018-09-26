package com.pb.demo.util;

public enum Currency {
	HKD(8.0), SGP(1.5), GBP(0.67), INR(66.0), USD(1.0);

	double value;

	Currency(double x) {
		value = x;
	}

	public double getValue() {
		return value;
	}

}
