package com.simplilearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class BankAppRestMysqlJdbcApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankAppRestMysqlJdbcApplication.class, args);
		List<String> names = Arrays.asList("vinodh","kumar","mahendra");

		List<Integer> namesLengths = names.stream()
				.map(String::length)
				.collect(Collectors.toList());

		for  ( Integer e: namesLengths) {
			System.out.println(e);
		}

		List<List<String>> nestedNames = Arrays.asList(
				Arrays.asList("vinod","kumar"),
				Arrays.asList("bhavya","vinodh")
		);

		List<String> allNames = nestedNames.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

		System.out.println(allNames);

	}

}
