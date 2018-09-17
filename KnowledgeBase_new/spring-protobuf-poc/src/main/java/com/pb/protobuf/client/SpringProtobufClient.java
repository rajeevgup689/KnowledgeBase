package com.pb.protobuf.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SpringProtobufClient {

	public static void main(String[] args) {
		double start = System.currentTimeMillis();

		HttpURLConnection conn = null;
		try {

			URL COURSE1_URL = new URL("http://localhost:8080/courses/1");
			conn = (HttpURLConnection) COURSE1_URL.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			conn.disconnect();
		}

		double end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + " ms");
	}

}
