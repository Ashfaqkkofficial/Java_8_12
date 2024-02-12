package com.example.LocalVariableInference;

import com.example.LocalVariableInference.model.NewsArticle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LocalVariableInferenceApplication {

	@Value("${rss.url.feed}")
	String rssFeedUrl;

	public static void main(String[] args) {
		SpringApplication.run(LocalVariableInferenceApplication.class, args);
	}

	@Bean
	public List<NewsArticle> articles() {
		var articles = new ArrayList<NewsArticle>();
		try {
			var feedUrl = new URL(rssFeedUrl);
			try (var reader = new XmlReader(feedUrl)) {
				var input = new SyndFeedInput();
				var feed = input.build(reader);
				for (var entry : feed.getEntries()) {
					var article = new NewsArticle();
					article.setTitle(entry.getTitle());
					article.setDescription(entry.getDescription().getValue());
					article.setCategory("INFOSYS");
					articles.add(article);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// Handle exception (e.g., log it or throw a custom exception)
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle exception (e.g., log it or throw a custom exception)
		}
		return articles;
	}
}
