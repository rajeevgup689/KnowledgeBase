package com.pb.demo.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.pb.demo.model.GenderValue;
import com.pb.demo.model.IncomeData;
import com.pb.demo.util.Utility;

public class CSVFileParser implements FileParser {
	DecimalFormat dtime = new DecimalFormat("#.##");

	@Override
	public Map<String, List<IncomeData>> loadData(File obj) {
		Map<String, List<IncomeData>> map = new TreeMap<String, List<IncomeData>>();
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		try {

			br = new BufferedReader(new FileReader(obj));
			line = br.readLine(); // skip header
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] rowData = line.split(csvSplitBy);
				if (rowData.length == 0) {
					break;
				}
				String cityOrCountry = (rowData[1] != null && !rowData[1].isEmpty()) ? rowData[1] : rowData[0];

				double convertedAverage = Utility.currencyConverter(rowData[3], Integer.parseInt(rowData[4]));
				convertedAverage = Double.valueOf(dtime.format(convertedAverage));

				if (map.containsKey(cityOrCountry)) {
					List<IncomeData> ll = map.get(cityOrCountry);
					ll.add(new IncomeData(rowData[0], rowData[1], rowData[2], rowData[3], convertedAverage));
				} else {
					List<IncomeData> list = new ArrayList<IncomeData>();
					list.add(new IncomeData(rowData[0], rowData[1], rowData[2], rowData[3], convertedAverage));
					map.put(cityOrCountry, list);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return map;
	}

	public File generateFile(Map<String, List<IncomeData>> data, String outputFile) {
		File file = null;
		try {
			// City/Country Gender Average Income(in USD)

			file = new File(outputFile);
			FileWriter writer = new FileWriter(file, false);

			writer.append("City/Country");
			writer.append(',');

			writer.append("Gender");
			writer.append(',');
			writer.append("Average Income(in USD)");
			writer.append('\n');

			// generate data now
			for (String key : data.keySet()) {
				List<IncomeData> rowData = data.get(key);
				GenderValue v = getIncomeByGender(rowData);

				writer.append(key);
				writer.append(',');
				writer.append("F");
				writer.append(',');
				writer.append(String.valueOf(v.getF()));
				
				writer.append('\n');
				
				writer.append(key);
				writer.append(',');
				writer.append("M");
				writer.append(',');
				writer.append(String.valueOf(v.getM()));

				writer.append('\n');

			}
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}

	private GenderValue getIncomeByGender(List<IncomeData> list) {
		double f = 0.0;
		double m = 0.0;
		for (IncomeData i : list) {
			if (i.getGender().equals("F")) {
				f = f + i.getAverageIncome();
			} else if (i.getGender().equals("M"))
				m = m + i.getAverageIncome();
		}
		
		return new GenderValue(m, f);
	}

}