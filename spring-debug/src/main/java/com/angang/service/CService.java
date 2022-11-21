package com.angang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CService {
	@Autowired
	private AService aService;

	public void out() {
		System.out.println(aService);
	}
}
