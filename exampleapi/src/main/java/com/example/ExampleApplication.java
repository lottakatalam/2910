package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExampleApplication.class, args);
		String socialSecurityNumber = "301122A134F";
		String regexForDate = "^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[0-2])\\d{2}$";
		Pattern pattern = Pattern.compile(regexForDate);
		Matcher matcher = pattern.matcher(socialSecurityNumber.substring(0,6));
		System.out.println(matcher.matches());

		String regexForCentury = "[-+A]";
		Pattern pattern1 = Pattern.compile(regexForCentury);
		Matcher matcher1 = pattern1.matcher(socialSecurityNumber.substring(6,7));
		System.out.println(matcher1.matches());

		LocalDate birthDate = LocalDate.of(1899, 11, 30);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMyyyy");
		String formattedDate2 = birthDate.format(formatter2).substring(4,6);
		String correctCharacter = formattedDate2.matches("18") ? "+" : formattedDate2.matches("19") ? "-" : "A";
		System.out.println(correctCharacter);



	}

}
