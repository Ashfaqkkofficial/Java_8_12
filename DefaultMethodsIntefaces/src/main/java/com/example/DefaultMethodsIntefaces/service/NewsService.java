package com.example.DefaultMethodsIntefaces.service;

import com.example.DefaultMethodsIntefaces.model.NewsArticle;
import com.example.DefaultMethodsIntefaces.model.RssFeedNewsArticle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Value("${rss.url.feed}")
    String rssFeedUrl;

    public List<NewsArticle> getFilteredArticles() {
        List<NewsArticle> filteredArticles = new ArrayList<>();
        try {
            URL feedUrl = new URL(rssFeedUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            for (SyndEntry entry : feed.getEntries()) {
                LocalDateTime publicationDate = entry.getPublishedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                NewsArticle article = new RssFeedNewsArticle(entry.getTitle(), entry.getDescription().getValue(), "INFOSYS", publicationDate);
                if (article.getCategory().equalsIgnoreCase("INFOSYS")) {
                    filteredArticles.add(article);
                    // Print details of the added article
                    article.printDetails();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredArticles;
    }
}
