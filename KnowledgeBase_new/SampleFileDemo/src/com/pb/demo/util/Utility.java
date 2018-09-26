package com.pb.demo.util;

import java.io.File;

public class Utility {

	public static String getFileFormat(File obj, String fileName) throws Exception {
		if (obj.exists()) {
			String extension = "";
			int i = fileName.lastIndexOf('.');
			if (i >= 0) {
				extension = fileName.substring(i + 1);
			}
			System.out.println("File extension is " + extension);

			return extension;
		} else
			throw new Exception("File " + fileName + " does not exist  ");
	}

	public static double currencyConverter(String currency, int amount) {

		if (Currency.HKD.name().equals(currency)) {
			double result = amount / Currency.HKD.value;
			return result;
		}
		if (Currency.GBP.name().equals(currency)) {
			double result = amount / Currency.GBP.value;
			return result;
		}
		if (Currency.INR.name().equals(currency)) {
			double result = amount / Currency.INR.value;
			return result;
		}
		if (Currency.SGP.name().equals(currency)) {
			double result = amount / Currency.SGP.value;
			System.out.println("SGD " + result + " amount " + amount + " Currency.SGD.value " + Currency.SGP.value);
			return result;
		}
		if (Currency.USD.name().equals(currency)) {
			double result = amount / Currency.USD.value; // no need to devide as currency is already in USD and it's
															// value is 1
			return result;
		}

		return 0;
	}

}
