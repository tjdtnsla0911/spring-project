package com.cos.jwtex01.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		System.out.println(bc.encode("123"));
		System.out.println(bc.encode("123"));
		System.out.println(bc.encode("123"));

		System.out.println(bc.matches("123", "$2a$10$tKxLtCHJfmFceyUyTjYYmuHKpEkGZL4muUR8Gfol4clZG8XsS2cDC"));

	}
}
