package com.ctci.designpatterns.singleton;

/**
 * Singleton pattern ensures that a class has only one instance, and
 * provides a global point of access to it.
 * @author sampath
 *
 */
public class Singleton_v3 {
	private static volatile Singleton_v3 uniqueInstance = null;

	private Singleton_v3() {

	}

	public static Singleton_v3 getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton_v3.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton_v3();
				}
			}
		}
		return uniqueInstance;
	}

}
