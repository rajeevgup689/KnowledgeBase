package com.pb.demo.test;

import java.io.File;

import org.junit.Test;

import com.pb.demo.util.Utility;

import junit.framework.Assert;

public class CSVUtilsTest {
	public static final String inputFileName="./datafile/CapitaIncome.csv";

	@Test
	public void test_file_format() throws Exception {

		String actualResult = "csv";
		File fileObj = new File(inputFileName);
		String fileFormat = Utility.getFileFormat(fileObj, inputFileName);
		Assert.assertEquals(actualResult, fileFormat);
	}

}
