package com.pb.demo.model;

public class IncomeData {
	private String country;
	private String city;
	private String gender;
	private String currency;
	private double averageIncome;

	public IncomeData() {
	}

	public IncomeData(String city, String country, String gender,
			String currency, double averageIncome) {
		this.country = country;
		this.city = city;
		this.gender = gender;
		this.currency = currency;
		this.averageIncome = averageIncome;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAverageIncome() {
		return averageIncome;
	}

	public void setAverageIncome(double averageIncome) {
		System.out.println("setting average income " + averageIncome);
		this.averageIncome = averageIncome;
	}

}
