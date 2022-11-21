package com.angang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AService {
	@Autowired
	private BService bService;

	@Autowired
	private CService cService;

	public void out() {
		System.out.println(bService);
	}
}
