package com.pb.prptobuf;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.googlecode.protobuf.format.JsonFormat;
import com.pb.protobuf.SpringProtobufPocApplication;
import com.pb.protobuf.student.StudentProtobuf.Course;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringProtobufPocApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringProtobufPocApplicationTests {

	private static final String COURSE1_URL = "http://localhost:8080/courses/1";

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void whenUsingRestTemplate_thenSucceed() {
		double start = System.currentTimeMillis();

		ResponseEntity<Course> course = restTemplate.getForEntity(COURSE1_URL, Course.class);
		System.out.println(course.toString());
		assertResponse(course.toString());

		double end = System.currentTimeMillis();
		System.out.println(
				"Time taken (when using rest template): " + TimeUnit.SECONDS.convert((long) (end - start), TimeUnit.MILLISECONDS) + " secs");
	}

	@Test
	public void whenUsingHttpClient_thenSucceed() throws IOException {
		double start = System.currentTimeMillis();
		
		InputStream responseStream = executeHttpRequest(COURSE1_URL);
		String jsonOutput = convertProtobufMessageStreamToJsonString(responseStream);
		System.out.println(jsonOutput);
		assertResponse(jsonOutput);
		
		double end = System.currentTimeMillis();
		System.out.println(
				"Time taken (when using http client): " + TimeUnit.SECONDS.convert((long) (end - start), TimeUnit.MILLISECONDS) + " secs");
	}

	private InputStream executeHttpRequest(String url) throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(request);
		return httpResponse.getEntity().getContent();
	}

	private String convertProtobufMessageStreamToJsonString(InputStream protobufStream) throws IOException {
		JsonFormat jsonFormat = new JsonFormat();
		Course course = Course.parseFrom(protobufStream);
		return jsonFormat.printToString(course);
	}

	private void assertResponse(String response) {
		assertThat(response, containsString("id"));
		assertThat(response, containsString("course_name"));
		assertThat(response, containsString("REST with Spring"));
		assertThat(response, containsString("student"));
		assertThat(response, containsString("first_name"));
		assertThat(response, containsString("last_name"));
		assertThat(response, containsString("email"));
		assertThat(response, containsString("john.doe@baeldung.com"));
		assertThat(response, containsString("richard.roe@baeldung.com"));
		assertThat(response, containsString("jane.doe@baeldung.com"));
		assertThat(response, containsString("phone"));
		assertThat(response, containsString("number"));
		assertThat(response, containsString("type"));
	}

}
