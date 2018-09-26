package com.pb.demo.processor;

import java.util.*;

import com.pb.demo.model.IncomeData;

import java.io.*;

public interface FileParser {
	public Map<String, List<IncomeData>> loadData(File obj);

	File generateFile(Map<String, List<IncomeData>> data, String outputFile);
}
