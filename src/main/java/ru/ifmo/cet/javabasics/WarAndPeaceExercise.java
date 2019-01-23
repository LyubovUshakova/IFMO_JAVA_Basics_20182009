package ru.ifmo.cet.javabasics;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.charset.Charset;
import static java.nio.file.Files.readAllLines;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;


public class WarAndPeaceExercise {

    public static String warAndPeace() throws IOException {

            final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
            final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

            // TODO map lowercased words to its amount in text and concatenate its entries.
            // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
            // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
            // TODO Also omit any word with lengths less than 4 and frequency less than 10
            //throw new UnsupportedOperationException();
            Map<String, Integer> dictionary = new HashMap<>();
            Charset set = Charset.forName("windows-1251");
            List<String> book = readAllLines(tome12Path, set);
            book.addAll(readAllLines(tome34Path, set));
            String text = book.toString();
            text = text.replaceAll("[^a-zA-Zа-яА-Я]", " ").toLowerCase();
            Stream.of(text.split(" "))
                    .map(String::toString)
                    .filter(word -> word.length() > 3)
                    .forEach(word -> dictionary.put(word, dictionary.getOrDefault(word, 0) + 1));
            ArrayList<Map.Entry<String, Integer>> words = new ArrayList<>(dictionary.entrySet());
            words.sort(Comparator.comparing(Map.Entry::getKey));
            words.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
            String res = "";
            res = words.stream()
                    .filter(entry -> entry.getValue() > 9)
                    .map(entry -> entry.getKey() + " - " + entry.getValue())
                    .collect(Collectors.joining("\n"));

        //throw new UnsupportedOperationException();
            return res.trim();


    }

}