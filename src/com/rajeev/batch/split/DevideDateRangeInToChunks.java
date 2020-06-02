package com.rajeev.batch.split;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.javatuples.Pair;

public class DevideDateRangeInToChunks {
	private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");

	public static void main(String[] args) {
		String fromDateStr = "2020-05-21 01:00:01.324 +0530";
		String toDateStr = "2020-05-22 23:59:01.384 +0530";
		int chunks = 12;

		List<Pair<String, String>> dateRangeChunksList = getDateRangeChunks(fromDateStr, toDateStr, chunks);
		for(Pair dateRange : dateRangeChunksList) {
			System.out.print(dateRange.getValue0() + "\t");
			System.out.println(dateRange.getValue1());
		}
	}

	public static List<Pair<String, String>> getDateRangeChunks(String startDate, String endDate, int chunks) {
		int hours = findDateDifferenceInHours(startDate, endDate);
		System.out.println("hours: "+ hours);
		System.out.println("chunks: "+ chunks);
		System.out.println("hours%chunks: "+ hours%chunks);

		int hoursChunk = hours/chunks;
		System.out.println("hours/chunks: "+ hours/chunks);
		if(hours%chunks > 0) {
			hoursChunk++;
		}
		System.out.println("hoursChunk: " + hoursChunk);

		List<Pair<String, String>> dateRangeList = new ArrayList<>();
		String nextStartDate = startDate;
		String nextEndDate = startDate;
		for(int i = 1; i <= chunks; i++) {
			Pair<String, String> dateRangeChunk = null;
			if(i == chunks) {
				dateRangeChunk = Pair.with(nextStartDate, endDate);
			} else if (findDateDifferenceInMS(nextStartDate, endDate) < 0) {
				dateRangeList.remove(dateRangeList.size() -1);
				break;
			} else {
				try {
					sdf.setTimeZone(TimeZone.getDefault());
					nextEndDate = sdf.format(DateUtils.addHours(sdf.parse(nextStartDate), hoursChunk));
					dateRangeChunk = Pair.with(nextStartDate, nextEndDate);
					nextStartDate = nextEndDate;
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			dateRangeList.add(dateRangeChunk);
		}
		
		return dateRangeList;
	}
	
	private static long findDateDifferenceInMS(String startDate, String endDate) {
		Date d1 = null;
		Date d2 = null;
		try {
		    d1 = sdf.parse(startDate);
		    d2 = sdf.parse(endDate);
		} catch (Exception e) {
		    e.printStackTrace();
		}    

		// Get msec from each, and subtract.
		return (d2.getTime() - d1.getTime());
	}

	private static int findDateDifferenceInHours(String startDate, String endDate) {
		// Custom date format
		long diff = findDateDifferenceInMS(startDate, endDate);
		long diffSeconds = diff / 1000;         
		int diffHours = (int) (diff / (60 * 60 * 1000));                      
		
		if((diffSeconds - (diffHours * 60 * 60)) > 0) {
			System.out.println("Some seconds remaining");
			diffHours++;
		} else if((diff - (diffHours * 60 * 60 * 1000)) > 0) {
			System.out.println("Some miliseconds remaining");
			diffHours++;
		} else {
			System.out.println("No seconds remaining");
		}
		
		return diffHours;
	}

}
