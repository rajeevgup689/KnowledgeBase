package com.pb.demo.processor;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.pb.demo.model.IncomeData;

public interface FileParser {
	public Map<String, List<IncomeData>> loadData(File obj);

	File generateFile(Map<String, List<IncomeData>> data, String outputFile);
}
