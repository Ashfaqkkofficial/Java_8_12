package com.example.SwitchExpressions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwitchExpressionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwitchExpressionsApplication.class, args);

		var category = "INFOSYS";

		switch (category)
		{
			case "MICROSOFT","OTHER" ->
			{
				System.out.println("You selected MICROSOFT or OTHER");
			}
			case "MISC" -> System.out.println("You selected MISC");
			case "INFOSYS" -> System.out.println("Happy to hear that");
			default -> System.out.println("Nothing to show.....");
		}
		int rating = switch (category)
		{
			case "MICROSOFT","OTHER" ->
			{
				yield 4;
			}
			case "MISC" -> 2;
			case "INFOSYS" -> 10;
			default -> 0;
		};
		System.out.println("rating :"+rating);

		//if need to use : then yield is mandatory to use
		int ratings = switch (category)
		{
			case "MICROSOFT","OTHER" :
			{
				yield 4;
			}
			case "MISC" : yield 2;
			case "INFOSYS" : yield 10;
			default : yield 0;
		};
	}

}
