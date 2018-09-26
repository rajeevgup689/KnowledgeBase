package com.pb.demo.test;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

import com.pb.demo.util.Utility;

public class CSVUtilsTest {
	private static final String filePath = "C:\\Users\\indiahiring\\Desktop\\rajeevgupta\\datafile\\CapitaIncome.csv";

	@Test
	public void test_file_format() throws Exception {

		String actualResult = "csv";
		File fileObj = new File(filePath);
		String fileFormat = Utility.getFileFormat(fileObj, filePath);
		Assert.assertEquals(actualResult, fileFormat);
	}

}
