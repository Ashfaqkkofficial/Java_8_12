package com.example.DateAndTImeAPI;

import com.example.DateAndTImeAPI.model.NewsArticle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DateAndTImeApiApplication {

	@Value("${rss.url.feed}")
	String rssFeedUrl;

	public static void main(String[] args) {
		SpringApplication.run(DateAndTImeApiApplication.class, args);
	}

	@Bean
	public List<NewsArticle> articles() throws Exception {
		List<NewsArticle> articles = new ArrayList<>();
		URL feedUrl = new URL(rssFeedUrl);
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(feedUrl));
		for (SyndEntry entry : feed.getEntries()) {
			NewsArticle article = new NewsArticle();
			article.setTitle(entry.getTitle());
			article.setDescription(entry.getDescription().getValue());
			article.setCategory("INFOSYS");
			articles.add(article);
		}
		NewsArticle article = new NewsArticle();
		article.setTitle("AI is the new tool, a neural reasoning engine that can give us predictive power");
		article.setDescription("If you take 70 years of computing, one of the dreams has always been: Can we create computers that can understand us versus us understanding computers? I think we may be finally there with the breakthrough of natural language,");
		article.setCategory("MICROSOFT");
		articles.add(article);
		return articles;
	}
}