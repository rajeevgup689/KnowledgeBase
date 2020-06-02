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

public class DevideDateRangeInToChunks2 {
	private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");

	public static void main(String[] args) {
		String fromDateStr = "2020-05-21 16:00:01.324 +0530";
		String toDateStr = "2020-05-21 23:59:01.324 +0530";
		int chunkHours = 4;

		List<Pair<String, String>> dateRangeChunksList = getDateRangeChunks(fromDateStr, toDateStr, chunkHours);
		for(Pair dateRange : dateRangeChunksList) {
			System.out.print(dateRange.getValue0() + "\t");
			System.out.println(dateRange.getValue1());
		}
	}

	public static List<Pair<String, String>> getDateRangeChunks(String startDate, String endDate, int chunkHours) {
		List<Pair<String, String>> dateRangeList = new ArrayList<>();
		
		String nextStartDate = startDate;
		String nextEndDate = startDate;
		while(Boolean.TRUE) {
			if(findDateDifferenceInMS(nextStartDate, endDate) > 0) {
				Pair<String, String> dateRangeChunk = null;
				try {
					sdf.setTimeZone(TimeZone.getDefault());
					nextEndDate = sdf.format(DateUtils.addHours(sdf.parse(nextStartDate), chunkHours));
					if(findDateDifferenceInMS(nextEndDate, endDate) <= 0) {
						nextEndDate = endDate;
						//break;
					}
					dateRangeChunk = Pair.with(nextStartDate, nextEndDate);
					nextStartDate = nextEndDate;
					
					dateRangeList.add(dateRangeChunk);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
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

}
