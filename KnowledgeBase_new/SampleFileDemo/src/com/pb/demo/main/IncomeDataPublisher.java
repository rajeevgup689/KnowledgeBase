package com.pb.demo.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.pb.demo.model.IncomeData;
import com.pb.demo.processor.FileParser;
import com.pb.demo.processor.FileParserFactory;
import com.pb.demo.util.Constants;
import com.pb.demo.util.Utility;

public class IncomeDataPublisher {

	public static void main(String args[]) {
		
		File fileObj = new File(Constants.filePath);
		try {
			String fileFormat = Utility.getFileFormat(fileObj,
					Constants.filePath);
			FileParser parser = FileParserFactory.getObject(fileFormat);
			Map<String, List<IncomeData>> data = parser.loadData(fileObj);
			File generatedFile = parser.generateFile(data,
					Constants.fileOutputPath);
			System.out.println("generate file is " + Constants.fileOutputPath);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
