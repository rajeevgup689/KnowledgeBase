package com.rajeev.batch.split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtractBatch {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("str1", "str2", "str3", "str4", "str5", "str6", "str7", "str8", "str9",
				"str10", "str11", "str12", "str13");

		int batchSize = 5;
		List<List<String>> strBatchList = getBatches(stringList,
				batchSize );
		
		strBatchList.forEach(str -> {
			System.out.println(str.toString());
		});
	}

	public static <T> List<List<T>> getBatches(List<T> collection, int batchSize) {
		int i = 0;
		List<List<T>> batches = new ArrayList<List<T>>();
		while (i < collection.size()) {
			int nextInc = Math.min(collection.size() - i, batchSize);
			List<T> batch = collection.subList(i, i + nextInc);
			batches.add(batch);
			i = i + nextInc;
		}

		return batches;
	}

}
