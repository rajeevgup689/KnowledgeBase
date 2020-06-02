package com.pb.hoverfly.client.config;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HoverflyClientConfig {

	private static final int HOVERFLY_PORT = 8500;
	private static final String HOVERFLY_HOST = "localhost";
	private static final String PROXY = "proxy";

	@Bean
	public RestTemplate restTemplate() {

		String mode = System.getProperty("mode");
		System.out.println("##################### Mode ################# " + mode);

		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(HOVERFLY_HOST, HOVERFLY_PORT));
		requestFactory.setProxy(proxy);

		RestTemplate template = null;

		if (mode != null && mode.equalsIgnoreCase(PROXY)) {
			System.out.println(
					"######### Running application in PROXY mode so that we can use simulated hoverfly server!!!!");
			template = new RestTemplate(requestFactory);
		} else {
			System.out.println(
					"######### Running application in PRODUCTION mode so that we can use simulated hoverfly server!!!!");
			template = new RestTemplate();
		}

		return template;
	}

}
