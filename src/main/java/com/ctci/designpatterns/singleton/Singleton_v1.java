package com.ctci.designpatterns.singleton;

public class Singleton_v1 {
	private static Singleton_v1 uniqueInstance = null;

	private Singleton_v1() {

	}

	public static synchronized Singleton_v1 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton_v1();
		}
		return uniqueInstance;
	}

}
