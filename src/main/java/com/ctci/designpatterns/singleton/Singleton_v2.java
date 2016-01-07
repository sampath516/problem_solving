package com.ctci.designpatterns.singleton;

public class Singleton_v2 {
	private static Singleton_v2 uniqueInstance = new Singleton_v2();

	private Singleton_v2() {

	}

	public static Singleton_v2 getInstance() {
		return uniqueInstance;
	}
}
