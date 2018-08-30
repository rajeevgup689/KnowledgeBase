package com.rajeev.concurrent.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentExample {

	public static class ListCallable implements Callable<RequestResponse> {

		private RequestResponse reqRes;
		
		public ListCallable(RequestResponse reqRes) {
			super();
			this.reqRes = reqRes;
		}

		@Override
		public RequestResponse call() throws Exception {

			System.out.println("Inside call method !");
			// Do whatever want to do here
			System.out.println(reqRes.toString());
			return reqRes;
		}

	}

	public static class RequestResponse {
		private String request;
		private String response;
		private String inputParam;
		private String error;
		private List<String> errorList;

		public RequestResponse(String request, String inputParam) {
			super();
			this.request = request;
			this.inputParam = inputParam;
		}

		public String getRequest() {
			return request;
		}

		public void setRequest(String request) {
			this.request = request;
		}

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		public String getInputParam() {
			return inputParam;
		}

		public void setInputParam(String inputParam) {
			this.inputParam = inputParam;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public List<String> getErrorList() {
			return errorList;
		}

		public void setErrorList(List<String> errorList) {
			this.errorList = errorList;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("RequestResponse [request=").append(request).append(", response=").append(response)
					.append(", inputParam=").append(inputParam).append(", error=").append(error).append(", errorList=")
					.append(errorList).append("]");
			return builder.toString();
		}
	}

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("Rajeev", "Rippon", "Gupta", "Jalali", "Ambrish", "Soni", "etc.");

		ExecutorService es = null;

		int processors = Runtime.getRuntime().availableProcessors();
		int nThreads = (processors * 5);
		System.out.println("Number of processors: " + processors + " number of threads: " + nThreads);

		es = Executors.newFixedThreadPool(nThreads);

		CompletionService<RequestResponse> service = new ExecutorCompletionService<>(es);

		stringList.forEach(item -> {
			service.submit(new ListCallable(new RequestResponse(item, "Param " + item)));
		});
		
		for (int index = 0; index < stringList.size(); index++) {
			try {
				RequestResponse reqRes = service.take().get();
				
				System.out.println("After call, reqRes: "+ reqRes.toString());
				
			} catch (InterruptedException | ExecutionException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} finally {
				if (es != null) {
					es.shutdownNow();
				}
			}
			
		}
	}

}
