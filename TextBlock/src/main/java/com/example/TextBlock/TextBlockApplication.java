package com.example.TextBlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TextBlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextBlockApplication.class, args);

		String name = "John";

		String xml1 = """
                     <category>
                         <title>${name}</title>
                         <type>Software</type>
                         <year>1981</year>
                     </category>
                     """;
		String xml2 = """
                     <category>
                         <title>Microsoft</title>
                         <type>Software</type> \n
                         <year>nil</year> \t
                     </category>
                     """;

		System.out.println(xml1+xml2);


	}

}
