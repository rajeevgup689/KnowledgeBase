package com.rajeev.immutable;

public final class IMMutableClass {

	private final Integer intParam;

	private final String stringParam;

	public IMMutableClass(Integer intParam, String stringParam) {
		this.intParam = new Integer(intParam.intValue());
		this.stringParam = stringParam;
	}

	public static void main(String[] args) {
		IMMutableClass obj = new IMMutableClass(123, "abc");

		System.out.println("intParam: " + obj.getIntParam());
		System.out.println("stringParam: " + obj.getStringParam());
	}

	public Integer getIntParam() {
		return new Integer(intParam.intValue());
	}

	public String getStringParam() {
		return stringParam;
	}

}
