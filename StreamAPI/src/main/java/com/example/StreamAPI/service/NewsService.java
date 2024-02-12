package com.example.StreamAPI.service;

import com.example.StreamAPI.model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NewsService
{
    private final List<NewsArticle> articles;

    public NewsService(List<NewsArticle> articles)
    {
        this.articles = articles;
    }

    public List<NewsArticle> getFilterArticle(String category)
    {
        List<NewsArticle> filteredArticles = new ArrayList<>();
        for (NewsArticle article : articles) {
            if (article.getCategory().equals(category.trim())) {
                filteredArticles.add(article);
            }
        }

        return articles.stream()
                .filter(n -> n.getCategory().equals(category.trim()))
                .collect(Collectors.toList());
    }

    public void getStreamAll() {



        // Filtering
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers1.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Filtering :"+evenNumbers); // Output: [2, 4]

        // Mapping
        List<String> names1 = Arrays.asList("John", "Alice", "Bob");
        List<String> upperCaseNames = names1.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Mapping :"+upperCaseNames); // Output: [JOHN, ALICE, BOB]

        // Sorting
        List<Integer> numbers2 = Arrays.asList(5, 2, 8, 1, 3);
        List<Integer> sortedNumbers = numbers2.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorting :"+sortedNumbers); // Output: [1, 2, 3, 5, 8]

        // Reducing
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers3.stream()
                .reduce(0, Integer::sum);
        System.out.println("Reducing :"+sum); // Output: 15





        // Collecting
        List<String> names2 = Arrays.asList("John", "Alice", "Bob");
        String concatenatedNames = names2.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Collecting :"+concatenatedNames); // Output: John, Alice, Bob

        // Grouping
        List<String> names3 = Arrays.asList("John", "Alice", "Bob", "Alex");
        Map<Character, List<String>> groupedNames = names3.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Grouping :"+groupedNames); // Output: {A=[Alice], B=[Bob], J=[John]}

        // Parallel Processing
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
        int sumParallel = numbers4.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println("Parallel :"+sumParallel); // Output: 15

        // FlatMapping
        List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<Integer> flattenedNumbers = nestedNumbers.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("FlatMapping :"+flattenedNumbers); // Output: [1, 2, 3, 4]
    }




}
