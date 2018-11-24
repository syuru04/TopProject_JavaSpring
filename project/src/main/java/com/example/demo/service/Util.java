package com.example.demo.service;

import java.security.MessageDigest;

public class Util {
	private static MessageDigest digest;

	static {
		try {
			digest = MessageDigest.getInstance("SHA-256");	
		} catch (Exception e) {
		}
	}

	public static byte[] encrypt(String s) {
		try {
			return digest.digest(s.getBytes("ISO-8859-1"));
		} catch (Exception e) {
			return null;
		}
	}
}