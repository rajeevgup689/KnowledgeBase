package com.pb.demo.processor;

public class FileParserFactory {

	public static FileParser getObject(String format) throws Exception {
		if (format.equals("csv"))
			return new CSVFileParser();
		else
			throw new Exception("File format " + format + " not supported");
	}

}
